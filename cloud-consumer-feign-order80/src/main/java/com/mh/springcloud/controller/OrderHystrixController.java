package com.mh.springcloud.controller;

import com.mh.springcloud.service.OrderHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName：
 * Time：20/9/18 下午4:24
 * Description：
 *
 * @author mh
 */
@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "globalFallBackMethod")
public class OrderHystrixController {

    @Autowired
    private OrderHystrixService orderHystrixService;

    @RequestMapping("/consumer/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutFallBackMethod",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })
//    @HystrixCommand
    public String timeOut(@PathVariable(name = "id") Integer id, @RequestParam(name = "timeout") Integer timeout){
//        int a = 10/0;
        return orderHystrixService.timeOut(id,timeout);
    }

//    public String paymentInfoTimeoutFallBackMethod(Integer id,Integer timeout){
//        return "线程池： " + Thread.currentThread().getName() + " 别人很繁忙，别再调用了  " + id + "\t" + "o(╥﹏╥)o嘤嘤嘤";
//    }
//
//    public String globalFallBackMethod(){
//        return "线程池： " + Thread.currentThread().getName() + " 通用降级方法：别人很繁忙，别再调用了  " + "\t" + "o(╥﹏╥)o嘤嘤嘤";
//    }
}
