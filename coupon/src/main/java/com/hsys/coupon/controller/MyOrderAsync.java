package com.hsys.coupon.controller;

import java.util.concurrent.Callable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class MyOrderAsync {
	 /**
     * 用Callable实现异步
     * @return
     * @throws InterruptedException
     */
    @RequestMapping("/orderAsync")
    public Callable orderAsync() throws InterruptedException {
        System.out.println("主线程开始");
        Callable result = new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println("副线程开始");
                Thread.sleep(1000);
                System.out.println("副线程返回");
                return "success";
            }
        };
        System.out.println("主线程返回");
        return result;
    }
}
