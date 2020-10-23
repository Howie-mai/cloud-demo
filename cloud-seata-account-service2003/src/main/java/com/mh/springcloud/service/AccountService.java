package com.mh.springcloud.service;

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
public interface AccountService {
    void decrease(Long userId, BigDecimal money);
}
