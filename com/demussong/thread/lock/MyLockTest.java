package com.demussong.thread.lock;

import java.util.concurrent.CountDownLatch;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/10/16 12:06
 */
public class MyLockTest {

    static int i = 0;
    static         MyLock lock = new MyLock();

    public static void main(String[] args) throws InterruptedException {



        int threadCount = 10000;
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int j = 0; j < threadCount; j++) {

            new Thread(() -> {
                try{
                    lock.lock();
                    i++;
                }finally {
                    lock.unlock();
                    countDownLatch.countDown();
                }
            }).start();
        }

        countDownLatch.await();
        System.out.println("i=" + i);
    }
}
