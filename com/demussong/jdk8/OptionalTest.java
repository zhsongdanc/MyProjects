package com.demussong.jdk8;

import java.util.Optional;
import java.util.Random;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2022/10/17 21:03
 */
public class OptionalTest {
	public static void main(String[] args) {

	}

	static void testOrElse(){
		String[] names = new String[]{"zhang", "wang", "li", "zhao", "wu"};
		String wang = Optional.of("wang").orElse(getRandomName(names));// 执行该句时会打印"Generating a name..."
		System.out.println(wang);
		// 不会执行orElseGet里的内容
		Optional.of("wang").orElseGet(() -> getRandomName(names));
	}

	public static String getRandomName(String[] names) {
		System.out.println("Generating a name...");
		Random random = new Random();
		return names[random.nextInt(5)];
	}

}
