package com.demussong.simple;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/3/28 20:13
 */
public class CalTest {

    public static void main(String[] args) {
        int plainLength = 4095*2 + 10;
        int encryptSegLength = 4095;



        long mod = plainLength % encryptSegLength;

        int calNum=16-encryptSegLength%16;
        int paddingSize=0;
        if(mod>0) {//多余的字节数和16求余，获取需要填充的字节数
            paddingSize=(int) (16-mod%16);
        }
        long cipherLength = plainLength + (long) (plainLength / encryptSegLength)*calNum+paddingSize ;
        System.out.println(4095*3);
    }
}
