package com.mh.springcloud.controller;

import com.mh.springcloud.rocketmq.MyRocketMqTemplate;
import com.mh.springcloud.rocketmq.SenderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.messaging.support.MessageBuilder;
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
@Slf4j
public class TestMqController {

    @Autowired
    private SenderService senderService;

    @Autowired
    private MyRocketMqTemplate template;

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

//    @RequestMapping("/syncSend")
//    public SendResult  syncSend(String msg) {
//        SendResult sendResult = template.syncSend("test-output", MessageBuilder.withPayload(msg).build());
//
//        System.out.println();
//        return sendResult;
//    }
//
//    @RequestMapping("/asyncSend")
//    public String asyncSend(String msg) {
//        template.asyncSend("test-output", MessageBuilder.withPayload(msg).build(), new SendCallback() {
//            @Override
//            public void onSuccess(SendResult sendResult) {
//                log.info("callback onSuccess");
//            }
//
//            @Override
//            public void onException(Throwable throwable) {
//                log.info("callback onException");
//            }
//        });
//        System.out.println();
//        return msg;
//    }

    @RequestMapping("/sendWithDelay")
    public String sendWithDelay(String msg,int delayLevel) {
//        template = new MyRocketMqTemplate();

        System.out.println("=======" + (template.getDefaultMQProducer() == null));
        template.mySend("test-output",
                MessageBuilder.withPayload(msg).build(),delayLevel);
        System.out.println("=======");
        return msg;
    }
    @RequestMapping("/asyncSendWithDelay")
    public String asyncSendWithDelay(String msg,int delayLevel) {


        template.myAsyncSend("test-output", MessageBuilder.withPayload(msg).build(), new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                log.info("callback onSuccess");
            }

            @Override
            public void onException(Throwable throwable) {
                log.info("callback onException");
            }
        },delayLevel);

        return msg;
    }
    @RequestMapping("/sendOneWayWithDelay")
    public String sendOneWayWithDelay(String msg,int delayLevel) {
        template.mySendOneWay("test-output",
                MessageBuilder.withPayload(msg).build(),delayLevel);
        return msg;
    }

}
