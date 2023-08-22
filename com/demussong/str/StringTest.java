package com.demussong.str;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2022/10/18 17:15
 */
public class StringTest {
	public static void main(String[] args) {
		formatTest();
	}


	static void replaceTest() {
		String s = "abcdba";
		String replace = s.replace("ab", "ce");
		System.out.println(replace);

		// 支持正则表达式
		String s1 = s.replaceAll("ab", "ce");
		System.out.println(s1);


	}

	static void formatTest() {
		String szh = "szh";
		String cd = "cd";
		String format = String.format("%s/%s", szh, cd);
		System.out.println(format);


		String format2 = String.format("%s%s", "a", "b");
		System.out.println(format2);
	}
}
