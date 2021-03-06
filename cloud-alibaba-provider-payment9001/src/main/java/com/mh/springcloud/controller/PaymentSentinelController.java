package com.mh.springcloud.controller;

import com.mh.springcloud.entities.CommonResult;
import com.mh.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * ClassName：
 * Time：20/10/12 下午2:50
 * Description：
 *
 * @author mh
 */
@RestController
@Slf4j
public class PaymentSentinelController {
    @Value("${server.port}")
    private String serverPort;
    public static HashMap<Long, Payment> map = new HashMap<>();

    static {
        map.put(1L, new Payment(1L, "1111"));
        map.put(2L, new Payment(2L, "2222"));
        map.put(3L, new Payment(3L, "3333"));
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        Payment payment = map.get(id);
        return new CommonResult<>(200, "from mysql,serverPort: " + serverPort, payment);
    }
}
