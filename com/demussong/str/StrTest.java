//package com.demussong.str;
//
///*
// * @Author: demussong
// * @Description:
// * @Date: 2022/10/25 16:32
// */
//
//
//import com.sun.xml.internal.ws.util.StringUtils;
//
//import java.util.Arrays;
//
//public class StrTest {
//	public static void main(String[] args) {
//		int code = 123;
//		String message = "TEST";
//		String errMsg = "{\"ERROR_CODE\":\"" + code + ",\"ERROR_MESSAGE\":\" + message + \"}";
//		System.out.println(errMsg);
//		test();
//		testBool();
//		testSubString();
//	}
//
//	static void test() {
//		String s = "fww-wfo wwew a@com";
//		String[] split = s.split("\\s+|-|@");
//		System.out.println(Arrays.toString(split));
//
//		String s2 = "abc(ded";
//		String[] split1 = s2.split("\\(");
//		System.out.println(Arrays.toString(split1));
//	}
//
//	static void testBool() {
//		boolean a = true;
//		String str = String.valueOf(a);
//		System.out.println(str);
//	}
//
//	static void testSubString() {
//		String budgetYear = "2023";
//		if (!StringUtils.isEmpty(budgetYear) && budgetYear.contains("-")) {
//			budgetYear = budgetYear.substring(0, 4);
//		}
//		System.out.println(budgetYear);
//	}
//}
