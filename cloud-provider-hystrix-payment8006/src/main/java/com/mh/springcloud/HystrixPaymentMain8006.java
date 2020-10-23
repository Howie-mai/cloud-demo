package com.mh.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.HystrixMetricsProperties;
import org.springframework.context.annotation.Bean;

/**
 * ClassName：
 * Time：20/8/19 下午5:18
 * Description：
 *
 * @author mh
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
/**
 * 开启服务降级
 */
@EnableCircuitBreaker
public class HystrixPaymentMain8006 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixPaymentMain8006.class, args);
    }

    /**
     * 此配置是为了服务监控而配置，与服务容错本身无关，springcloud升级后的坑
     * ServletRegistrationBean因为SpringBoot的默认路径不是 “/hystrix.stream"
     * 只要在自己的项目里配置上下的servlet就可以了
     */
    @Bean
    public ServletRegistrationBean getBean(){
        HystrixMetricsStreamServlet servlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean bean = new ServletRegistrationBean(servlet);
        bean.setLoadOnStartup(1);
        bean.addUrlMappings("/hystrix.stream");
        bean.setName("HystrixMetricsStreamServlet");
        return bean;
    }
}
