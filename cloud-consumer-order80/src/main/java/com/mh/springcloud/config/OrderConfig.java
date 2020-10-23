package com.mh.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName：
 * Time：20/8/24 下午4:58
 * Description：
 *
 * @author mh
 */
@Configuration
public class OrderConfig {

    @Bean
    // 赋予RestTemplate负载均衡d的能力
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
