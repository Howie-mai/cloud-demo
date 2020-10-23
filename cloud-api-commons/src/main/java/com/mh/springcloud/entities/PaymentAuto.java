package com.mh.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * ClassName：
 * Time：20/10/15 上午11:19
 * Description：
 *
 * @author mh
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentAuto {
    private Integer id;
    private String content;
    private Date createTime;
    private Date updateTime;

    public PaymentAuto(String content) {
        this.content = content;
    }
}
