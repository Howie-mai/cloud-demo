package com.mh.springcloud.rocketmq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * ClassName：
 * Time：2020/11/4 2:41 下午
 * Description：
 *
 * @author mh
 */
public interface MySink {
    @Input("input1")
    SubscribableChannel input1();
}
