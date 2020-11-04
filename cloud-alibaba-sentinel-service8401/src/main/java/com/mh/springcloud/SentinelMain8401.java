package com.mh.springcloud;

import com.mh.springcloud.rocketmq.MySink;
import com.mh.springcloud.rocketmq.MySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * ClassName：
 * Time：20/10/9 下午3:20
 * Description：
 *
 * @author mh
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableBinding({MySource.class, MySink.class})
public class SentinelMain8401 {
    public static void main(String[] args) {
        SpringApplication.run(SentinelMain8401.class,args);
    }
}
