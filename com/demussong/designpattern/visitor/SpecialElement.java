package com.demussong.designpattern.visitor;

/*
 * @Author: demussong
 * @Description: 当新增加一个新的类型元素SpecialElement时，需要在Visitor中新增接口
 * @Date: 2023/1/12 14:08
 */
public class SpecialElement {
    public void acceptSpecial(IVisitor iVisitor) {
        iVisitor.visit(this);
    }
    @Override
    public String toString() {
        return "This is SpecialElement";
    }
}
