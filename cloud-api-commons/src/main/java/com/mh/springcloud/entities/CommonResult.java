package com.mh.springcloud.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * ClassName：
 * Time：20/8/19 下午5:34
 * Description：
 *
 * @author mh
 */
@Data
@NoArgsConstructor
public class CommonResult<T>  {

    private Integer code;
    private String msg;
    private T data;
    private List<T> dataList;

    public CommonResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CommonResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
