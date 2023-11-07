package com.demussong.jdk8.split;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/11/7 11:59
 */
public class SplitTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(1);
//        list.stream().spliterator()
        Spliterator<Integer> first = list.stream().spliterator();
    }
}
