package com.mh.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ClassName：
 * Time：20/9/18 下午4:23
 * Description：
 *
 * @author mh
 */
@Component

@FeignClient(value = "CLOUD-HYSTRIX-PAYMENT-SERVICE",fallback = OrderHystrixFallBack.class)
public interface OrderHystrixService {

    @RequestMapping("/hystrix/payment/timeout/{id}")
    String timeOut(@PathVariable(name = "id") Integer id, @RequestParam(name = "timeout") Integer timeout);
}
