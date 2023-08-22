package com.demussong.designpattern.visitor;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/1/12 14:01
 */
public class Element1 implements IElement{

    @Override
    public void doSomething() {
        System.out.println("do Something...");
    }

    // 接受访问者，并将自身引用传入访问者
    // 应用实例：您在朋友家做客，您是访问者，朋友接受您的访问，不同的人在访问不同的景点时会有不同的看法（比如送祝福、带礼物）
    // this--朋友的描述    visit方法的实现--对朋友的描述做出一个判断
    public void accept(IVisitor iVisitor) {
        iVisitor.visit(this);
    }

    @Override
    public String toString() {
        return "访问朋友时我会给他带花";
    }
}
