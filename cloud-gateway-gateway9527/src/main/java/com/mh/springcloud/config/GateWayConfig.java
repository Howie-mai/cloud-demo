package com.mh.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName：
 * Time：20/9/23 下午4:36
 * Description：
 *
 * @author mh
 */
@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator myRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        // 访问/guonei会跳转到百度新闻的国内板块
        routes.route("route_baidu_news_guonei",
                      f -> f.path("/guonei").uri("https://news.baidu.com/guonei"))
              .route("route_baidu_news_lady",
                      f -> f.path("/lady").uri("https://news.baidu.com/lady"));

        return routes.build();
    }
}
