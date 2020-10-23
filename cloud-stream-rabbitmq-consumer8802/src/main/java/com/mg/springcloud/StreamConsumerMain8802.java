package com.mg.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * ClassName：
 * Time：20/9/27 下午5:31
 * Description：
 *
 * @author mh
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamConsumerMain8802 {
    public static void main(String[] args) {
        SpringApplication.run(StreamConsumerMain8802.class,args);
    }
}
