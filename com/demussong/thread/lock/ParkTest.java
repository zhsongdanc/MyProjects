package com.demussong.thread.lock;

import java.util.concurrent.locks.LockSupport;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/9/28 13:57
 */
public class ParkTest {

    public static void main(String[] args) throws Exception{
        t1();
    }

    static void t1() throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("start.....");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("park....");
            LockSupport.park();
            System.out.println("resume.....");

        });
        thread.start();
        Thread.sleep(2000);
        System.out.println("unpark....");
        LockSupport.unpark(thread);

    }
}
