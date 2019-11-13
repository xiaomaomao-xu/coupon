package com.hsys.coupon;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 模拟消息队列 类
 * Created by Fant.J.
 */
@Component
public class MockQueue {
 
    //下单消息
    private String placeOrder;
    //订单完成消息
    private String completeOrder;
 
    public String getPlaceOrder() {
        return placeOrder;
    }
    
    @Async
    public void setPlaceOrder(String placeOrder) throws InterruptedException {
        new Thread(()->{
            System.out.println("接到下单请求"+placeOrder);
            //模拟处理
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //给completeOrder赋值
            this.completeOrder = placeOrder;
            System.out.println("下单请求处理完毕"+placeOrder);
        }).start();
    }
 
    public String getCompleteOrder() {
        return completeOrder;
    }
 
    public void setCompleteOrder(String completeOrder) {
        this.completeOrder = completeOrder;
    }
}
 