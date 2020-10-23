package com.mh.springcloud.service.impl;

import com.mh.springcloud.entities.Payment;
import com.mh.springcloud.dao.PaymentDao;
import com.mh.springcloud.entities.PaymentAuto;
import com.mh.springcloud.entities.PaymentInfo;
import com.mh.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName：
 * Time：20/8/19 下午5:51
 * Description：
 *
 * @author mh
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int save(Payment payment) {
        return paymentDao.save(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

    @Override
    public List<PaymentInfo> selectByModelSelective(PaymentInfo record, String orderByClause) {
        return paymentDao.selectByModelSelective(record, orderByClause);
    }

    @Override
    public int insertBatch(List<Payment> list) {
        return paymentDao.insertBatch(list);
    }

    @Override
    public int insertBatchSelective(List<Payment> list) {
        return paymentDao.insertBatchSelective(list);
    }

    @Override
    public int insertBatchAuto(List<PaymentAuto> list) {
        return paymentDao.insertBatchAuto(list);
    }

    @Override
    public int insertBatchInfo(List<PaymentInfo> list) {
        return paymentDao.insertBatchInfo(list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertBatchInfoSelective(List<PaymentInfo> list) {
//        try{
            paymentDao.insertBatchInfoSelective(list);
//        }catch (Exception e){
//            throw new RuntimeException("错误啦");
//            return -1;
//        }
//        int a = 10/0;
        return 100;
    }

    @Override
    public int insertOne(PaymentInfo info) {
        return paymentDao.insertOne(info);
    }
}
