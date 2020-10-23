package com.mh.springcloud.dao;

import com.mh.springcloud.entities.Payment;
import com.mh.springcloud.entities.PaymentAuto;
import com.mh.springcloud.entities.PaymentInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

/**
 * ClassName：
 * Time：20/8/19 下午5:41
 * Description：
 *
 * @author mh
 */
@Mapper
public interface PaymentDao {
    int save(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

    List<PaymentInfo> selectByModelSelective(@Param("record") PaymentInfo paymentinfo, @Param("orderByClause") String orderByClause);

    int insertBatch(@Param("list") List<Payment> list);

    int insertBatchSelective(@Param("list") List<Payment> list);

    int insertBatchInfo(@Param("list") List<PaymentInfo> list);

    int insertBatchInfoSelective(@Param("list") List<PaymentInfo> list);

    int insertBatchAuto(@Param("list") List<PaymentAuto> list);

    @SelectKey(keyProperty = "id",keyColumn = "id",before = true,resultType = String.class,statement =  {" select replace(uuid(),'-','')"})
    int insertOne(@Param("item") PaymentInfo paymentinfo);
}
