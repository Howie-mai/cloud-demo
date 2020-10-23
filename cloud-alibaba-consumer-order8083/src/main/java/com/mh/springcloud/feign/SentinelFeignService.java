package com.mh.springcloud.feign;

import com.mh.springcloud.entities.CommonResult;
import com.mh.springcloud.entities.Payment;
import com.mh.springcloud.feign.impl.SentinelFeignServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * ClassName：
 * Time：20/10/12 下午3:46
 * Description：
 *
 * @author mh
 */
@Component
@FeignClient(value = "nacos-payment-provider",fallback = SentinelFeignServiceImpl.class)
public interface SentinelFeignService {
    @GetMapping(value = "/paymentSQL/{id}")
    CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
