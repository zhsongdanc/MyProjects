package com.demussong.jvm;

import java.util.function.Consumer;

/*
 * @Author: demussong
 * @Description: lambda生成字节码
 * @Date: 2023/9/21 16:10
 */
public class LambdaTest {

    public static void main(String[] args) {
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("hello");
    }
}
