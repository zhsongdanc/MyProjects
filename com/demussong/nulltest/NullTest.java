package com.demussong.nulltest;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/8/31 10:26
 */
public class NullTest {

    public static void main(String[] args) {
        String s = "";
        boolean contains = s.contains("");
        System.out.println(contains);
    }
}
