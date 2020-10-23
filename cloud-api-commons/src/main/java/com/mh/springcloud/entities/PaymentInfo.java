package com.mh.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName：
 * Time：20/10/14 下午3:40
 * Description：
 *
 * @author mh
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentInfo {
    private String id;
    private String content;
    private String info;

    public PaymentInfo(String content) {
        this.content = content;
    }

    public PaymentInfo(String content, String info) {
        this.content = content;
        this.info = info;
    }

}
