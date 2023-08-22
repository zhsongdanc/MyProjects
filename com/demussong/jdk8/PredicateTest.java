package com.demussong.jdk8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/2/21 15:45
 */
public class PredicateTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        List<Integer> filterList = new ArrayList<>();
        filterList.add(3);
        filterList.add(4);
        filterList.add(5);
        filterList.add(6);

        List<Predicate<Integer>> predicateList = new ArrayList<>();
        filterList.forEach(item -> predicateList.add(item2 -> item2.equals(item)));
//        predicateList.add(item -> item.equals(1));

        List<Integer> list3 = list.stream().filter(predicateList.stream().reduce(item -> item.equals(1), Predicate::or))
                .collect(Collectors.toList());
        System.out.println(list3);

        Predicate<Integer> predicate1 = item -> item.equals(1);
        Predicate<Integer> predicate2 = item -> item.equals(3);
        List<Integer> list2 = list.stream().filter(predicate1.or(predicate2)).collect(Collectors.toList());
        System.out.println(list2);

        System.out.println("abc".contains(""));
        testString();
    }

    public static void testString() {
        System.out.println("-------------");
        List<String> databaseStrs = new ArrayList<>();
        databaseStrs.add("dos-test-yu");
        databaseStrs.add("dos-t");
        databaseStrs.add("abc-dos-etest");


        String searchCode = "dos test";
        String[] splitValues = searchCode.split("\\s+");
        List<Predicate<String>> predicateList = new ArrayList<>();
        for (String splitValue : splitValues) {
            predicateList.add(item -> item.contains(splitValue));
        }



        List<String> collect = databaseStrs.stream().filter(predicateList.stream().reduce(x -> true, Predicate::and))
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}
