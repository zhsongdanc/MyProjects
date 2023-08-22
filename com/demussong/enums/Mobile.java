package com.demussong.enums;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2022/9/28 19:54
 */
public enum Mobile {
    Samsung(400), Nokia(250),Motorola(325);

    int price;
    Mobile(int p) {
        price = p;
    }
    int showPrice() {
        return price;
    }
}