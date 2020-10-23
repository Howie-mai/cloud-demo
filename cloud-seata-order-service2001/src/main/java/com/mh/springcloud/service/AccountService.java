package com.mh.springcloud.service;

import com.mh.springcloud.bean.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * ClassName：
 * Time：20/10/20 下午3:50
 * Description：
 *
 * @author mh
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {
    /**
     * 减余额     * @param userId     * @param money     * @return
     */
    @PostMapping(value = "/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
