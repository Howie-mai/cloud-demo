package com.mh.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName：
 * Time：20/9/25 下午2:46
 * Description：
 *
 * @author mh
 */
@RestController
@RefreshScope
public class ConfigController {
    @Value("${config.info}")
    private String configInfo;

    @RequestMapping("/getConfigInfo")
    public String getConfigInfo(){
        return configInfo;
    }
}
