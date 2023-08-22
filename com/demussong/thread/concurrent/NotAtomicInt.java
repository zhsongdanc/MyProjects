package com.demussong.thread.concurrent;

import java.util.concurrent.CountDownLatch;

/*
 * @Author: demussong
 * @Description:
 * jvm支持对
 * @Date: 2023/4/18 19:08
 */
public class NotAtomicInt {
    private  static  volatile int x = 0;
    private static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws Exception{
//        for (int i = 0; i < 100; i++) {
//            x = 0;
//            test1();
//            System.out.println(x);
//        }
        test1();
        countDownLatch.await();
        System.out.println("end:" + x);
    }


    static void test1() {
        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                x++;
                System.out.println(Thread.currentThread().getName() + ":" + x);
            }
            countDownLatch.countDown();
        },"thread1").start();


        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                x++;
                System.out.println(Thread.currentThread().getName() + ":" + x);
            }
            countDownLatch.countDown();
        }, "thread2").start();
    }
}
