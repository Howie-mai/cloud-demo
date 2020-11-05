package com.mh.springcloud.controller;

import com.mh.springcloud.rocketmq.SenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName：
 * Time：2020/11/4 2:30 下午
 * Description：
 *
 * @author mh
 */
@RestController
public class TestMqController {

    @Autowired
    private SenderService senderService;

    @GetMapping(value = "/send")
    public String send(String msg) {
        senderService.send(msg);
        return "字符串消息发送成功!";
    }

    @RequestMapping(value = "/sendWithTags", method = RequestMethod.GET)
    public String sendWithTags(String msg,String tag) {
        senderService.sendWithTags(msg, tag);
        return "带tag字符串消息发送成功!";
    }

}
