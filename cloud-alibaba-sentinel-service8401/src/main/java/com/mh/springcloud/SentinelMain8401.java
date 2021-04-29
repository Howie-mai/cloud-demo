package com.mh.springcloud;

import com.alibaba.cloud.stream.binder.rocketmq.config.RocketMQComponent4BinderAutoConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mh.springcloud.rocketmq.MyRocketMqTemplate;
import com.mh.springcloud.rocketmq.MySink;
import com.mh.springcloud.rocketmq.MySource;
import org.apache.rocketmq.acl.common.AclClientRPCHook;
import org.apache.rocketmq.acl.common.SessionCredentials;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.spring.autoconfigure.RocketMQProperties;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

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

//    @Bean(
//            destroyMethod = "destroy"
//    )
//    @ConditionalOnMissingBean(value = {MyRocketMqTemplate.class})
//    @ConditionalOnBean({RocketMQTemplate.class, RocketMQComponent4BinderAutoConfiguration.class})
//    public MyRocketMqTemplate myRocketMqTemplate(DefaultMQProducer defaultMQProducer,ObjectMapper objectMapper){
//        return new MyRocketMqTemplate(defaultMQProducer,objectMapper);
//    }


}
