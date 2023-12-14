package com.demussong.jvm.order;

/*
 * @Author: demussong
 * @Description: refer:https://tech.meituan.com/2014/09/23/java-memory-reordering.html
 * 多线程下会存在类似双重校验锁的问题
 * @Date: 2023/12/13 15:27
 */
public class Container {
    public static class SomeThing {
        private int status;

        public SomeThing() {
            status = 1;
        }

        public int getStatus() {
            return status;
        }
    }

    private volatile SomeThing object;

    public void create() {
        object = new SomeThing();
    }

    public SomeThing get() {
        while (object == null) {
            Thread.yield(); //不加这句话可能会在此出现无限循环
        }
        return object;
    }
}
