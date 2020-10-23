package com.mh.springcloud.service.impl;

import com.mh.springcloud.mapper.AccountDao;
import com.mh.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * ClassName：
 * Time：20/10/20 下午3:48
 * Description：
 *
 * @author mh
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("----> account-service中扣减用户余额开始");
        // TODO 模拟超时
//        try {
//            Thread.sleep(1000 * 20);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        accountDao.decrease(userId, money);
        log.info("----> account-service中扣减用户余额开始");
    }
}
