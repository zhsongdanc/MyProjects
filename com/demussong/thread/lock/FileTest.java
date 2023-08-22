package com.demussong.thread.lock;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.locks.ReentrantLock;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/7/19 11:39
 */
public class FileTest {

    private static Object lock = new Object();

    public static void main(String[] args) throws IOException, FileNotFoundException, InterruptedException {

        Thread thread1 = new Thread(() -> {
            String filePath = "/Users/demussong/szh.txt";
            File file = new File(filePath);
            FileOutputStream fileOutputStream = null;
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 100; i++) {
                sb.append("abc" + i/10);
            }
            try {
                fileOutputStream.write(sb.toString().getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                e.printStackTrace();
            }
        },"thread1");



        Thread thread2 = new Thread(() -> {
            String filePath = "/Users/demussong/szh.txt";
            File file = new File(filePath);
            FileInputStream fileInputStream = null;
            byte[] buffer = new byte[400];
            try {
                fileInputStream = new FileInputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                fileInputStream.read(buffer);
                System.out.println(new String(buffer));
            } catch (IOException e) {
                e.printStackTrace();
            }
        },"thread2");

        ReentrantLock lock = new ReentrantLock();
        try{
           lock.lock();

        }finally {
            lock.unlock();
        }

//        thread1.start();
        Thread.sleep(1);
        thread2.start();
    }
}
