package com.mh.springcloud.rocketmq;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * ClassName：
 * Time：2020/11/4 2:28 下午
 * Description：
 *
 * @author mh
 */
@Component
@Slf4j
public class ReceiveService {
    @StreamListener("input1")
    public void receiveInput1(@Payload String receiveMsg) {
        log.info("input1 接收到了消息：" + receiveMsg);
    }
}
