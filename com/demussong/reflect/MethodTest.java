package com.demussong.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/5/9 10:16
 */
public class MethodTest {

    public static void main(String[] args) {
//        MethodTest methodTest = new MethodTest();
//        Method[] methods = methodTest.getClass().getMethods();
//        for (Method method : methods) {
//            Class<?> declaringClass = method.getDeclaringClass();
//            Class<? extends Method> aClass = method.getClass();
//            System.out.println("");
//        }

        People people = new People();
        System.out.println(people.getName());
        setPropertyValue(people, "name", "szh");
        System.out.println(people.getName());

    }

    void testHello() {
        System.out.println("Hello!");
    }


    public static void setPropertyValue(Object object, String propertyName, Object value) {
        try {
            // 获取属性的首字母大写形式
            String capitalizedPropertyName = propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);

            // 构建 setter 方法名
            String setterMethodName = "set" + capitalizedPropertyName;

            // 获取属性对应的 setter 方法
            Method setterMethod = object.getClass().getMethod(setterMethodName, value.getClass());

            // 调用 setter 方法设置属性值
            setterMethod.invoke(object, value);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            // 处理异常情况
        }
    }

    static class People{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
