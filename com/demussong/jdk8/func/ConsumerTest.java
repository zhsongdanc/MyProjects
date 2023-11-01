package com.demussong.jdk8.func;

import java.util.function.BiPredicate;
import java.util.function.Consumer;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/10/27 14:23
 */
public class ConsumerTest {

    public static void main(String[] args) {
        Consumer<String> consumer = str -> System.out.println(str);
        consumer.accept("demus");

        assert 1 > 2;
    }


    static void predicateTest() {
        BiPredicate<String, String> predicate = (s1, s2) -> s1.equals(s2);

        predicate.test("","");
    }

}
