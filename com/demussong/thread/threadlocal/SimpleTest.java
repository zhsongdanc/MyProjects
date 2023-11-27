package com.demussong.thread.threadlocal;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/11/23 15:44
 */
public class SimpleTest {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public static void main(String[] args) {
        threadLocal.set("th1");

    }
}
