package com.demussong.list;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/8/10 16:27
 */
public class ListSort {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("-1", "3", "-4");
        List<String> collect = list.stream().sorted(Comparator.comparing(item -> item)).collect(Collectors.toList());
        System.out.println("");
    }
}
