package com.mh.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * ClassName：
 * Time：20/9/15 下午5:16
 * Description：
 *
 * @author mh
 */
public interface LoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
