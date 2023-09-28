package com.demussong.thread.banker;

import java.util.concurrent.locks.LockSupport;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/9/28 14:08
 */
public class MotherSonSyn {

    private static Thread mother;
    private static Thread son;


    public static void main(String[] args) {

        son = new Thread(() -> {

            System.out.println(Thread.currentThread().getName() + ":唤醒妈妈做饭");
            LockSupport.unpark(mother);
            System.out.println(Thread.currentThread().getName() + ":等待妈妈做饭而阻塞");
            LockSupport.park();
            // 吃饭
            eating();
        }, "儿子");

        mother = new Thread( () -> {

            System.out.println(Thread.currentThread().getName() + ":等待做饭");
            LockSupport.park();
            cook();
            System.out.println(Thread.currentThread().getName() + ":唤醒儿子吃饭");

            LockSupport.unpark(son);
        }, "妈妈");

        son.start();
        mother.start();
    }


    static void cook() {
        System.out.println(Thread.currentThread().getName() + ":is cooking");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void eating() {
        System.out.println(Thread.currentThread().getName() + ":is eating");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
