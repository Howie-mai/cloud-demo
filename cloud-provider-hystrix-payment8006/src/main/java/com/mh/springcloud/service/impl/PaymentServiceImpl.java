package com.mh.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.mh.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

/**
 * ClassName：
 * Time：20/8/19 下午5:51
 * Description：
 *
 * @author mh
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    /**
     * 正常访问
     */
    @Override
    public String paymentInfo(Integer id) {
        return "线程池：  " + Thread.currentThread().getName() + "payment_ok_" + id + "\t" + "^_^哈哈";
    }

    /**
     * 模拟出错
     */
    @Override
    /**
     * 服务降级，配置该方法超时时间为3000ms，当超过3000ms,会执行 fallbackMethod 的兜底方法进行返回
     * 当超时或者出现异常会执行fallback的方法
     */
    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfoTimeout(Integer id, Integer timeout) {
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        int a = 10 / 0;
        long end = System.currentTimeMillis();
        return "线程池：  " + Thread.currentThread().getName() + "payment_time_out_" + id + "\t" + "(*^▽^*)开心" + "耗时：" + (end - start) + "ms";
    }

    public String paymentInfoTimeoutHandler(Integer id, Integer timeout) {
        return "线程池：  " + Thread.currentThread().getName() + "    系统繁忙，请稍后再试试    " + id + "\t" + "o(╥﹏╥)o嘤嘤嘤";
    }

    /**
     * ===== 服务熔断
     */
    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),          //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),    //请求数达到后才计算
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //休眠时间窗
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),  //错误率达到多少跳闸
    })
    public String paymentCircuitBreaker(int id) {
        if (id < 0) {
            throw new RuntimeException();
        }
        return "流水号:  " + IdUtil.simpleUUID() + "  id  " + id;
    }

    public String paymentCircuitBreakerFallback(int id) {
        return "嘤嘤嘤o(╥﹏╥)o" + "id  " + id;
    }
}
