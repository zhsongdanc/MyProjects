package com.demussong.thread.banker;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/9/28 15:26
 */

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/9/28 14:32
 */
public class Thinker3 {

    // todo 每次只允许一半人吃
    public static void main(String[] args) {
        Thinker3 thinker3 = new Thinker3();
        thinker3.solution1();
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
            final int j = i;
            Thinker thinker = new Thinker(i, () -> {
                while (true) {
                    think();

                    if (j % 2 == 0) {
                        synchronized (chopstic[left]) {
                            synchronized (chopstic[right]) {
                                eat();

                            }
                        }
                    } else {
                        synchronized (chopstic[right]) {
                            synchronized (chopstic[left]) {
                                eat();

                            }
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
            Thread.sleep(10);
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

