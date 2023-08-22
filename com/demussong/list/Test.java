package com.demussong.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2022/11/8 14:05
 */
public class Test {

    public static void main(String[] args) {
        String[] strs = new String[]{"wfe", "qe"};
        List<String> strings = Arrays.asList(strs);


        List<Integer> list = Arrays.asList(4,1,6,8);
        for (Integer integer : list) {
            System.out.println(integer);
        }
//        System.out.println("he");
////        testLoop();
//        test();
    }

    // 会空指针
    static void testLoop() {
        List<String> list = null;
        for (String s : list) {
            System.out.println(s);
        }
    }

    static void test() {
        //
        System.out.println(216*6);
        String s = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCVO+cadpP4DazylZFMzyVf64HzvXu8y/KmEZvX+DPQpIk5uu4UKVDRi+DwJFgAD8a489AY+dTOpoC+X6UmOL6lDoulEYVgQBsfjibZ4s5tTcFiVpkFfGXV3wNFO20oo55L5s7MBnloHzSLWjs/ko9n1U5uWfO2pJpmpn2kA1QNfwIDAQAB";
        System.out.println(s.length()*4);
        System.out.println(864*4/3);
        String s2 = "92352772413905858620940171319828957659714333225048828031703589135633906207834769616892743131457080170402043753015119211035657924624763592959193029057025365371525048592895615875430187192921856477846939700939169106965293333177031246633995784401801666059455801461551837399507737977154805521570194660367750222063";
        System.out.println(s2.length());
    }

    static void assignTest() {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(5);

//        list.get(0) = list.get(0) + 4;
        List<People> list1 = new ArrayList<>();
        People people1 = new People("p1");
        People people2 = new People("p2");
        list1.add(people1);
        list1.add(people2);

        list1.get(0).setName("");

        Integer b = 5;
        Integer c = 6;
        b = c +2;
    }

}
class People{
    public String name;

    public People(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
