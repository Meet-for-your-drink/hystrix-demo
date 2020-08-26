package com.duang.hystrixdemo.service.impl;

import com.duang.hystrixdemo.service.HystrixService;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HystrixServiceImpl implements HystrixService {
   private static RestTemplate  restTemplate = new RestTemplate();

    @HystrixCommand(
            commandKey = "Hystrix timeout",
            commandProperties = {
                    @HystrixProperty(name="execution.timeout.enabled",value="true"),
                    @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000"),
            },
            fallbackMethod = "timeoutFallbackMethod"
    )
    @Override
    public String hystrixTimeout() {
        return restTemplate.getForObject("http://localhost:8080/provideData",String.class);
    }

    public String timeoutFallbackMethod(){
        System.out.println("************超时降级策略执行*****************");
        return "hytrix timeout";
    }
}
