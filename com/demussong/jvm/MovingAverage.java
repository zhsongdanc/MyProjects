package com.demussong.jvm;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/9/19 16:05
 */
public class MovingAverage {

    private int count = 0;
    private double sum = 0.0D;
    public void submit(double value){
        this.count ++;
        this.sum += value;
    }
    public double getAvg(){
        if(0 == this.count){ return sum;}
        return this.sum/this.count;
    }
}
