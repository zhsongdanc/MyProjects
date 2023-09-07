package com.demussong.deadlock;

import java.util.ArrayList;
import java.util.List;

/**
 * @author demussong
 * @describe
 * @date 2023/9/6 22:23
 */
//todo 银行家算法

public class DeadLock {
    // 1. 不可抢占   可以主动释放其他线程的资源
    // 2. 循环等待   每次先申请A，再申请B
    // 3. 占有且等待（占用且不主动释放）  一次性申请所有资源
    // 4. 互斥

    public static void main(String[] args) {

    }

    static void wrongMethod() {
        Account from = new Account();
        Account to = new Account();
        from.wrongTransfer(to, 10);
    }


}


class Account{
    private int balance;

    // 没加锁，如果两个人给相同一个人转账会有问题
    void wrongTransfer(Account to, int count) {
        assert balance >= count;
        this.balance-=count;
        to.balance+=count;
    }

    // 如果A给B转账，同时B给A转账，有可能死锁
    void primeTransfer(Account to, int count) {
        synchronized (this) {
            synchronized (to) {
                assert balance >= count;
                this.balance-=count;
                to.balance+=count;
            }
        }
    }


    void transferByAllocateAll(Account to, int count) {
        synchronized (this) {
            synchronized (to) {
                assert balance >= count;
                this.balance-=count;
                to.balance+=count;
            }
        }
    }


    static class Allocator{


        private Allocator(){}

        private
        private List<Object> locks = new ArrayList<>();

        public Allocator getInstance() {
            return
        }

        private boolean apply(Object from, Object to) {

        }
    }

}