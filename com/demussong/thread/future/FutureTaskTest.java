package com.demussong.thread.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2022/12/21 20:37
 */
public class FutureTaskTest {

    public static void main(String[] args) {
        FutureTask<Integer> task = new FutureTask<Integer>(()-> {
            System.out.println("Pretend that something complicated is computed");
            Thread.sleep(5000);
            return 42;
        });

        Thread t1 = new Thread(()->{
            try {
                int r = task.get();
                System.out.println("Result is " + r);
            } catch (InterruptedException | ExecutionException e) {}
        });
        Thread t2 = new Thread(()->{
            try {
                int r = task.get();
                System.out.println("Result is " + r);
            } catch (InterruptedException | ExecutionException e) {}
        });
        Thread t3 = new Thread(()->{
            try {
                int r = task.get();
                System.out.println("Result is " + r);
            } catch (InterruptedException | ExecutionException e) {}
        });

        System.out.println("Several threads are going to wait until computations is ready");
        t1.start();
        t2.start();
        t3.start();
        task.run(); // let the main thread to compute the value
    }
}
