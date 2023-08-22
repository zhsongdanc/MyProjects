package com.demussong.thread.lock;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/4/25 13:38
 */
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AwaitSignalDemo {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void doWait() throws InterruptedException {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " is waiting...");
            condition.await();
            System.out.println(Thread.currentThread().getName() + " is notified.");
        } finally {
            lock.unlock();
        }
    }

    public void doNotify() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " is notifying...");
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AwaitSignalDemo demo = new AwaitSignalDemo();

        Thread t1 = new Thread(() -> {
            try {
                demo.doWait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            demo.doNotify();
        }, "Thread-2");

        t1.start();
        Thread.sleep(1000);
        t2.start();
    }
}
