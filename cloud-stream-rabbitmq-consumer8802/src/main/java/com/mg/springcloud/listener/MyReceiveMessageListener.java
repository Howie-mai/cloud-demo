package com.mg.springcloud.listener;

import com.mh.springcloud.channel.MyProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * ClassName：
 * Time：20/9/27 下午5:33
 * Description：
 *
 * @author mh
 */
@Component
/**
 * 标明身份
 */
@EnableBinding(MyProcessor.class)
public class MyReceiveMessageListener {
    @Value("${server.port}")
    private String serverPort;

    @StreamListener(MyProcessor.MYINPUT)
    public void input(Message<String> message){
        System.out.println(serverPort + "\t" + "： 消费者2号收到消息：" + "\t" + message.getPayload());
    }

    @StreamListener(MyProcessor.IN_PUT_ORDER)
    public void inputOrder(Message<String> message){
        System.out.println(serverPort + "\t" + "： 消费者3号收到order消息：" + "\t" + message.getPayload());
    }
}
