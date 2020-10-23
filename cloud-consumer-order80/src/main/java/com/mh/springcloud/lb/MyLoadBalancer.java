package com.mh.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ClassName：
 * Time：20/9/15 下午5:17
 * Description：
 *
 * @author mh
 */
@Component
public class MyLoadBalancer implements LoadBalancer {

    /**
     * 原子
     */
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 获取执行次数
     */
    private final int increateAndGet(){
        int curr,next;
        do{
            curr = atomicInteger.get();
            next = curr >= Integer.MAX_VALUE ? 0 : curr + 1;
        }while (!atomicInteger.compareAndSet(curr,next));
        System.out.println("第几次访问呀== " + next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = increateAndGet() % serviceInstances.size();

        return serviceInstances.get(index);
    }
}
