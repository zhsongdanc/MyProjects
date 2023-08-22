package com.demussong.exceptions;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/7/11 10:36
 */
public class Test {

    public static void main(String[] args) {
        try{
            int i = 9;
            if (i == 9){
                throw new RuntimeException("i = 9");
            }
        }catch (Exception e) {
            System.out.println("hello");
        }
    }
}
