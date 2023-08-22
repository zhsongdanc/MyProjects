package com.demussong.object;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/4/25 10:49
 */
public class HashCodeTest {

    public static void main(String[] args) {
        Object o = new Object();
        int x = o.hashCode() >>> 28;
        int y = x & 15;
        System.out.println(y);
    }
}
