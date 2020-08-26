package com.duang.hystrixdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 服务降级：当下游服务因为某种原因响应过慢，下游服务主动停掉一些不太重要的业务，释放出服务器资源，增加响应
 *  速度；当下游服务因为某种原因不可用，上游主动调用本地的一些降级逻辑，避免卡顿，迅速返回给用户
 * 服务熔断：下游服务因为某种原因突然变得不可用或响应过慢，上游服务为了保证自己整体服务的可用性，不再继续调用
 *  目标服务，直接返回，快速释放资源，如果目标情况好转则恢复调用
 *  Hystrix：超时降级、线程池隔离、信号量隔离 https://blog.csdn.net/zhangcongyi420/article/details/101723584
 *  Sentinel
 *
 * **/
@SpringBootApplication
public class HystrixDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDemoApplication.class, args);
    }

}
