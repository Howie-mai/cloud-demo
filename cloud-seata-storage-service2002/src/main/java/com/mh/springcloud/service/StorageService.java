package com.mh.springcloud.service;

/**
 * ClassName：
 * Time：20/10/20 下午3:50
 * Description：
 *
 * @author mh
 */
public interface StorageService {
    void decrease(Long productId, Integer count);
}
