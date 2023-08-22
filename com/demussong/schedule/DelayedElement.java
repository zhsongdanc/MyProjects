package com.demussong.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/4/25 11:31
 */
public class DelayedElement implements Delayed {
    private final long delayTime;
    private final long expireTime;
    private final String data;

    public DelayedElement(long delay, String data) {
        this.delayTime = delay;
        this.expireTime = System.currentTimeMillis() + delay;
        this.data = data;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long diff = expireTime - System.currentTimeMillis();
        return unit.convert(diff, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        if (this.expireTime < ((DelayedElement) o).expireTime) {
            return -1;
        }
        if (this.expireTime > ((DelayedElement) o).expireTime) {
            return 1;
        }
        return 0;
    }

    public String getData() {
        return data;
    }
}

class DelayQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DelayQueue<DelayedElement> queue = new DelayQueue<>();
        queue.put(new DelayedElement(10000, "element1"));
        queue.put(new DelayedElement(2000, "element2"));
        queue.put(new DelayedElement(3000, "element3"));

        while (!queue.isEmpty()) {
            DelayedElement element = queue.take();
            System.out.println(simpleDateFormat.format(new Date()));
            System.out.println(element.getData());
        }
    }
}
