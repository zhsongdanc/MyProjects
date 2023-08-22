package com.demussong.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/4/19 15:32
 */
public class RemoveTest {

    public static void main(String[] args) {
        List<RemoveElement> list1 = new ArrayList<>();
        List<RemoveElement> list2 = new ArrayList<>();
        RemoveElement a = new RemoveElement("a");
        RemoveElement a2 = new RemoveElement("a");
        RemoveElement b = new RemoveElement("b");
        RemoveElement c = new RemoveElement("c");

        list1.add(a2);
        list1.add(b);

        list2.add(a);
        list2.add(c);

        list1.removeAll(list2);
        System.out.println(list1.size());
        System.out.println(list1);
    }
}

class RemoveElement{

    private String data;

    public RemoveElement(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//        RemoveElement that = (RemoveElement) o;
//        return Objects.equals(data, that.data);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(data);
//    }
}
