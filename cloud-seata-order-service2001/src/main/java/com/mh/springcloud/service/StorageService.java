package com.mh.springcloud.service;

import com.mh.springcloud.bean.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ClassName：
 * Time：20/10/20 下午3:50
 * Description：
 *
 * @author mh
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {
    /**
     * 减库存     * @param productId     * @param count     * @return
     */
    @PostMapping(value = "/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
