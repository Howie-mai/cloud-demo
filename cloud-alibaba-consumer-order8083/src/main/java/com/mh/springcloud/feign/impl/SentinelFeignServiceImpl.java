package com.mh.springcloud.feign.impl;

import com.mh.springcloud.entities.CommonResult;
import com.mh.springcloud.entities.Payment;
import com.mh.springcloud.feign.SentinelFeignService;
import org.springframework.stereotype.Component;

/**
 * ClassName：
 * Time：20/10/12 下午3:50
 * Description：
 *
 * @author mh
 */
@Component
public class SentinelFeignServiceImpl implements SentinelFeignService  {

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(500,"open feign自定义fallback方法",new Payment(id,"error"));
    }
}
