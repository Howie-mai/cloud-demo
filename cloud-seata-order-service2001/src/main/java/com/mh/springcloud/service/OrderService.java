package com.mh.springcloud.service;

import com.mh.springcloud.bean.Order;

/**
 * ClassName：
 * Time：20/10/20 下午3:46
 * Description：
 *
 * @author mh
 */
public interface OrderService {
    /**
     * 创建订单     * @param order
     */
    void create(Order order);
}
