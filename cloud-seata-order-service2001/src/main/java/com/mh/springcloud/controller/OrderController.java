package com.mh.springcloud.controller;

import com.mh.springcloud.bean.CommonResult;
import com.mh.springcloud.bean.Order;
import com.mh.springcloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * ClassName：
 * Time：20/10/20 下午3:59
 * Description：
 *
 * @author mh
 */
@RestController
@Slf4j
public class OrderController {
    @Resource
    private OrderService orderService;

    /**
     * 创建订单     *     * @param order     * @return
     */
    @GetMapping("/order/create")
    public CommonResult<Order> create(Order order) {
        orderService.create(order);
        return new CommonResult<>(200, "订单创建成功");
    }
}
