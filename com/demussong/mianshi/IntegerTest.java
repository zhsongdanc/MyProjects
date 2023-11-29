package com.demussong.mianshi;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/11/29 10:24
 */
public class IntegerTest {

    public static void main(String[] args) {
        // 两个new出来的Integer类型的数据比较，相当于把new出来的地址作比较
        Integer a0 = new Integer(1);
        Integer a1 = new Integer(1);
        System.out.println("Integer 对象作比较 a0 == a1: " + (a0 == a1)); // false

        // 调用intValue方法得到其int值
        System.out.println("使用intValue得到int值作比较 a0 == a1: " + (a0.intValue() == a1.intValue())); // true

        // 把Integer类型的变量拆箱成int类型
        int a2 = 1;
        System.out.println("将Integer自动拆箱 a1 == a2: " + (a1 == a2)); // true

        // Integer对象赋值比较，其实也是内存地址的比较
        // 自动装箱，如果在-128到127之间，则值存在常量池中
        Integer a3 = 30;
        Integer a4 = 30;
        System.out.println("Integer对象赋值比较 a3 == a4: " + (a3 == a4)); // true

        // Integer对象赋值(超过-128~127区间)比较
        Integer a5 = 128;
        Integer a6 = 128;
        System.out.println("Integer对象赋值(超过-128~127区间)比较 a5 == a6: " + (a5 == a6)); // false

        // Integer对象赋值(超过-128~127区间)比较,调用intValue后再作比较
        Integer a7 = 128;
        Integer a8 = 128;
        System.out.println("Integer对象赋值(超过-128~127区间)比较,调用intValue后 a7 == a8: " + (a7.intValue() == a8.intValue()));  //true

        // 使用Integer类的equals()方法进行的是数值的比较
        Integer a9 = 129;
        Integer a10 = 129;
        System.out.println("Integer类的equals()方法进行的是数值的比较 a9 == a10: " + a9.equals(a10)); // true
    }
}
