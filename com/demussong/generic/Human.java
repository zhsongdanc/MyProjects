package com.demussong.generic;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2022/12/30 13:43
 */
public class Human<T> {
    class Work {
        private String where;
        private String workTime;
        private T color;

        public void setColor(T color) {
            this.color = color;
        }
    }

    public <E> Work love(E color) {
        Work work = new Work();
//        work.setColor(color);
        return work;
    }
}
