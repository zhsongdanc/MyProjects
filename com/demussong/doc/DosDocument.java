package com.demussong.doc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/9/1 13:37
 */
public class DosDocument {

    private int DEFAULT_FETCH_SIZE = 10000;


    public static void main(String[] args) {
        // 1.传limit,直接返回

    }


    public List<Object> cursorQuery(Integer limit, Integer offset) {

        int min = queryMin();
        if (limit != null) {
            return queryByLimit(limit);


        }else {
            int count = queryCount();
            int max = queryMax();


            if (offset == null) {
                queryFirstPage(min, max, DEFAULT_FETCH_SIZE);
            }


        }
        return null;
    }

    public List<Object> queryByLimit(Integer limit) {

        // todo 这样会全排序
        // select * from t left join t2  order by id limit limit;
        return Arrays.asList(new Object());
    }


    public List<Object> queryFirstPage(int min, int max, int stepSize) {

        // todo 步长怎么设置
        // select * from t left join t2 where id >= min and id <= min + DEFAULT_FETCH_SIZE  order by id limit (DEFAULT_FETCH_SIZE)
        List<Object> firstPage = new ArrayList<>();

        return firstPage;

//        if (firstPage)

    }


        public List<Object> queryPage(Integer offset, int max) {
        List<Object> res = new ArrayList<>();

        do{
            // select * from t left join t2 where id > offset and id < offset + DEFAULT_FETCH_SIZE  and id <= MAX
        }while (res.size() == 0);

        return null;
    }


    public int queryMin() {
        return 0;
    }

    public int queryMax() {
        return 0;
    }



    public int queryCount() {
        return 0;
    }
}
