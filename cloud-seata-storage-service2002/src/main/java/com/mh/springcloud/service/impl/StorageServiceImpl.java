package com.mh.springcloud.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.mh.springcloud.mapper.StorageDao;
import com.mh.springcloud.service.StorageService;

import javax.annotation.Resource;

/**
 * ClassName：
 * Time：20/10/20 下午3:48
 * Description：
 *
 * @author mh
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("----> storage-service中扣减库存开始");
        storageDao.decrease(productId, count);
        log.info("----> storage-service中扣减库存结束");
    }
}
