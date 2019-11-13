package com.hsys.coupon.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncTask {
//    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Async
    public void doTask2(int i) throws InterruptedException{
        System.out.println("Task2-Native"+i+" started.");
    }
}
