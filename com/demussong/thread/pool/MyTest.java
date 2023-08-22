package com.demussong.thread.pool;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2022/12/19 18:47
 */
public class MyTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        MyCallableTask task1 = new MyCallableTask("4");
        MyCallableTask task2 = new MyCallableTask("6");
        List<MyCallableTask> myCallableTasks = Arrays.asList(task1, task2);
//        List<Future<String>> futures = new ArrayList<Future<String>>(myCallableTasks);
        List<Future<String>> s = executorService.invokeAll(myCallableTasks);
        for (Future<String> stringFuture : s) {
            System.out.println(stringFuture.get());
        }
    }
}

class MyCallableTask implements Callable<String>{

    private int ticket = 5;

    public MyCallableTask(String ticket) {
        this.ticket = Integer.parseInt(ticket);
    }

    @Override
    public String call() throws Exception {
        String tmp = ticket + "";
        for (int i = 0; i < 10; i++) {
            if (ticket > 0) {
                System.out.println("ticket = " + ticket--);
            }
        }
        return tmp;
    }
}
