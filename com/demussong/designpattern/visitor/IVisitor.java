package com.demussong.designpattern.visitor;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/1/12 14:00
 */
public interface IVisitor {
    public void visit(IElement iElement);

    public void visit(SpecialElement specialElement);
}
