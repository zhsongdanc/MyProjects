package com.demussong;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2022/12/26 10:42
 */
public class clazz {

    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.setName("abc");

        Son s = (Son)parent;
        System.out.println(s.getName());
    }
}
class Parent{
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
class Son extends Parent{
    String son;

    public String getSon() {
        return son;
    }

    public void setSon(String son) {
        this.son = son;
    }
}