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
    private int id;
    private Allocator allocator;
    public Account(){}

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


    public Account(Allocator allocator) {
        this.allocator = allocator;
    }
    // solve method1: 一次性申请所有资源
    void transferSolve1(Account to, int count) {

        while (allocator.apply(this, to));
        try{
            // 申请时的加锁是为了保证顺序申请，这里需要锁定账户保证原子性
            synchronized (this) {
                synchronized (to) {
                    assert balance >= count;
                    this.balance-=count;
                    to.balance+=count;
                }
            }
        }finally {
            allocator.remove(this, to);
        }

    }
    static class Allocator{


        private Allocator(){}

        private static Allocator allocator = new Allocator();

        private List<Account> locks = new ArrayList<>();

        public Allocator getInstance() {
            return allocator;
        }

        private boolean apply(Account from, Account to) {

            synchronized (this) {
                if (locks.contains(from) || locks.contains(to)) {
                    return false;
                }
                locks.add(from);
                locks.add(to);
                return true;
            }


        }

        // 一个线程如果持有锁，但其他没持有锁的线程却删了锁，这就很奇怪。所以这里也加锁
        private synchronized void remove(Account from, Account to) {
            locks.remove(from);
            locks.remove(to);
        }
    }

    // method2: 按序申请
    void transferSolve2(Account to, int count) {

        Account small = this;
        Account big = to;
        if (small.id > big.id) {
            Account tmp = small;
            small = big;
            big = tmp;
        }

        synchronized (small) {
            synchronized (big) {
                assert balance >= count;
                this.balance-=count;
                to.balance+=count;
            }
        }

    }



}
