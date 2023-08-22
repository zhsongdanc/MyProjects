package com.demussong.designpattern.visitor;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/1/12 14:00
 */
public class FlowerVisitor implements IVisitor{

    @Override
    public void visit(IElement iElement) {
        System.out.println(iElement);
    }

    @Override
    public void visit(SpecialElement specialElement) {
        System.out.println(specialElement);
    }
}
