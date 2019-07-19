package com.java.multithreading.ipc;

public class ProducerConsumer {

    public static boolean consumer_flag=false;

    public synchronized void produce(){
        for(int i=1;i<=10;i++){
            System.out.println("Produced:"+i);
            consumer_flag=true;
            notify();
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consume(){
        for(int i=1;i<=10;i++){
            try {
                if (!consumer_flag){
                    wait();
                }

                System.out.println("Consuming:"+i);
                consumer_flag=false;
                notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
