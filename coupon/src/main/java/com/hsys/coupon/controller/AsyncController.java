package com.hsys.coupon.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Fant.J.
 */
@RestController
public class AsyncController {
 
    /**
     * 单线程测试
     * @return
     * @throws InterruptedException
     */
    @RequestMapping("/order")
    public String order() throws InterruptedException {
        System.out.println("主线程开始");
        Thread.sleep(1000);
        System.out.println("主线程返回");
        return "success";
    }
}