package com.hsys.coupon.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.hsys.coupon.DeferredResultHolder;
import com.hsys.coupon.MockQueue;
@RestController
public class MyOrderQueue {
    //注入模拟消息队列类
    @Autowired
    private MockQueue mockQueue;
    @Autowired
    private DeferredResultHolder deferredResultHolder;
//    ....
    @RequestMapping("/orderMockQueue")
    public DeferredResult orderQueue() throws InterruptedException {
        System.out.println("主线程开始");
        
        //随机生成8位数
//        String orderNumber = RandomStringUtils.randomNumeric(8);
        String orderNumber = new Random(8).toString();
        mockQueue.setPlaceOrder(orderNumber);
 
        DeferredResult result = new DeferredResult();
        deferredResultHolder.getMap().put(orderNumber,result);
        Thread.sleep(1000);
        System.out.println("主线程返回");
        
        return result;
    }
}
