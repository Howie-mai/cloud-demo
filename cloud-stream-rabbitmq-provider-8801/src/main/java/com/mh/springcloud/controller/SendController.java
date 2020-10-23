package com.mh.springcloud.controller;

import com.mh.springcloud.service.IMessageProvider;
import com.mh.springcloud.service.IMyMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName：
 * Time：20/9/27 下午5:17
 * Description：
 *
 * @author mh
 */
@RestController
@RequestMapping("/send")
public class SendController {

    @Autowired
    private IMessageProvider messageProvider;

    @Autowired
    private IMyMessageProvider myMessageProvider;

    @RequestMapping("/sendMessage")
    public String send(){
        return messageProvider.send();
    }

    @RequestMapping("/my/sendMessage")
    public String sendMyMessage(){
        return myMessageProvider.send();
    }

    @RequestMapping("/order/sendMessage")
    public String sendOrderMessage(){
        return myMessageProvider.sendOrder();
    }
}
