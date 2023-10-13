package com.demussong.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/10/13 16:44
 */
public class GenericTest {



    // 输出String
    public static void main(String[] args) {
        MySubClass mySubClass = new MySubClass();
        Type type = mySubClass.getClass().getGenericSuperclass();

        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type[] typeArguments = parameterizedType.getActualTypeArguments();
            for (Type typeArgument : typeArguments) {
                System.out.println(typeArgument.getTypeName());
            }
        }
    }
}
class MyClass<T> {
    // ...
}

class MySubClass extends MyClass<String> {
    // ...
}
