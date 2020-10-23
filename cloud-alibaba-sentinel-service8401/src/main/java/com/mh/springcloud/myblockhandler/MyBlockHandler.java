package com.mh.springcloud.myblockhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.mh.springcloud.entities.CommonResult;

/**
 * ClassName：
 * Time：20/10/10 下午5:46
 * Description：自定义限流返回方法，一定要static
 *
 * @author mh
 */
public class MyBlockHandler {

    public static CommonResult myBlockHandler(BlockException exception){
        return new CommonResult(500,"自定义兜底方法-------1");
    }

    public static CommonResult myBlockHandler2(BlockException exception){
        return new CommonResult(500,"自定义兜底方法-------2");
    }
}
