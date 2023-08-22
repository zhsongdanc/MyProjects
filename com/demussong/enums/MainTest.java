package com.demussong.enums;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2022/9/28 19:51
 */
public class MainTest {
    public static void main(String[] args) {

    test2();
//        System.out.println("CellPhone List:");
//        for(Mobile m : Mobile.values()) {
//            System.out.println(m + " costs " + m.showPrice() + " dollars");
//        }
//
//        Mobile ret;
//        ret = Mobile.valueOf("Samsung");
//        System.out.println("Selected : " + ret + " " + ret.showPrice());
    }

    static void test() {
        FileVisitPatternEnum fileVisitPatternEnum = FileVisitPatternEnum.valueOf("esb");
        String pathPrefix = fileVisitPatternEnum.getPathPrefix();
        System.out.println(pathPrefix);
    }

    static void test2() {
        JoinTypeEnum joinTypeEnum = JoinTypeEnum.valueOf("inner");

        JoinTypeEnum joinTypeEnum1 = JoinTypeEnum.getTypeByValue("inner");
        JoinTypeEnum joinTypeEnum2 = JoinTypeEnum.getTypeByValue("left");


        System.out.println(joinTypeEnum.getJoinVal());
        System.out.println(joinTypeEnum1.getJoinVal());
        // 单例模式，一定相等
        System.out.println(joinTypeEnum == joinTypeEnum1);
        System.out.println(joinTypeEnum2.getJoinVal());
        System.out.println("hello");
    }
}
