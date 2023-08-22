package com.demussong.uuid;

import java.util.UUID;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/3/3 11:08
 */
public class UUIDTest {

    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++) {
            String s = UUID.randomUUID().toString();
            s = s.replace("-", "");
            System.out.println(s.length());
            System.out.println(s);
        }
    }
}
