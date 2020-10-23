package com.mh.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName：
 * Time：20/9/15 下午3:48
 * Description：自定义负载均衡策略，不能放在启动类下，否则会成全局规则，达不到特殊化
 *
 * @author mh
 */
@Configuration
public class MyLbRule {

    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
