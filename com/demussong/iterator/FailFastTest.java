package com.demussong.iterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/8/24 15:11
 */
public class FailFastTest {

    public static void main(String[] args) {
//        testList();
        failFast();
    }

    static void testList() {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(4);
        list.add(5);
        list.add(4);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int n = iterator.next();
            if (n == 5) {
                iterator.remove();
            }else {
                System.out.println(n);
            }
        }

        System.out.println("size=" + list.size());

    }

    static void failFast() {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 10; i < 100; i++){
            map.put(i, i);
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 20; i++){
            list.add(i);
        }
        Iterator<Integer> it = list.iterator();
        int temp = 0;
        while(it.hasNext()){
            if(temp == 3){
                temp++;
                list.remove(3);
            }else{
                temp++;
                System.out.println(it.next());
            }
        }
    }

}
