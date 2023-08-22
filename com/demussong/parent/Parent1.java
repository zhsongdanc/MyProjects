package com.demussong.parent;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/1/12 14:18
 */
public class Parent1 {
    static {
        System.out.println("static of parent1");
    }
    protected Parent1(String s) {
        System.out.println("parent1");
    }

    protected void method1(){}

    private int a;
}
