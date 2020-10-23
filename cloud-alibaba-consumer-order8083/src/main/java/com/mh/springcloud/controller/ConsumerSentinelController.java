package com.mh.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.mh.springcloud.entities.CommonResult;
import com.mh.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * ClassName：
 * Time：20/10/12 下午3:00
 * Description：
 *
 * @author mh
 */
@RestController
@Slf4j
public class ConsumerSentinelController {
    @Value("${service-url.nacos-user-service}")
    private String paymentUrl;

    @Resource
    private RestTemplate restTemplate;

    /**
     * fallback只管异常，blockHandler只管配置违规
     * 两个都配置，在没触发sentinel配置的规则，会一直返回fallback，触发后就会返回blockHandler
     * exceptionsToIgnore 忽略该异常，不再执行fallback
     */
    @RequestMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback")
//    @SentinelResource(value = "fallback",fallback = "handlerFallBack")
//    @SentinelResource(value = "fallback",blockHandler = "handlerBlock")
    @SentinelResource(value = "fallback",fallback = "handlerFallBack",blockHandler = "handlerBlock",
                    exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult<Payment> fallback(@PathVariable Long id) {
        CommonResult<Payment> result = restTemplate.getForObject(paymentUrl + "/paymentSQL/" + id, CommonResult.class, id);
        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgument ,非法参数异常...");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException,该ID没有对应记录，空指针异常");
        }
        return result;
    }
    public CommonResult<Payment> handlerFallBack(Long id,Throwable e) {
        return new CommonResult<>(500,"出现了异常，返回 fallback 的值",new Payment(id,e.getLocalizedMessage()));
    }
    public CommonResult<Payment> handlerBlock(Long id, BlockException e) {
        return new CommonResult<>(500,"出现了异常，返回 blockHandler的值",new Payment(id,e.getLocalizedMessage()));
    }
}
