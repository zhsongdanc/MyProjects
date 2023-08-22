package com.demussong.simple;

import java.util.ArrayList;
import java.util.List;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2022/10/25 12:01
 */
public class GeneTest {
	public static void main(String[] args) {
		Person person = new Person();
		List<Apple> apples = new ArrayList<>();
		person.setFruits(apples);
	}
}
class Fruit{

}

class Apple extends Fruit{

}

class Person{
	private List<? extends Fruit> fruits;

	public List<? extends Fruit> getFruits() {
		return fruits;
	}

	public void setFruits(List<? extends Fruit> fruits) {
		this.fruits = fruits;
	}
}