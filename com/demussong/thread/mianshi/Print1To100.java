package com.demussong.thread.mianshi;

/*
 * @Author: demussong
 * @Description: m个线程循环打印1-100
 * @Date: 2023/11/4 12:28
 */
public class Print1To100 {

    private static final int threshold = 100;

    private static final int THREAD_COUNT = 3;

    private static Object[] lockList;

    static {
        lockList = new Object[THREAD_COUNT];
    }

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            int finalI = i;
            new Thread(() -> {
                synchronized (lockList[finalI]) {

                }
            }).start();
        }
    }
}
