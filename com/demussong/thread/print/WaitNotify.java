package com.demussong.thread.print;

import java.util.function.Consumer;

/*
 * @Author: demussong
 * @Description:
 * lambda 本质是一个函数，它可以独立于外部变量存在
 * @Date: 2023/6/2 18:52
 */
public class WaitNotify {
    static int val = 0;
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();


        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println(val++);

                lock2.notify();

                try {
                    lock1.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "thread-1");

        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println(val++);

                lock1.notify();

                try {
                    lock2.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "thread-2");

        thread1.start();
        thread2.start();

    }
}
