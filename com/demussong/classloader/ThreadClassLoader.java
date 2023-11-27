package com.demussong.classloader;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/11/25 12:10
 */
public class ThreadClassLoader {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("");
            System.out.println("inner" + Thread.currentThread().getContextClassLoader());
        });

        t1.start();
        System.out.println("main" + Thread.currentThread().getContextClassLoader());

    }
}
