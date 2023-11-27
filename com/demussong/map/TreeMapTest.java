package com.demussong.map;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/11/23 14:27
 */
public class TreeMapTest {

    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
//        map.putIfAbsent()
        test();
    }

    static void test() {
            Map<String, String> map = new TreeMap<String, String>(
                    new Comparator<String>() {
                        public int compare(String obj1, String obj2) {
                            // 降序排序
                            return obj1.compareTo(obj2);
                        }
                    });
            map.put("b", "aaaa");
            map.put("d", "cccc");
            map.put("c", "bbbbb");
            map.put("a", "ddddd");

            Set<String> keySet = map.keySet();
            Iterator<String> iter = keySet.iterator();
            while (iter.hasNext()) {
                String key = iter.next();
                System.out.println(key + ":" + map.get(key));
            }

    }
}
