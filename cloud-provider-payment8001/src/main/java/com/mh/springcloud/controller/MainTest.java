package com.mh.springcloud.controller;

import com.mh.springcloud.entities.Payment;
import com.mh.springcloud.entities.PaymentInfo;
import com.mh.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName：
 * Time：20/10/14 下午3:23
 * Description：
 *
 * @author mh
 */
@RestController
public class MainTest {
    @Autowired
    private PaymentService paymentService;

    @RequestMapping("/selectByModelSelective")
    public void selectByModelSelective(){
//        List<Payment> id = paymentService.selectByModelSelective(new Payment(1L, ""), "id desc");
//        System.out.println(id);
    }

    @RequestMapping("/insertPaymentInfo")
    public String test5(@RequestParam(name = "name") Integer flag){
        List<PaymentInfo> list = new ArrayList<>();
        list.add(new PaymentInfo("我是content"));
        list.add(new PaymentInfo("我是CONTENT","我是INFO"));
        if(flag == 1){
            PaymentInfo paymentInfo = new PaymentInfo();
            paymentInfo.setInfo("我是info");
            list.add(paymentInfo);
        }
        int id = paymentService.insertBatchInfoSelective(list);
        for (PaymentInfo info : list) {
            System.out.println(info.getId());
        }
        return String.valueOf(id);
    }
}
