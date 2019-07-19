package com.java.multithreading.ipc;

import com.java.multithreading.ipc.ProducerConsumer;

public class ProducerConsumerClient{
    public static void main(String[] args) {
        //final ProducerConsumer pc = new ProducerConsumer();
        final ProducerConsumer pc = new ProducerConsumer();
        new Thread(new Runnable() {
            @Override
            public void run() {
                pc.produce();
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                pc.consume();
            }
        }).start();


    }

}
