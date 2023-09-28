package com.demussong.thread.banker;

/*
 * @Author: demussong
 * @Description: reference: https://xiaolincoding.com/os/4_process/multithread_sync.html#%E5%93%B2%E5%AD%A6%E5%AE%B6%E5%B0%B1%E9%A4%90%E9%97%AE%E9%A2%98
 * @Date: 2023/9/28 14:32
 */
public class Thinker1 {

    // todo 下面这样可以模拟死锁
    public static void main(String[] args) {
        Thinker1 thinker1 = new Thinker1();
        thinker1.solution1();
    }

    /**
     *  n个哲学家 ， n个筷子， 同时拿到两个才可以吃
     */
    //

    // solution1: 每个人只要拿到左右筷子就吃-----每个人都拿到左边，就会死锁
    // solution1 :每次只让一个人吃
    // solution2： 每次只让一半人吃
    // solution3: 最终解法(设计三个状态)

    static int N = 100;

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
                    synchronized (chopstic[left]) {
                        synchronized (chopstic[right]) {
                            eat();

                        }
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
            Thread.sleep(1000);
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
