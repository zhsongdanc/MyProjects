package com.demussong.parent;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/1/12 14:18
 */
public class Son1 extends Parent1{
    static {
        System.out.println("static of son1");
    }
    protected Son1(String s) {
        super(s);
        System.out.println("Son1");
    }

    public void me(){
        super.method1();
    }
}
