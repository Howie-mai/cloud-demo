package com.mh.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName：
 * Time：20/9/29 下午4:14
 * Description：
 *
 * @author mh
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String port;

    @RequestMapping("/get/port/{id}")
    public String getPort(@PathVariable(name = "id") Integer id){
        return port + "\t端口" + "hello world" + "\tid:" + "\t" + id;
    }
}
