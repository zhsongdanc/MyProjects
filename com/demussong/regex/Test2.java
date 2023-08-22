package com.demussong.regex;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2022/11/1 14:27
 */
public class Test2 {

    public static void main(String[] args) {
        String str = "a001.wfeoweio";

        System.out.println(str.toUpperCase());
        String[] split = str.split(".");
        for (String s : split) {
            System.out.println(s);
        }
    }
}
