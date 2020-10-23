package com.mh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * ClassName：
 * Time：20/9/27 下午5:02
 * Description：
 *
 * @author mh
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamMain8801 {
    public static void main(String[] args) {
        SpringApplication.run(StreamMain8801.class,args);
    }
}
