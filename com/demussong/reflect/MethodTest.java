package com.demussong.reflect;

import java.lang.reflect.Method;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/5/9 10:16
 */
public class MethodTest {

    public static void main(String[] args) {
        MethodTest methodTest = new MethodTest();
        Method[] methods = methodTest.getClass().getMethods();
        for (Method method : methods) {
            Class<?> declaringClass = method.getDeclaringClass();
            Class<? extends Method> aClass = method.getClass();
            System.out.println("");
        }
    }

    void testHello() {
        System.out.println("Hello!");
    }
}
