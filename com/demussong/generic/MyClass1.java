package com.demussong.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/10/13 16:50
 */
public class MyClass1<T> {

    private List<T> myList;


    // 输出T
    static void testGetTypeArguments() throws NoSuchFieldException {
        MyClass1<String> myClass = new MyClass1<>();
        Type type = myClass.getClass().getDeclaredField("myList").getGenericType();

        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type[] typeArguments = parameterizedType.getActualTypeArguments();
            for (Type typeArgument : typeArguments) {
                System.out.println(typeArgument.getTypeName());
            }
        }
    }


    static void testGetTypeArgumentsActual() throws NoSuchFieldException {
        MyClass1<String> myClass = new MyClass1<>();
        Type type = myClass.getClass().getDeclaredField("myList").getGenericType();

        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type[] typeArguments = parameterizedType.getActualTypeArguments();
            for (Type typeArgument : typeArguments) {
                System.out.println(typeArgument.getTypeName());
            }
        }
    }


    public static void main(String[] args) throws Exception{
        testGetTypeArgumentsActual();
    }

}
