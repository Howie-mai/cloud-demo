package com.mh.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.mh.springcloud.entities.CommonResult;
import com.mh.springcloud.entities.Payment;
import com.mh.springcloud.myblockhandler.MyBlockHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName：
 * Time：20/10/10 下午5:28
 * Description：
 *
 * @author mh
 */
@RestController
@Slf4j
@RequestMapping("/rateLimit")
public class RateLimitController {

    /**
     * 按 SentinelResource 中的value 配置限流，如果不配置兜底方法，会出现错误的页面
     */
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "blockByResource")
    public CommonResult byResource(){
        return new CommonResult(200,"RateLimit ByResource ",new Payment(1L,"123"));
    }
    public CommonResult blockByResource(BlockException e){
        return new CommonResult(500,"哭唧唧 嘤嘤嘤");
    }

    /**
     * 按地址URL限流，返回sentinel自带的信息，不管有没有配置兜底方法
     */
    @GetMapping("/byUrl")
    @SentinelResource(value = "byUrl",blockHandler = "blockByUrl")
    public CommonResult byUrl(){
        return new CommonResult(200,"RateLimit ByResource ",new Payment(1L,"123"));
    }
    public CommonResult blockByUrl(BlockException e){
        return new CommonResult(500,"By Url 哭唧唧 嘤嘤嘤");
    }

    /**
     * 自定义兜底方法，兜底返回的参数和返回值一定要与接口的一致
     */
    @GetMapping("/byMyself")
    @SentinelResource(value = "byMyself",blockHandlerClass = MyBlockHandler.class,blockHandler = "myBlockHandler")
    public CommonResult byMyself(){
        return new CommonResult(200,"RateLimit ByResource ",new Payment(100L,"123"));
    }
}
