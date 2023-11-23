package com.demussong.thread.mianshi;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.AbstractQueuedSynchronizer.ConditionObject;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/*
 * @Author: demussong
 * @Description: 9. 有3个操作 a b c，希望a和b执行完后 c再执行（Object类下的wait() & notify()，CountDownLatch，ReentrantLock的await() & signal()）

 * @Date: 2023/11/23 13:19
 */
public class SequenceAction {

    public static void main(String[] args) throws InterruptedException {
//        WaitNotifySolution.solve();
//        SignalAwaitSolution.solve();
        CountDownLatchSolution.solve();
    }

}
class WaitNotifySolution{
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();
    private static volatile int state = 1;
    static void solve() throws InterruptedException {

        Thread thread1 = new Thread(() -> {
          synchronized (lock1) {
              while (state != 1) {
                  try {
                      lock1.wait();
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
              }
              System.out.println("Action A");
              state++;
              lock1.notifyAll();
          }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock1) {
                while (state != 2) {
                    try {
                        lock1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Action B");
                state++;
                lock1.notifyAll();
            }
        });



        Thread thread3 = new Thread(() -> {

            synchronized (lock1) {
                while (state != 3) {
                    try {
                        lock1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Action C");
                lock1.notifyAll();
            }

        });

        thread3.start();
        Thread.sleep(1000);
        thread1.start();
        thread2.start();
    }

}
class SignalAwaitSolution{
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private static volatile int state = 1;
    static void solve() {

        Thread thread1 = new Thread(() -> {
           try{
               lock.lock();
               while (state != 1) {
                   try {
                       condition.await();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
               System.out.println("Action A, state =" + state);
               state++;
               condition.signalAll();
           }finally {
               lock.unlock();
           }
        });

        Thread thread2 = new Thread(() -> {
            try{
                lock.lock();
                while (state != 2) {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Action B, state =" + state);
                state++;
                condition.signalAll();
            }finally {
                lock.unlock();
            }
        });

        Thread thread3 = new Thread(() -> {
            try{
                lock.lock();
                while (state != 3) {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Action C, state =" + state);
                state++;
                condition.signalAll();
            }finally {
                lock.unlock();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
class CountDownLatchSolution{
    private static CountDownLatch countDownLatch = new CountDownLatch(2);
    static void solve() {

        Thread thread1 = new Thread(() -> {
            System.out.println("Action A");;
            countDownLatch.countDown();
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            System.out.println("Action B");;
            countDownLatch.countDown();
        });
        thread2.start();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread thread3 = new Thread(() -> {
            System.out.println("Action C");;
//            countDownLatch.countDown();
        });
        thread3.start();
    }
}
