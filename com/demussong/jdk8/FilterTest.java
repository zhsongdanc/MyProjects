package com.demussong.jdk8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/5/4 20:01
 */
public class FilterTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("str1");
        list.add("str2");
        list.add("str3");
        list = list.stream().filter(item -> item.contains("3")).collect(Collectors.toList());
        System.out.println(list.size());
    }
}
