package com.demussong.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/5/29 11:22
 */
public class MatcherTest {

    public static void main(String[] args) {
//        test1();
        spaceTest();
    }

    static void test1() {
        String str = "hello world";

        Pattern pattern = Pattern.compile("hello(\\s)(\\w+)");
        Matcher matcher = pattern.matcher(str);
        System.out.println(matcher.find());
        System.out.println(matcher.group(0));
        System.out.println(matcher.group(1));
        System.out.println(matcher.matches());
    }

    static void spaceTest() {
        String str = "  ";
        String str1 = "    ";
        String str2 = "";
        System.out.println(str.length());

        Pattern pattern = Pattern.compile("(\\s)");
        Matcher matcher = pattern.matcher(str);
        System.out.println(matcher.find());
        System.out.println(matcher.group(0).length());
//        System.out.println(matcher.group(1));
//        System.out.println(matcher.matches());
    }

}
