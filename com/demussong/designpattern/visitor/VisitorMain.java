package com.demussong.designpattern.visitor;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/1/12 14:11
 */
public class VisitorMain {

    public static void main(String[] args) {

        //new一个朋友， 朋友接受我对朋友的描述做出一个判断
        Element1 element1 = new Element1();
        element1.accept(new FlowerVisitor());

//        SpecialElement specialElement = new SpecialElement();
//        specialElement.acceptSpecial(new FlowerVisitor());
    }
}
