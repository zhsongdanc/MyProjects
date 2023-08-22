package com.demussong.object;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/4/19 19:19
 */
public class ObjectTest {

    public static void main(String[] args) {
        FieldsInfo fieldsInfo1 = new FieldsInfo();
        fieldsInfo1.setOrder(99);
        fieldsInfo1.setBasicFlag(false);
        FieldsInfo fieldsInfo2 = new FieldsInfo();
        fieldsInfo2.setBasicFlag(null);

        System.out.println(fieldsInfo1.equals(fieldsInfo2));
        System.out.println(fieldsInfo1.hashCode());
        System.out.println(fieldsInfo1.hashCode() == fieldsInfo2.hashCode());


        FieldsInfo fieldsInfo3 = new FieldsInfo();
        fieldsInfo3.setOrder(9);
        fieldsInfo3.setBasicFlag(false);
        FieldsInfo fieldsInfo4 = new FieldsInfo();
        fieldsInfo4.setOrder(8);
        fieldsInfo4.setBasicFlag(null);

        System.out.println(fieldsInfo3.equals(fieldsInfo4));
        System.out.println(fieldsInfo3.hashCode());
        System.out.println(fieldsInfo3.hashCode() == fieldsInfo4.hashCode());

        List<FieldsInfo> onlineFields = new ArrayList<>();
        onlineFields.add(fieldsInfo1);
        onlineFields.add(fieldsInfo3);
        List<FieldsInfo> preSaveFields = new ArrayList<>();
        preSaveFields.add(fieldsInfo2);
        preSaveFields.add(fieldsInfo4);

        test(onlineFields, preSaveFields);
    }

    static void test(List<FieldsInfo> onlineFields, List<FieldsInfo> preSaveFields) {
        // 获取字段并集

        // 获取字段删除交集的剩余字段
        List<FieldsInfo> originFields = new ArrayList<>();
        onlineFields.forEach(item -> {
            if (!preSaveFields.contains(item)) {
                originFields.add(item);
            }
        });
        List<FieldsInfo> newFields = new ArrayList<>();
        preSaveFields.forEach(item -> {
            if (!onlineFields.contains(item)) {
                newFields.add(item);
            }
        });


        System.out.println(Arrays.toString(originFields.toArray()));
        System.out.println(Arrays.toString(newFields.toArray()));
    }

}
