package com.mh.springcloud.entities;

import com.alibaba.excel.annotation.ExcelProperty;
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

    @ExcelProperty(value = "唯一标识",index = 0)
    private Long id;

    @ExcelProperty(value = "内容",index = 1)
    private String serial;

    public Payment(String serial) {
        this.serial = serial;
    }
}
