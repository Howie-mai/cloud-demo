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

    String INPUT1 = "input1";
    @Input(INPUT1)
    SubscribableChannel input1();

//    String INPUT2 = "input2";
//    @Input(INPUT2)
//    SubscribableChannel input2();
}
