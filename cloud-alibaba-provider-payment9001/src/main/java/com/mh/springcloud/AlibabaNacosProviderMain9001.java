package com.mh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ClassName：
 * Time：20/9/29 下午4:09
 * Description：
 *
 * @author mh
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaNacosProviderMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaNacosProviderMain9001.class,args);
    }
}
