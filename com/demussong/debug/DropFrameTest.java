package com.demussong.debug;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/11/10 10:22
 */
public class DropFrameTest {

    public static void main(String[] args) {
        System.out.println("begin!");
        test2();
        System.out.println("end!");
    }

    static void test2() {
        System.out.println("in test2");
        test3();
    }

    static void test3() {
        System.out.println("in test3");
    }
}
