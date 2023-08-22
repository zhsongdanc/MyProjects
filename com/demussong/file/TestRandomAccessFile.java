package com.demussong.file;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2022/10/9 14:39
 */
import java.io.IOException;
import java.io.RandomAccessFile;

// 使用RandomAccessFile读写文件
public class TestRandomAccessFile {
    public static void main(String[] args) throws IOException {
        RandomAccessFile rf = new RandomAccessFile("rtest.dat", "rw");
        for (int i = 0; i < 10; i++) {
            //写入基本类型double数据
            rf.writeDouble(i * 1.414);
        }
        rf.close();
        rf = new RandomAccessFile("rtest.dat", "rw");
        //直接将文件指针移到第5个double数据后面
        rf.seek(5 * 8);
        //覆盖第6个double数据
        rf.writeDouble(47.0001);
        rf.close();
        rf = new RandomAccessFile("rtest.dat", "r");
        for (int i = 0; i < 10; i++) {
            System.out.println("Value " + i + ": " + rf.readDouble());
        }
        rf.close();
    }
}