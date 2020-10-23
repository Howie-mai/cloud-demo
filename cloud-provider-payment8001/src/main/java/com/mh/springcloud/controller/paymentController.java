package com.mh.springcloud.controller;

import com.mh.springcloud.entities.CommonResult;
import com.mh.springcloud.entities.Payment;
import com.mh.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName：
 * Time：20/8/19 下午5:54
 * Description：
 *
 * @author mh
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class paymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/get/{id}")
    public CommonResult<Payment> getById(@PathVariable(name = "id") Long id){
        return new CommonResult<>(200,"获取成功 + port：" + serverPort,paymentService.getPaymentById(id));
    }

    @RequestMapping("/insert")
    public CommonResult<Payment> insert(@RequestBody Payment payment){
        int i = paymentService.save(payment);
        log.info("==插入数据"+payment);
        if(i > 0){
            return new CommonResult<>(200,"添加成功,serverPort:" + serverPort);
        }else {
            return new CommonResult<>(400,"发生错误");
        }
    }

    @GetMapping("/timeout")
    public String getPort(){
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    /**
     * ============ 用于gateway网关
     */
    @RequestMapping("/gatewayOne/get/{id}")
    public CommonResult<Payment> getByIdOne(@PathVariable(name = "id") Long id){
        return new CommonResult<>(200,"获取成功 + port：" + serverPort,paymentService.getPaymentById(id));
    }

    @RequestMapping("/gatewayTwo/get/{id}")
    public CommonResult<Payment> getByIdTwo(@PathVariable(name = "id") Long id){
        return new CommonResult<>(200,"获取成功 + port：" + serverPort,paymentService.getPaymentById(id));
    }

    /**
     * ======== 链路追踪
     */
    @RequestMapping("/zipkin/get/{id}")
    public CommonResult<Payment> zipkinGet(@PathVariable(name = "id") Long id){
        return new CommonResult<>(200,"获取成功 + port：" + serverPort,paymentService.getPaymentById(id));
    }
}
