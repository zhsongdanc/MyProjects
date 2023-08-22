package com.demussong.paxosbasic;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/4/6 16:58
 */
public class InstanceTest {

    public static void main(String[] args) {
        SmallBook smallBook = new SmallBook();
        if (smallBook instanceof Book) {
            System.out.println(true);
        }
    }
}

class Book{

}

class SmallBook extends Book{

}
