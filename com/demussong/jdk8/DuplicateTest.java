package com.demussong.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2022/11/7 09:47
 */
public class DuplicateTest {

    public static void main(String[] args) {
        List<BookInfoVo> list = Arrays.asList(new BookInfoVo("sss","szh"), new BookInfoVo("sss", "cd"));
        ArrayList<BookInfoVo> distinctLiost = list.stream()
                .collect(
                        Collectors.collectingAndThen(
                                Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(BookInfoVo::getRecordId))), ArrayList::new)
                );
        System.out.println(distinctLiost.toString());
    }
}
class BookInfoVo{

    public BookInfoVo(String recordId, String name) {
        this.recordId = recordId;
        this.name = name;
    }

    private String recordId;
    private String name;

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}