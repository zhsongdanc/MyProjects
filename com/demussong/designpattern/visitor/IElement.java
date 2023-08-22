package com.demussong.designpattern.visitor;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/1/12 14:00
 */
public interface IElement {
    public void doSomething();
    public void accept(IVisitor iVisitor);
}
