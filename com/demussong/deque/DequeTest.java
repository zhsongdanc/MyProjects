package com.demussong.deque;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/9/7 17:35
 */
public class DequeTest {

    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<>();
        deque.addLast("a");
        deque.addLast("b");
        deque.addLast("c");

        String s = deque.removeFirst();
        System.out.println(s);
        System.out.println(deque.size());
        String s2 = deque.removeFirst();
        System.out.println(s2);
        System.out.println(deque.size());
    }
}
