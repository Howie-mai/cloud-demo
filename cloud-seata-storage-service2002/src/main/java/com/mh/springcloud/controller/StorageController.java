package com.mh.springcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mh.springcloud.bean.CommonResult;
import com.mh.springcloud.bean.Storage;
import com.mh.springcloud.service.StorageService;

import javax.annotation.Resource;

/**
 * ClassName：
 * Time：20/10/20 下午3:59
 * Description：
 *
 * @author mh
 */
@RestController
public class StorageController {
    @Resource
    private StorageService storageService;

    @RequestMapping("/storage/decrease")
    public CommonResult<Storage> decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);
        return new CommonResult<>(200, "扣减库存成功!");
    }
}
