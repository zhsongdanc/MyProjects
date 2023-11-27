package com.demussong.limit;

/*
 * @Author: demussong
 * @Description:
 *
 * 漏桶算法与令牌桶算法的区别在于，漏桶算法能够强行限制数据的传输速率，令牌桶算法能够在限制数据的平均传输速率的同时还允许某种程度的突发传输。

需要注意的是，在某些情况下，漏桶算法不能够有效地使用网络资源，因为漏桶的漏出速率是固定的，所以即使网络中没有发生拥塞，漏桶算法也不能使某一
* 个单独的数据流达到端口速率。因此，漏桶算法对于存在突发特性的流量来说缺乏效率。而令牌桶算法则能够满足这些具有突发特性的流量。通常，漏桶算法
* 与令牌桶算法结合起来为网络流量提供更高效的控制。
 * @Date: 2023/11/27 16:25
 */
public class TokenBucket {
    private final long capacity;
    private long tokens;
    private long lastTime;
    private final long fillInterval;

    public TokenBucket(long capacity, long fillInterval) {
        this.capacity = capacity;
        this.tokens = 0;
        this.lastTime = System.currentTimeMillis();
        this.fillInterval = fillInterval;
    }

    public synchronized boolean tryConsume(long num) {
        long now = System.currentTimeMillis();
        // 计算时间差，模拟令牌生成
        tokens = Math.min(capacity, tokens + (now - lastTime) / fillInterval);
        lastTime = now;
        // 检查令牌是否足够
        if (tokens >= num) {
            tokens -= num;
            return true;
        } else {
            return false;
        }
    }
}
