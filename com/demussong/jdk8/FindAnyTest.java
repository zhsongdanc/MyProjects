package com.demussong.jdk8;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2022/11/22 14:26
 */
public class FindAnyTest {

    public static void main(String[] args) {
        // 采用这种方法返回Optional.empty()，否则会报异常
        int[] data = {3,4,5};
        OptionalInt any = Arrays.stream(data).filter(Objects::nonNull).filter(x -> x > 7).findAny();
        int asInt = any.getAsInt();
        System.out.println(asInt);
    }

    static void test(){
        int[] data = {3,4,5};
        OptionalInt any = Arrays.stream(data).filter(x -> x > 3).findAny();
        int asInt = any.getAsInt();
        System.out.println(asInt);
    }
}
