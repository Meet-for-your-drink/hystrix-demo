package com.duang.hystrixdemo.controller;


import com.duang.hystrixdemo.service.HystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class HystrixController {
    @Autowired
    HystrixService hystrixService;

    @GetMapping("/timeout")
    public String timeOut(){
        return hystrixService.hystrixTimeout();
    }

    @GetMapping("/provideData")
    public String provideData() throws InterruptedException {
        Thread.sleep(5000);
        return UUID.randomUUID().toString().substring(0,6);
    }
}
