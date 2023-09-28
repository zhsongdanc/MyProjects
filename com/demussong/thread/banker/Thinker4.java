package com.demussong.thread.banker;

/*
 * @Author: demussong
 * @Description:在这里再提出另外一种可行的解决方案，我们用一个数组 state 来记录每一位哲学家的三个状态，分别是在进餐状态、思考状态、饥饿状态（正在试图拿叉子）。

那么，一个哲学家只有在两个邻居都没有进餐时，才可以进入进餐状态。
 * @Date: 2023/9/28 15:40
 */

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/9/28 14:32
 */
public class Thinker4 {

    // todo 不再以叉子作为共享单位，而是人，左右两边的人都没有进餐，自己就可以进餐
    public static void main(String[] args) {
        Thinker4 thinker4 = new Thinker4();
        thinker4.solution1();
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

    static ReentrantLock stateLock = new ReentrantLock();

    static Object[] chopstic = new Object[N];
    static {
        for (int i = 0; i < chopstic.length; i++) {
            chopstic[i] = new Object();
        }
    }
    static Thinker[] thinkerList = new Thinker[N];

    void solution1() {
        for (int i = 0; i < N; i++) {
            int left = (i - 1 + N) % N;
            int right = (i + 1) % N;
            final int j = i;
            thinkerList[j] = new Thinker(i, () -> {
                while (true) {
                    think();
                    takeFork(j);
                    LockSupport.park();
                    eat();
                    putFork(j);

                }
            }, "thinker" + i);
            thinkerList[j].start();
        }
    }

    void think () {
        System.out.println(Thread.currentThread().getName() + ": is thinking");
    }


    void takeFork(int i) {


        try {
            stateLock.lock();
            thinkerList[i].setThinkerState(ThinkerState.HUNGRY);
            tryTakeFork(i);

        }finally {
            stateLock.unlock();
        }


    }

    void tryTakeFork(int i) {
        int left = (i - 1 + N) % N;
        int right = (i + 1) % N;
        if (thinkerList[left].getThinkerState() != ThinkerState.EATING &&
                thinkerList[right].getThinkerState() != ThinkerState.EATING &&
                thinkerList[i].getThinkerState() == ThinkerState.HUNGRY) {
            LockSupport.unpark(thinkerList[i]);
            thinkerList[i].setThinkerState(ThinkerState.EATING);
        }
    }

    void putFork(int i) {
        int left = (i - 1 + N) % N;
        int right = (i + 1) % N;

        try {
            stateLock.lock();
            thinkerList[i].setThinkerState(ThinkerState.THINKING);
            tryTakeFork(left);
            tryTakeFork(right);
        }finally {
            stateLock.unlock();
        }

    }

    void eat() {
        System.out.println(Thread.currentThread().getName() + ": is eating");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    class Thinker extends Thread {
        private int index;
        private ThinkerState thinkerState;

        public Thinker(int index, Runnable runnable, String threadName) {
            super(runnable, threadName);
            this.index = index;
        }


        public ThinkerState getThinkerState() {
            return thinkerState;
        }

        public void setThinkerState(ThinkerState thinkerState) {
            this.thinkerState = thinkerState;
        }
    }


    enum ThinkerState {
        THINKING,
        HUNGRY,
        EATING;
    }

}
