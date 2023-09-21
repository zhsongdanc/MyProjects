package com.demussong.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.PriorityBlockingQueue;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/9/19 19:33
 */
public class BlockingQueueTest {

    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<Integer>(10);

        LinkedBlockingDeque<Integer> linkedBlockingDeque = new LinkedBlockingDeque<>();
        ConcurrentLinkedDeque<Integer> concurrentLinkedDeque = new ConcurrentLinkedDeque<>();

        PriorityBlockingQueue<Integer> priorityBlockingQueue = new PriorityBlockingQueue<>();


    }
}
