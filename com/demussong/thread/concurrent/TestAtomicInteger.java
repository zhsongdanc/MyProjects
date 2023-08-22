package com.demussong.thread.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/4/18 19:43
 */
public class TestAtomicInteger {

    public static void main(String[] args) {
        test12();
    }

    static void test1() {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                atomicInteger.incrementAndGet();
                System.out.println(Thread.currentThread().getName() + ":" + atomicInteger.get());
            }
        },"thread1").start();


        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                atomicInteger.incrementAndGet();
                System.out.println(Thread.currentThread().getName() + ":" + atomicInteger.get());
            }
        }, "thread2").start();
    }

    static void test12() {
        AtomicInteger2 atomicInteger = new AtomicInteger2(0);
        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                atomicInteger.incrementAndGet();
                System.out.println(Thread.currentThread().getName() + ":" + atomicInteger.get());
            }
        },"thread1").start();


        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                atomicInteger.incrementAndGet();
                System.out.println(Thread.currentThread().getName() + ":" + atomicInteger.get());
            }
        }, "thread2").start();
    }
}
