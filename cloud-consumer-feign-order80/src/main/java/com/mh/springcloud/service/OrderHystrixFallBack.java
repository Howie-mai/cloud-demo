package com.mh.springcloud.service;

import com.mh.springcloud.entities.CommonResult;
import com.mh.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * ClassName：
 * Time：20/9/18 下午5:10
 * Description：
 *
 * @author mh
 */
@Component
public class OrderHystrixFallBack implements OrderHystrixService,OrderFeignService {

    @Override
    public String timeOut(Integer id, Integer timeout) {
        return "timout --- 最后修改的降级fall back方法";
    }

    @Override
    public CommonResult<Payment> getById(Long id) {
        return null;
    }

    @Override
    public String getPort() {
        return null;
    }

    @Override
    public String test5(Integer flag) {
        return "String.valueOf(flag)";
    }

    @Override
    public String selectByModelSelective() {
        return "null";
    }
}
