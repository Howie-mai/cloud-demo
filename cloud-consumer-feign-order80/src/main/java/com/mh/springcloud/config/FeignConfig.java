package com.mh.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName：
 * Time：20/9/16 下午4:30
 * Description：
 *
 * @author mh
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLogLevel(){
        return Logger.Level.FULL;
    }
}
