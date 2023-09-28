package com.demussong.jvm;

import java.util.function.BinaryOperator;

/*
 * @Author: demussong
 * @Description: 测试invokedynamic指令
 * @Date: 2023/9/21 16:57
 */
public class InvokeDynamicTest {
    public static void main(String[] args) {
        Calculator calculator = getCalculator("+");
        int result = calculator.calculate(5, 3);
        System.out.println(result); // 输出：8
    }

    public static Calculator getCalculator(String operator) {
        BinaryOperator<Integer> operation;
        if (operator.equals("+")) {
            operation = (a, b) -> a + b;
        } else if (operator.equals("-")) {
            operation = (a, b) -> a - b;
        } else {
            throw new IllegalArgumentException("Invalid operator");
        }

        return operation::apply;
    }
}
interface Calculator {
    int calculate(int a, int b);
}

class Addition implements Calculator {
    @Override
    public int calculate(int a, int b) {
        return a + b;
    }
}

class Subtraction implements Calculator {
    @Override
    public int calculate(int a, int b) {
        return a - b;
    }
}
