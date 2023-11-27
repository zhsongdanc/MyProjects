package com.demussong.limit;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/11/27 16:25
 */
public class LeakyBucket {
    private final long capacity;
    private long water;
    private long lastTime;

    public LeakyBucket(long capacity) {
        this.capacity = capacity;
        this.water = 0;
        this.lastTime = System.currentTimeMillis();
    }

    public synchronized boolean tryConsume(long num) {
        long now = System.currentTimeMillis();
        // 计算时间差，模拟水漏出
        water = Math.max(0, water - (now - lastTime));
        lastTime = now;
        // 检查水桶是否还能装下
        if (water + num <= capacity) {
            water += num;
            return true;
        } else {
            return false;
        }
    }
}
