package com.demussong.str;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/8/17 15:53
 */
public class IsNumeric {

    public static void main(String[] args) {

//        System.out.println(isNumeric("232"));
//        System.out.println(isNumeric("232.2"));
//        System.out.println(isNumeric("232b2"));
        double d = 3.1340;
        double d2 = 3;
        double d3 = 3.115;



        System.out.println(Double.parseDouble("4.20"));
        System.out.println(Double.parseDouble("4.00"));
        System.out.println(Double.parseDouble(String.format("%.2f", d)));
        System.out.println(Double.parseDouble(String.format("%.2f", d2)));
        System.out.println(String.format("%.2f", d3));
        System.out.println(roundToTwoDecimalPlaces(d));
        System.out.println(roundToTwoDecimalPlaces(d2));
        System.out.println(roundToTwoDecimalPlaces(d3));
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    public static double roundToTwoDecimalPlaces(double number) {
//        DecimalFormat df = new DecimalFormat("#.00");
//        String formattedNumber = df.format(number);
//
//        return         Double.parseDouble(formattedNumber);


        BigDecimal bg = new BigDecimal(number);
        return bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

    }
}
