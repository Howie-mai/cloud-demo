package com.mh.springcloud.rocketmq;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * ClassName：
 * Time：2020/11/4 2:26 下午
 * Description：
 *
 * @author mh
 */
public interface MySource {
    @Output("output1")
    MessageChannel output1();
}
