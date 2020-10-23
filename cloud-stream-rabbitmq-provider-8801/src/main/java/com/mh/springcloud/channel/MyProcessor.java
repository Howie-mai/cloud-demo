package com.mh.springcloud.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * ClassName：
 * Time：20/9/28 下午4:52
 * Description：自定义消息通道
 *
 * @author mh
 */
public interface MyProcessor {


    /**
     * 消息生产者的配置
     */
    String MYOUTPUT = "myoutput";

    @Output("myoutput")
    MessageChannel myoutput();

    String OUT_PUT_ORDER = "outputorder";

    @Output("outputorder")
    MessageChannel outputorder();

    /**
     * 消息消费者的配置
     */
    String MYINPUT = "myinput";

    @Input("myinput")
    SubscribableChannel myinput();

    String IN_PUT_ORDER = "inputorder";

    @Input("inputorder")
    SubscribableChannel inputorder();
}
