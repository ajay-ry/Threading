package com.java.multithreading.com.java.multithreading.es;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class FutureDemo implements Callable {
    ArrayList<Integer> numbers;
    public FutureDemo(List<Integer> numbers){
        this.numbers= (ArrayList<Integer>) numbers;
    }

    @Override
    public Object call() {
        int sum =0;
        for(Integer i: numbers){
            sum=sum+i;
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ArrayList num_list_1 = new ArrayList(Arrays.asList(1,2,3,4,5));
        ArrayList num_list_2 = new ArrayList(Arrays.asList(6,7,8,9,10));

        ExecutorService executorService = Executors.newScheduledThreadPool(3);

        List<Future<Integer>> futureList = new ArrayList<>();
        Future<Integer> future_1 =  executorService.submit(new FutureDemo(num_list_1));
        futureList.add(future_1);
        Future<Integer> future_2 =  executorService.submit(new FutureDemo(num_list_2));
        futureList.add(future_2);

        for(int i=0;i<futureList.size();i++){
            int sum =futureList.get(i).get();
            System.out.println(sum);
        }

        executorService.shutdown();
        executorService.awaitTermination(100,TimeUnit.MILLISECONDS);

    }
}
