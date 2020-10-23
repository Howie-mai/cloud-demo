package com.mh.springcloud.service;

import com.mh.springcloud.entities.CommonResult;
import com.mh.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * ClassName：
 * Time：20/9/16 下午3:43
 * Description：
 *
 * @author mh
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE",fallback = OrderHystrixFallBack.class)
public interface OrderFeignService {

    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getById(@PathVariable(name = "id") Long id);

    @GetMapping("/payment/timeout")
    String getPort();

    @RequestMapping("/insertPaymentInfo")
    String test5(@RequestParam(name = "name",required = false) Integer flag);

    @RequestMapping("/selectByModelSelective")
    String selectByModelSelective();
}
