package com.mh.springcloud.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * ClassName：
 * Time：20/10/20 下午3:40
 * Description：
 *
 * @author mh
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public  class Account {
    private Long id;
    private Long userId;
    private BigDecimal total;
    private BigDecimal used;
    private BigDecimal residue;
}
