package com.mh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName：
 * Time：20/9/29 下午4:33
 * Description：
 *
 * @author mh
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class AlibabaConsumerMain8083 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaConsumerMain8083.class,args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
