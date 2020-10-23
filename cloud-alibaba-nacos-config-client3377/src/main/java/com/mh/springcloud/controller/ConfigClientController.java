package com.mh.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName：
 * Time：20/9/29 下午5:08
 * Description：
 *
 * @author mh
 */
@RestController
@RefreshScope
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;

    @Value("${common.info}")
    private String commonInfo;

    @Value("${application.info}")
    private String applicationInfo;

    @RequestMapping("/getInfo")
    public String getInfo(){
        return configInfo;
    }

    @RequestMapping("/getCommonProperties")
    public String getProperties(){
        return commonInfo;
    }

    @RequestMapping("/getApplicationInfo")
    public String getApplicationInfo(){
        return applicationInfo;
    }
}
