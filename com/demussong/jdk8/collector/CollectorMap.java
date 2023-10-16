package com.demussong.jdk8.collector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/3/31 17:03
 */
public class CollectorMap {

    // https://blog.csdn.net/stone_yw/article/details/87297937
    public static void main(String[] args) {
//        Student h1 = new Student("h1", 20);
//        Student h2 = new Student("h2", 21);
//        Student h3 = new Student("h2", 22);
//        Student h4 = new Student("h4", 21);
//        List<Student> list = Arrays.asList(h1,h2,h3,h4);
//        solve3(list);


        groupByTest();
    }

    static void solve1(List<Student> list) {
        // 用后面的value覆盖前面的value
        Map<String, Integer> map = list.stream().collect(Collectors.toMap(Student::getName, Student::getAge, (val1, val2)->val2));
        System.out.println(map.toString());

    }

    static void solve2(List<Student> list) {
        // 求和
        Map<String,Integer> map = list.stream().collect(Collectors.toMap(Student::getName, Student::getAge,
                Integer::sum));
        System.out.println(map.toString());

    }

    static void solve3(List<Student> list) {
        // 将重复key的value作为list存储
        Map<String, List<Integer>> map = list.stream().collect(Collectors.toMap(Student::getName,
                person -> {
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(person.getAge());
                    return list1;
                },
                (value1, value2) -> {
                    value1.addAll(value2);
                    return value1;
                }));

        System.out.println(map.toString());
    }


    static void groupByTest() {
        List<Student> list = new ArrayList<>();
        list.add(new Student("demus", 13));
        list.add(new Student("demus", 12));
        list.add(new Student("sss", 13));
        list.add(new Student("sss", 15));
        list.add(new Student("sss", 14));








        Map<String, IntSummaryStatistics> map = list.stream()
                .collect(Collectors.groupingBy(stu -> build(stu), Collectors.summarizingInt(Student::getAge)));
        for (Entry<String, IntSummaryStatistics> entry : map.entrySet()) {
            String key = entry.getKey();
            IntSummaryStatistics value = entry.getValue();
            System.out.println(key);
            System.out.println("max:" + value.getMax());
            System.out.println("min:" + value.getMin());
            System.out.println("count:" + value.getCount());
            System.out.println("ave:" + value.getAverage());
            System.out.println("sum:" + value.getSum());
        }

        Map<String, List<Integer>> valInfoMap = new HashMap<>();
        valInfoMap.put("sss", Arrays.asList(4));
        valInfoMap.put("demus", Arrays.asList(4,5,1));




        Map<String, List<List<Integer>>> valInfoMap2 = list.stream().collect(Collectors.groupingBy(Student::getName
                , Collectors.mapping(stu -> valInfoMap.get(stu.getName()), Collectors.toList())));

        Map<String, List<Student>> collect = list.stream()
                .collect(Collectors.groupingBy(Student::getName, Collectors.toList()));



    }

    static String build(Student student) {
        return student.getName();
    }


    static class Student{
        private String name;
        private int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
