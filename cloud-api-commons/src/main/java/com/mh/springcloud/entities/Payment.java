package com.mh.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ClassName：
 * Time：20/8/19 下午5:32
 * Description：
 *
 * @author mh
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    private Long id;
    private String serial;

    public Payment(String serial) {
        this.serial = serial;
    }
}
