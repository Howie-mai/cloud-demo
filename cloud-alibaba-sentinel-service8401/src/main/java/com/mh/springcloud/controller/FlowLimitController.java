package com.mh.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName：
 * Time：20/10/9 下午3:21
 * Description：
 *
 * @author mh
 */
@RestController
@Slf4j
public class FlowLimitController {
    @GetMapping("testA")
    public String testA(){
//        try{
//            Thread.sleep(3000L);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        return "testA";
    }

    @GetMapping("testB")
    public String testB(){
        return "testB";
    }

    /**
     * 当QPS >= 5 并且 平均响应时间超过阈值，
     * 资源进入降级状态，即在接下来的时间窗口，都会处于熔断状态
     */
    @GetMapping("testD")
    public String testD(){
        log.info("测试Sentinel RT 每秒响应时间");
        try{
            Thread.sleep(1000L);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "testD";
    }

    /**
     * 当QPS >= 5 并且 每秒异常总数占通过量的比值超过阈值的后，
     * 资源进入降级状态，即在接下来的时间窗口，都会处于熔断状态
     */
    @GetMapping("testE")
    public String testE(){
        log.info("测试Sentinel 异常比例");
        int a = 10 / 0;
        return "testE";
    }

    /**
     * 当资源近1分钟内的异常数大于等于阈值后会进行熔断。
     * 由于统计时间窗口是分钟级别的，若timeWindow小于60s,则结束熔断状态后仍可能进入熔断状态。
     * 时间窗口一定要大于等于60s
     */
    @GetMapping("testF")
    public String testF(){
        log.info("测试Sentinel 异常数目");
        int a = 10 / 0;
        return "testF";
    }
}
