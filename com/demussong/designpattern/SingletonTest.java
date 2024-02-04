package com.demussong.designpattern;

import java.util.concurrent.atomic.AtomicInteger;

public enum SingletonTest {
    INSTANCE;
    private AtomicInteger id = new AtomicInteger();
    public int getId() {
        return id.getAndIncrement();
    }

}
