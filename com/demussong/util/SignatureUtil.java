//package com.demussong.util;
//
///*
// * @Author: demussong
// * @Description:
// * @Date: 2022/8/25 20:36
// */
//
//import com.tencent.hr.common.util.encrypt.DigestUtil;
//
//public class SignatureUtil {
//    public static void main(String[] args) {
//        String appToken = "c1c54ad1-1368-4a22-a101-eed5279e22d1";
//        String timestamp = "1661431878834";
//        //e378296fb3fd8d17717fcf47afd19bfeef1da86c8cc6a6b7c7877001666e0dd9
//        String timestamp2 = "1675760060568";
//        String appName = "dos";
//        String signature = DigestUtil.sha256().digest(appName + appToken + timestamp2);
//        // ec10b4c37097f6b73c2d02cc83a474328d6981e53208d05c5eb41593eef8e548
//        System.out.println(signature);
//        test2();
//        System.out.println("test3");
//        test3();
//        test4();
//        test5();
//        test6();
//        testHrChatService();
//        testTRobotWeim();
//        testDemo5();
//        testDosYu();
//        System.out.println("线上");
//        test3();
//    }
//
//    public static void test2() {
//
//        String appToken = "2ZKAvEljPImaFmKskMxhSmlO1BYS476U";
//        String timestamp = "1661431878834";
//        String appName = "nts-servicemarket";
//        String signature = DigestUtil.sha256().digest(appName + appToken + timestamp);
//        // ec10b4c37097f6b73c2d02cc83a474328d6981e53208d05c5eb41593eef8e548
//        System.out.println(signature);
//    }
//
//
//
//    // 测试环境
//    public static void test4() {
//        System.out.println("test4");
//        String appToken = "c1c54ad1-1368-4a22-a101-eed5279e22d1";
//        String timestamp = "1661431878834";
//        Long time = System.currentTimeMillis();
//        String timestamp2 = String.valueOf(time);
//        System.out.println(timestamp2);
//        String appName = "dos";
//        String signature = DigestUtil.sha256().digest(appName + appToken + timestamp2);
//        // 03f3880444a7ddf162126c14bc817f953d664a6dc6c501baebf17241f0ec1bb2
//        System.out.println(signature);
//    }
//
//    // e098a1fd-c120-4a9b-a63e-11ba50e90dd9
//    public static void test5() {
//        String appToken = "e098a1fd-c120-4a9b-a63e-11ba50e90dd9";
//        String timestamp = "1661431878834";
//        String appName = "workday-dev";
//        String signature = DigestUtil.sha256().digest(appName + appToken + timestamp);
//        // 6982b571315b961b092c4bb1f7a61fcba6d08171333b5f878d4e04f20dcfbeb8
//        System.out.println(signature);
//    }
//
//
//    //
//    public static void test6() {
//        String appToken = "c64ae016-fd55-4d4f-81ea-492925965a64";
//        String timestamp = "1661431878834";
//        String appName = "hrmd3-interface-service";
//        String signature = DigestUtil.sha256().digest(appName + appToken + timestamp);
//        //bcf65949aab87bc16eda4a39107fda09a06f3d4410dbcd0975c90cb89e77c112
//        System.out.println(signature);
//    }
//
//    public static void testDemo5() {
//        String appToken = "4134e3d3-cd8d-4e81-b7aa-3b9c2b186246";
//        String timestamp = "1661431878834";
//        String appName = "test-demo5";
//        String signature = DigestUtil.sha256().digest(appName + appToken + timestamp);
//        //91700ce112e6c4a09b145bde4229e964e8484c20fed4620be1d5080fe3634f03
//        System.out.println(signature);
//    }
//
//    public static void testDosYu() {
//        String appToken = "2948b03d-c35b-4f46-a542-ce40a1a18be8";
//        String timestamp = "1661431878834";
//        String appName = "dos-test-yu";
//        String signature = DigestUtil.sha256().digest(appName + appToken + timestamp);
//        //91700ce112e6c4a09b145bde4229e964e8484c20fed4620be1d5080fe3634f03
//        System.out.println(signature);
//    }
//
//
//
//
//    // 正式环境
//    public static void test3() {
//        String appToken = "279bae2c-40b7-409e-8463-0c9ab973e9de";
//        String timestamp = "1661431878834";
//        String appName = "oversea-interface-proxy";
//        String signature = DigestUtil.sha256().digest(appName + appToken + timestamp);
//        // ec10b4c37097f6b73c2d02cc83a474328d6981e53208d05c5eb41593eef8e548
//        System.out.println(signature);
//
//
//        String dosToken = "5cb013f4-d205-4217-b0f2-220d63a0c4ac";
//        String timestamp2 = "1683359032025";
//        String appName2 = "dos";
//        System.out.println("dos---online");
//        String signature2 = DigestUtil.sha256().digest(appName2 + dosToken + timestamp2);
//        //ffcbdc32bfba8e5218e67749477f057a9fd4307e52f8e208ed1c82d226382740
//        System.out.println(signature2);
//
//        String appToken3 = "ccefbccf-7294-410e-8bd4-78906bec3dd8";
//        String timestamp3 = "1676624996383";
//        String appName3 = "campus-center";
//        String signature3 = DigestUtil.sha256().digest(appName3 + appToken3 + timestamp3);
//        // 98fbe7560ad0267d200832bdd6739ab6c0165becc69ee31a8df6322cf75cdbb6
//        System.out.println(signature3);
//
//    }
//
//
//
//
//
//
//
//    //3068fc4a-5b11-4da5-ab17-78346f50df74  hr-chat-service
//    public static void testHrChatService() {
//        String appToken = "3068fc4a-5b11-4da5-ab17-78346f50df74";
//        String timestamp = "1661431878834";
//        String appName = "hr-chat-service";
//        String signature = DigestUtil.sha256().digest(appName + appToken + timestamp);
//        // 0b51e0df12bc7b42d8a7ee1c15bdf2be6aba696d3741e81937258ea1572c2b6e
//        System.out.println(signature);
//    }
//
//    //e36eef17-c69d-4268-9c04-1abecf31e8a9  t-robot-webim
//    public static void testTRobotWeim() {
//        String appToken = "e36eef17-c69d-4268-9c04-1abecf31e8a9";
//        String timestamp = "1661431878834";
//        String appName = "t-robot-webim";
//        String signature = DigestUtil.sha256().digest(appName + appToken + timestamp);
//        // 92f421e4c4052332d60caacc6597571b9b3324911ce25d5d56279f161046a4c4
//        System.out.println(signature);
//    }
//}
