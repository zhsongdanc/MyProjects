package com.demussong.thread.banker;

import java.util.concurrent.locks.ReentrantLock;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/9/28 15:21
 */
public class Thinker2 {
    // 该方法不用阻塞， 但并发低
    public static void main(String[] args) {
        Thinker2 thinker2 = new Thinker2();
        thinker2.solution1();
    }

    /**
     *  n个哲学家 ， n个筷子， 同时拿到两个才可以吃
     */
    //

    // solution1: 每个人只要拿到左右筷子就吃-----每个人都拿到左边，就会死锁
    // solution1 :每次只让一个人吃
    // solution2： 每次只让一半人吃
    // solution3: 最终解法(设计三个状态)

    static int N = 10;

    static ReentrantLock lock = new ReentrantLock();

    static Object[] chopstic = new Object[N];
    static {
        for (int i = 0; i < chopstic.length; i++) {
            chopstic[i] = new Object();
        }
    }

    void solution1() {
        for (int i = 0; i < N; i++) {
            int left = i;
            int right = (i + 1) % N;
            Thinker thinker = new Thinker(i, () -> {
                while (true) {
                    think();

                    try {
                        lock.lock();
                        synchronized (chopstic[left]) {
                            synchronized (chopstic[right]) {
                                eat();

                            }
                        }

                    }finally {
                        lock.unlock();
                    }


                }
            }, "thinker" + i);
            thinker.start();
        }
    }

    void think () {
        System.out.println(Thread.currentThread().getName() + ": is thinking");
    }


    void eat() {
        System.out.println(Thread.currentThread().getName() + ": is eating");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    class Thinker extends Thread {
        private int index;

        public Thinker(int index, Runnable runnable, String threadName) {
            super(runnable, threadName);
            this.index = index;
        }

    }
}
