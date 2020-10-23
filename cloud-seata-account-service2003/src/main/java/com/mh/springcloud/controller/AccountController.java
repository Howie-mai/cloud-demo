package com.mh.springcloud.controller;

import com.mh.springcloud.bean.Account;
import com.mh.springcloud.bean.CommonResult;
import com.mh.springcloud.service.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * ClassName：
 * Time：20/10/20 下午3:59
 * Description：
 *
 * @author mh
 */
@RestController
public class AccountController {
    @Resource
    AccountService accountService;

    @RequestMapping("/account/decrease")
    public CommonResult<Account> decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money) {
        accountService.decrease(userId, money);
        return new CommonResult<>(200, "扣减账户余额成功！");
    }
}
