package com.mh.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName：
 * Time：20/10/10 下午4:40
 * Description：
 *
 * @author mh
 */
@RestController
@Slf4j
@RequestMapping("/test")
public class HotKeyController {

    @RequestMapping("/hotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "blockTestHotKey")
    public String testHotKey(String p1, String p2){

        return "test HotKey===";
    }
    public String blockTestHotKey(String p1, String p2, BlockException excetion){
        excetion.printStackTrace();
        return "嘤嘤嘤 哭唧唧";
    }
}
