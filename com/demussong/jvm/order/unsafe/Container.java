package com.demussong.jvm.order.unsafe;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/12/13 15:34
 */


/** 不加：
 * Average : 30063908
 * Max : 40130060
 * Min : 26798643
 *
 * volatile:
 *Average : 32173810
 * Max : 38235810
 * Min : 28301352
 *
 * order:
 * Average : 31086761
 * Max : 45741398
 * Min : 26883437
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

    private SomeThing object;

    private Object value;
    private static final Unsafe unsafe = getUnsafe();
    private static final long valueOffset;
    static {
        try {
            valueOffset = unsafe.objectFieldOffset(Container.class.getDeclaredField("value"));
        } catch (Exception ex) { throw new Error(ex); }
    }

    public void create() {
        SomeThing temp = new SomeThing();
        unsafe.putOrderedObject(this, valueOffset, null);	//将value赋null值只是一项无用操作，实际利用的是这条语句的内存屏障
        object = temp;
    }

    public SomeThing get() {
        while (object == null) {
            Thread.yield();
        }
        return object;
    }


    public static Unsafe getUnsafe() {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            return (Unsafe)f.get(null);
        } catch (Exception e) {
        }
        return null;
    }
}
