package com.demussong.thread.pool;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2022/12/19 15:33
 */


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        //创建一个可缓存线程池
//        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
//        for (int i = 0; i < 10; i++) {
//            try {
//                //sleep可明显看到使用的是线程池里面以前的线程，没有创建新的线程
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            cachedThreadPool.execute(new Runnable() {
//                public void run() {
//                    //打印正在执行的缓存线程信息
//                    System.out.println(Thread.currentThread().getName()+"正在被执行");
//                }
//            });
//        }

        callableTest();
    }

    private static void callableTest() {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Future submit = executorService.submit(new MyCallable());
        Object res = "123";
        try {
            res = submit.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("res=" + res);
    }
}

class MyCallable implements Callable {


    @Override
    public Object call() throws Exception {
        return "demus";
    }
}
