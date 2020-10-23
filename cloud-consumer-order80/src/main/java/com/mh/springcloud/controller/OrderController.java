package com.mh.springcloud.controller;

import com.mh.springcloud.entities.CommonResult;
import com.mh.springcloud.entities.Payment;
import com.mh.springcloud.lb.MyLoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;

/**
 * ClassName：
 * Time：20/8/24 下午4:59
 * Description：
 *
 * @author mh
 */
@RestController
@Slf4j
public class OrderController {

    //    public static final String PAYMENT_URL = "http://localhost:8001/";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private MyLoadBalancer myLoadBalancer;


    @RequestMapping("/get/{id}")
    public CommonResult<Payment> getInfo(@PathVariable Integer id) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/get/" + id, null, CommonResult.class);
    }

    @RequestMapping("/create")
    public CommonResult<Payment> createPayment(Payment payment, HttpServletRequest request) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/insert", payment, CommonResult.class);
    }

    @RequestMapping("/mylb/create")
    public CommonResult<Payment> createPayment2(Payment payment, HttpServletRequest request) {

        List<ServiceInstance> serviceInstances  = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        if(serviceInstances == null || serviceInstances.size() == 0){
            return null;
        }

        ServiceInstance instances = myLoadBalancer.instances(serviceInstances);

        URI uri = instances.getUri();

        return restTemplate.postForObject(uri + "/payment/insert", payment, CommonResult.class);
    }

    /**
     * 使用postForEntity
     */
    @RequestMapping("/get2/{id}")
    public CommonResult getInfo2(@PathVariable Integer id) {
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if(forEntity.getStatusCode().is2xxSuccessful()){
            return forEntity.getBody();
        }else {
            return null;
        }
    }

    /**
     * 手动代码找Eureka上的服务
     */
    @RequestMapping("/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("element:" + service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }


    /**
     * 链路追踪
     */
    @RequestMapping("/consumer/zipkin/{id}")
    public CommonResult<Payment> zipkinGetInfo(@PathVariable Integer id) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/zipkin/get/" + id, null, CommonResult.class);
    }
}
