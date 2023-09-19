package com.demussong.streaming;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/9/12 19:32
 */
public class SimpleTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(7);
        list.add(1);


        list.stream()
                .filter(x -> x > 3)
                .peek(x -> System.out.println("after filter:" + x))
                .map(x -> x+2)
                .peek(x -> System.out.println("after map:" + x))
                .collect(Collectors.toList());
    }
}
