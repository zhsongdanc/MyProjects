package com.demussong.thread.pool;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2022/12/20 10:04
 */
public class InterruptTest {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {

            for (int i = 0; i < 3; i++) {
                Thread.currentThread().interrupt();
                try {
                    System.out.println("test");
//                    for (int k = 0; k < 10000; k++) {
//                        System.out.println("k=" + k);
//                    }
                    Thread.sleep(30000);
                } catch (InterruptedException e) {
                    System.out.println("线程被打断");
                }
            }
        },"Thread-1");
        thread.start();

//        for (int i = 0; i < 10; i++) {
//            thread.interrupt();
//        }

    }
}
