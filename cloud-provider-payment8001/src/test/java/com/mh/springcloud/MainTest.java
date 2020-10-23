package com.mh.springcloud;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.lang.WeightRandom;
import cn.hutool.core.util.HexUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONUtil;
import com.mh.springcloud.entities.Payment;
import com.mh.springcloud.entities.PaymentAuto;
import com.mh.springcloud.entities.PaymentInfo;
import com.mh.springcloud.service.PaymentService;
import org.bouncycastle.util.encoders.Hex;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ClassName：
 * Time：20/10/14 下午2:38
 * Description：
 *
 * @author mh
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MainTest {
    @Autowired
    private PaymentService paymentService;

    @Test
    public void test(){
        PaymentInfo paymentInfo = new PaymentInfo();
        paymentInfo.setContent("content");
        List<PaymentInfo> id = paymentService.selectByModelSelective(paymentInfo, "id desc");
        System.out.println(id);
    }

    @Test
    public void test2(){
        List<Payment> list = new ArrayList<>();
        list.add(new Payment("哈哈哈哈"));
        list.add(new Payment("哈哈哈哈1"));
        int id = paymentService.insertBatch(list);
        for (Payment info : list) {
            System.out.println(info.getId());
        }
        System.out.println(id);
    }

    @Test
    public void selectBatchSelective(){
        List<Payment> list = new ArrayList<>();
        list.add(new Payment("哈哈哈哈"));
        list.add(new Payment("哈哈哈哈1"));
        int id = paymentService.insertBatchSelective(list);
        for (Payment info : list) {
            System.out.println(info.getId());
        }
        System.out.println(id);
    }

    @Test
    public void selectBatchAuto(){
        List<PaymentAuto> list = new ArrayList<>();
        list.add(new PaymentAuto("哈哈哈哈"));
        list.add(new PaymentAuto("哈哈哈哈1"));
//        list.forEach(paymentAuto -> {
//            paymentAuto.setCreateTime(new Date());
//            paymentAuto.setUpdateTime(new Date());
//        });
        int id = paymentService.insertBatchAuto(list);
        for (PaymentAuto info : list) {
            System.out.println(info.getId());
        }
        System.out.println(id);
    }

    @Test
    public void test3(){
        List<PaymentInfo> list = new ArrayList<>();
        list.add(new PaymentInfo("哈哈哈哈"));
        list.add(new PaymentInfo());
        int id = paymentService.insertBatchInfo(list);
        for (PaymentInfo info : list) {
            System.out.println(info.getId());
        }
        System.out.println(id);
    }

    @Test
    public void test4(){
        PaymentInfo paymentInfo = new PaymentInfo("哈哈哈哈哈哈");
        System.out.println(paymentInfo.getId());
        int id = paymentService.insertOne(paymentInfo);
        System.out.println(paymentInfo.getId());
        System.out.println(id);
    }

    @Test
//    @Transactional
    public void test5(){
        List<PaymentInfo> list = new ArrayList<>();
        list.add(new PaymentInfo("我是content"));
        list.add(new PaymentInfo("我是CONTENT","我是INFO"));
        PaymentInfo paymentInfo = new PaymentInfo();
        paymentInfo.setInfo("我是info");
        list.add(paymentInfo);
        int id = paymentService.insertBatchInfoSelective(list);
        for (PaymentInfo info : list) {
            System.out.println(info.getId());
        }
        System.out.println(id);
    }

    @Test
    public void test6(){
        String s = Base64.encode("我是一个帅哥");
        System.out.println(s);

        String s1 = Base64.decodeStr(s);
        System.out.println(s1);
//        JSONUtil.createArray();
//        HexUtil.decodeStr()
//        HexUtil.toBigInteger()
    }
}
