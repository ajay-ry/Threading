package com.java.multithreading.com.java.multithreading.es;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadDemo implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread()+" "+new Date());
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(new Date());
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);
        for(int i=0;i<10;i++)
            executorService.schedule(new ScheduledThreadDemo(),10,TimeUnit.SECONDS);
        executorService.shutdown();
        executorService.awaitTermination(1000,TimeUnit.MILLISECONDS);
    }
}
