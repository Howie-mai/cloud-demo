package com.mh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * ClassName：
 * Time：20/9/16 下午3:31
 * Description：
 *
 * @author mh
 */
@SpringBootApplication
// 激活并开启feign
@EnableFeignClients
/**
 * 开启hystrix
 */
@EnableHystrix
public class OrderFeignMain {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain.class,args);
    }
}
