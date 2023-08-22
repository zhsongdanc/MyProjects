package com.demussong.regex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2022/10/18 19:08
 */
public class SimpleTest {
	public static void main(String[] args) {
//		System.out.println(isValidMobileNumber("13785955290"));
//		System.out.println(isValidMobileNumber("1378595529"));
//		System.out.println(isValidMobileNumber("1378595529a"));
//		System.out.println(isValidMobileNumber("137859552922"));

//		System.out.println(match());;

		complicateMatch();
//		simpleMatch();
	}

	static boolean isValidMobileNumber(String s) {
		return s.matches("\\d{11}");
	}

	static boolean match() {
		//正则规则
//		Pattern pattern=Pattern.compile("^[\u0391-\uFFE5a-zA-Z·.。\\s]{0,}+$");
		Pattern pattern=Pattern.compile("[a-f]{4,7}$");
		Pattern pattern2=Pattern.compile("(\\d{1,3}.){3}\\d{1,3}");
//		Pattern pattern=Pattern.compile("^[a-z]+$");

		//被校验的字符串
		Matcher match=pattern.matcher("aaabca");

		return pattern2.matcher("1.1.1?1").matches();
	}

	static void complicateMatch() {
		String content = "";
		Pattern pattern = Pattern.compile("a*");
		Pattern pattern2 = Pattern.compile("[a-zA-Z]*e[a-zA-Z0-9]*$");
		System.out.println(pattern.matcher(content).matches());
		System.out.println(pattern2.matcher(content).matches());
	}

	static void simpleMatch() {
		String s = "abfww23foi;a";
		List<String> list = Arrays.asList("foi","i;a",";",";d");
		List<String> collect = list.stream().filter(s::contains).collect(Collectors.toList());
		System.out.println(collect);

		System.out.println(s.contains("foi"));
		System.out.println(s.contains("abf"));
		System.out.println(s.contains("i;a"));
		System.out.println(s.contains(";"));
		System.out.println(s.contains(";d"));
	}
}
