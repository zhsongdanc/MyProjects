package com.demussong.thread.mianshi;

/*
 * @Author: demussong
 * @Description: 两个线程打印1到100
 * @Date: 2023/11/4 12:39
 */
public class TwoThreadPrint {

    private static int begin = 1;
    private static int threshold = 100;

    private static Object lock = new Object();



    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    lock.notifyAll();

                    if (begin <= threshold) {
                        System.out.println(Thread.currentThread().getName() + " " + begin++);
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        break;
                    }
                }
            }
        });

        Thread thread2 = new Thread(() -> {

            while (true) {
                synchronized (lock) {
                    lock.notifyAll();

                    if (begin <= threshold) {
                        System.out.println(Thread.currentThread().getName() + " " + begin++);
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        break;
                    }

                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
