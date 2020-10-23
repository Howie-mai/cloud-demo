package com.mh.springcloud.service;

import com.mh.springcloud.entities.Payment;
import com.mh.springcloud.entities.PaymentAuto;
import com.mh.springcloud.entities.PaymentInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ClassName：
 * Time：20/8/19 下午5:51
 * Description：
 *
 * @author mh
 */
public interface PaymentService {
    int save(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

    /**
     * 传入一个model和一个排序条件（可选），查询数据
     * @param record model，可以部分字段为空
     * @param orderByClause 排序条件，写法 'id,name asc, create_time desc'
     * @return
     */
    List<PaymentInfo> selectByModelSelective(PaymentInfo record, String orderByClause);

    /**
     * 批量插入。list不宜太大
     * @param list
     * @return
     */
    int insertBatch(List<Payment> list);

    /**
     * 批量插入不为空的字段。list不宜太大
     * @param list
     * @return
     */
    int insertBatchSelective(List<Payment> list);

    int insertBatchAuto(List<PaymentAuto> list);

    int insertBatchInfo(List<PaymentInfo> list);

    int insertBatchInfoSelective(List<PaymentInfo> list);

    int insertOne(PaymentInfo info);
}
