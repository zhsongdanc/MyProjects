package com.demussong.mianshi;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/11/29 10:24
 */
public class StringTest {

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2);

        String str1 = "Hello";
        String str2 = new String("Hello");
        System.out.println(str1 == str2);


        String str3 = new String("Hello");
        String str4 = new String("Hello");
        System.out.println(str3 == str4);


        String str5 = "Hello";
        String str6 = new String("Hello").intern();
        System.out.println(str5 == str6);
    }
}
