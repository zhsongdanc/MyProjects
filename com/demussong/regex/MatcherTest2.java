package com.demussong.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherTest2 {
    public static void main(String[] args) {
        test1();
    }

    static void test1() {
        String expression = "a && (b || c)";

        // 解析表达式
        String pattern = "([a-zA-Z]+)\\s+(&&|\\|\\|)\\s+\\(([a-zA-Z]+)\\s+(&&|\\|\\|)\\s+([a-zA-Z]+)\\)";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(expression);

        if (matcher.find()) {
            String b = matcher.group(3);
            String operator = matcher.group(4);

            System.out.println("b: " + b);
            System.out.println("operator: " + operator);
        } else {
            System.out.println("Invalid expression");
        }
    }
}
