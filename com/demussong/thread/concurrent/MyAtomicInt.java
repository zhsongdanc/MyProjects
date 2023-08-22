package com.demussong.thread.concurrent;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/4/18 19:26
 */

import java.lang.reflect.Field;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import sun.misc.Unsafe;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/4/18 19:08
 */
public class MyAtomicInt {


    private static final Unsafe unsafe;
    private static final long valueOffset;

    private   volatile int x = 0;
    private static CountDownLatch countDownLatch = new CountDownLatch(2);

    static {

        try {
            Field f =Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            unsafe = (Unsafe) f.get(null);
            valueOffset = unsafe.objectFieldOffset
                    (MyAtomicInt.class.getDeclaredField("x"));
        } catch (Exception ex) { throw new Error(ex); }
    }
    public static void main(String[] args) throws Exception{
//        for (int i = 0; i < 100; i++) {
//            x = 0;
//            test1();
//            System.out.println(x);
//        }
        MyAtomicInt myAtomicInt = new MyAtomicInt();
        myAtomicInt.test1();
        countDownLatch.await();
        System.out.println("end:" + myAtomicInt.x);
    }


    void test1() {
        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                this.incrementAndGet();
//                unsafe.compareAndSwapInt(this, valueOffset, 0, 100);
//                x++;
                System.out.println(Thread.currentThread().getName() + ":" + x);
            }
            countDownLatch.countDown();
        },"thread1").start();


        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                unsafe.getAndAddInt(this, valueOffset, 1);

//                unsafe.compareAndSwapInt(this, valueOffset, 0, 10);
                System.out.println(Thread.currentThread().getName() + ":" + x);
            }
            countDownLatch.countDown();
        }, "thread2").start();
    }
    public final int incrementAndGet() {
        return unsafe.getAndAddInt(this, valueOffset, 1) + 1;
    }
}
