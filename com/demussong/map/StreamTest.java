package com.demussong.map;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/7/21 15:42
 */
public class StreamTest {

    public static void main(String[] args) {


        Stu s1 = new Stu("2", "2");
        Stu s2 = new Stu("2", "4");
        Stu s3 = new Stu("2", "0");

        Stu s4 = new Stu("3", "10");
        Stu s5 = new Stu("3", "3");
        Stu s6 = new Stu("3", "7");
        Stu s7 = new Stu("3", "5");

        List<Stu> stus = Arrays.asList(s1, s2, s3, s4, s5, s6, s7);
//        stus.stream().collect(Collectors.toMap(Stu::getId, obj -> new ArrayDeque(Collections.singletonList(obj))),
//                StreamTest::mergeLists);

        List<String> list = Arrays.asList("1", "2", "3","4", "5");
        List<String> list2 = Arrays.asList("5", "4");
        boolean b = containsAll(list, list2);
    }


    public static boolean containsAll(final Collection<?> coll1, final Collection<?> coll2) {
        if (coll2.isEmpty()) {
            return true;
        }
        final Iterator<?> it = coll1.iterator();
        final Set<Object> elementsAlreadySeen = new HashSet<>();
        for (final Object nextElement : coll2) {
            if (elementsAlreadySeen.contains(nextElement)) {
                continue;
            }

            boolean foundCurrentElement = false;
            while (it.hasNext()) {
                final Object p = it.next();
                elementsAlreadySeen.add(p);
                if (nextElement == null ? p == null : nextElement.equals(p)) {
                    foundCurrentElement = true;
                    break;
                }
            }

            if (!foundCurrentElement) {
                return false;
            }
        }
        return true;
    }



}
class Stu{

    public Stu(String id, String age) {
        this.id = id;
        this.age = age;
    }

    private String id;
    private String age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "id='" + id + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
