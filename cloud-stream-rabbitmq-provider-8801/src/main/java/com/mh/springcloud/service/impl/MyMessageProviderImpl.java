package com.mh.springcloud.service.impl;

import com.mh.springcloud.channel.MyProcessor;
import com.mh.springcloud.service.IMessageProvider;
import com.mh.springcloud.service.IMyMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import java.util.UUID;

/**
 * ClassName：
 * Time：20/9/27 下午5:05
 * Description：
 *
 * @author mh
 */
// 定义一个消息的推送管道
@EnableBinding(MyProcessor.class)
public class MyMessageProviderImpl implements IMyMessageProvider {

    /**
     * 消息发送管道
     */
    @Autowired
    @Qualifier(value = "myoutput")
    private MessageChannel myoutput;

    @Override
    public String send() {
        String uuid = UUID.randomUUID().toString();
        myoutput.send(MessageBuilder.withPayload(uuid).build());
        return null;
    }

    @Autowired
    @Qualifier(value = "outputorder")
    private MessageChannel outputorder;

    @Override
    public String sendOrder() {
        String uuid = UUID.randomUUID().toString();
        outputorder.send(MessageBuilder.withPayload(uuid).build());
        return null;
    }

}
