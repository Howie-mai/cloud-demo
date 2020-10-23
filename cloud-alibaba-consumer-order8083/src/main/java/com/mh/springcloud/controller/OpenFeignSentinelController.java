package com.mh.springcloud.controller;

import com.mh.springcloud.entities.CommonResult;
import com.mh.springcloud.entities.Payment;
import com.mh.springcloud.feign.SentinelFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName：
 * Time：20/10/12 下午3:49
 * Description：
 *
 * @author mh
 */
@RestController
@Slf4j
public class OpenFeignSentinelController {
    @Autowired
    private SentinelFeignService sentinelFeignService;

    @RequestMapping("/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable(name = "id") Long id){
        CommonResult<Payment> result = sentinelFeignService.paymentSQL(id);
//        if (id == 4) {
//            throw new IllegalArgumentException("IllegalArgument ,非法参数异常...");
//        } else if (result.getData() == null) {
//            throw new NullPointerException("NullPointerException,该ID没有对应记录，空指针异常");
//        }
        return result;
    }
}
