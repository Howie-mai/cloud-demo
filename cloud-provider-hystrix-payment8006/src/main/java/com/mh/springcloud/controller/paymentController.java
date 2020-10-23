package com.mh.springcloud.controller;

import com.mh.springcloud.entities.CommonResult;
import com.mh.springcloud.entities.Payment;
import com.mh.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName：
 * Time：20/8/19 下午5:54
 * Description：
 *
 * @author mh
 */
@RestController
@RequestMapping("/hystrix/payment")
@Slf4j
public class paymentController {


    private int count = 1;
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/ok/{id}")
    public String ok(@PathVariable(name = "id") Integer id){
        return paymentService.paymentInfo(id);
    }

    @RequestMapping("/timeout/{id}")
    public String timeOut(@PathVariable(name = "id") Integer id,@RequestParam(name = "timeout") Integer timeout){
        return paymentService.paymentInfoTimeout(id,timeout);
    }

    /**
     * ===服务熔断
     * 多次错误后，然后慢慢正确，发现刚开始不满足条件，后面就算是正确的访问也会报错，需要过会才能恢复正常
     * 三种状态：
     * 开：请求不再进行调用当前服务，内部设置时钟一般为MTTR（平均故障处理时间），当打开时长达到所设时钟则进入半熔断状态
     *
     * 半开：部分请求根据规则调用当前服务，如果请求成功且符合规则则认为当前服务恢复正常，关闭熔断
     *
     * 关：熔断关闭不会对服务进行熔断
     */
    @RequestMapping("/circuit/get/{id}")
    public String circuit(@PathVariable(name = "id") Integer id){
        System.out.println(count++);
        return paymentService.paymentCircuitBreaker(id);
    }
}
