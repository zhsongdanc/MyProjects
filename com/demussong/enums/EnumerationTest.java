package com.demussong.enums;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2022/10/11 20:37
 */
public class EnumerationTest {
    public static void main(String[] args) {
        Vector<String> days = new Vector<>();
        days.add("Monday");
        days.add("Tuesday");
        days.add("Sunday");
        Enumeration<String> elements = days.elements();
        while (elements.hasMoreElements()) {
            System.out.println(elements.nextElement());
        }
    }
}
