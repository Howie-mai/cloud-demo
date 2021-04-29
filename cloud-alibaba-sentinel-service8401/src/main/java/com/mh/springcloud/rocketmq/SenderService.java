package com.mh.springcloud.rocketmq;

import org.apache.rocketmq.common.message.MessageConst;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName：
 * Time：2020/11/4 2:28 下午
 * Description：
 *
 * @author mh
 */
@Service
public class SenderService {
    @Autowired
    private MySource source;

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    /**
     * 发送字符串
     *
     * @param msg
     */
    public void send(String msg) {
        Message<String> message = MessageBuilder.withPayload(msg)
                .setHeader(MessageConst.PROPERTY_TAGS, "tagStr")
                .build();
        source.output1().send(message);

//        rocketMQTemplate.convertAndSend("OUTPUT-01",msg);
    }

    /**
     * 发送带tag的字符串
     *
     * @param msg
     * @param tag
     */
    public void sendWithTags(String msg, String tag) {
        Message<String> message = MessageBuilder.withPayload(msg)
                .setHeader("rocketmq_TAGS", tag)
                .build();
//        source.output1().send(message);
        Map<String,Object> map = new HashMap<>();
        map.put("TAGS", tag);
//        rocketMQTemplate.convertAndSend("OUTPUT-01",msg,map);
//        rocketMQTemplate.
//        rocketMQTemplate.send("OUTPUT-01",message);
    }

//    /**
//     * 发送对象
//     *
//     * @param msg
//     * @param tag
//     * @param <T>
//     */
//    public <T> void sendObject(T msg, String tag) {
//        Message message = MessageBuilder.withPayload(msg)
//                .setHeader(RocketMQHeaders.TAGS, tag)
//                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
//                .build();
//        source.output2().send(message);
//    }
}
