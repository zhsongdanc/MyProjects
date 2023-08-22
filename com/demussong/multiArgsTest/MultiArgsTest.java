package com.demussong.multiArgsTest;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2022/11/10 11:10
 */
public class MultiArgsTest {
    public static void main(String[] args) {
//测试，传入多个参数
        test("hello", "world", "13sd", "china", "cum", "ict");
    }

    public static void test(String... arguments) {
        for (int i = 0; i < arguments.length; i++) {
            System.out.println(arguments[i]);
        }
    }

}
