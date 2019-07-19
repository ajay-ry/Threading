package com.java.multithreading.com.java.multithreading.es;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class SimpleExecutorService implements Runnable {
    @Override
    public void run() {
        try {
            for(int i=0;i<10;i++){
                Thread.sleep(100);
                System.out.println("Thread:"+Thread.currentThread()+"|"+i);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newScheduledThreadPool(5);
        for (int i=1;i<5;i++)
            executorService.submit(new SimpleExecutorService());
        executorService.shutdown();
        executorService.awaitTermination(100,TimeUnit.MILLISECONDS);


    }
}
