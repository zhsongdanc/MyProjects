package com.demussong.thread;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/8/28 20:50
 */
public class HighCpuThreads {

    private static volatile int x = 0;

    public static void main(String[] args) {
        Thread thread1 = new Thread(new CpuIntensiveTask());
        Thread thread2 = new Thread(new CpuIntensiveTask());

        thread1.start();
        thread2.start();
    }

    static class CpuIntensiveTask implements Runnable {
        @Override
        public void run() {
            while (true) {
                // 执行一些需要消耗 CPU 资源的任务
                for (int i = 0; i < 20000; i++) {
                    HighCpuThreads.x = 24420*24242/225424*24242*i;
//                    try {
////                        Thread.sleep(10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
            }
        }
    }
}
