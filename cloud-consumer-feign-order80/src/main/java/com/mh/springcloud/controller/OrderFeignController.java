package com.mh.springcloud.controller;

import com.mh.springcloud.entities.CommonResult;
import com.mh.springcloud.entities.Payment;
import com.mh.springcloud.service.OrderFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName：
 * Time：20/9/16 下午3:45
 * Description：
 *
 * @author mh
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private OrderFeignService orderFeignService;

    @RequestMapping("/feign/get/{id}")
    public CommonResult<Payment> getById(@PathVariable(name = "id") Long id){
        return orderFeignService.getById(id);
    }

    @GetMapping("/feign/timeout")
    public String getById(){
        return orderFeignService.getPort();
    }

    @GetMapping("/feign/insert")
    public String insert(int flag){
        return orderFeignService.test5(flag);
    }

    @RequestMapping("/feign/select")
    public void selectByModelSelective(){
        orderFeignService.selectByModelSelective();
    }
}
