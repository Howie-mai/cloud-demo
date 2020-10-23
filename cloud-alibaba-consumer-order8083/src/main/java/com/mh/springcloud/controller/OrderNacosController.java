package com.mh.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * ClassName：
 * Time：20/9/29 下午4:34
 * Description：
 *
 * @author mh
 */
@RestController
@Slf4j
public class OrderNacosController {
    @Value("${service-url.nacos-user-service}")
    private String paymentUrl;

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/nacos/getPort/{id}")
    public String consumerGetPort(@PathVariable(name = "id") Integer id){
        return restTemplate.getForObject(paymentUrl + "/get/port/" + id,String.class);
    }
}
