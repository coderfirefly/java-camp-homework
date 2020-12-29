package me.collectmind.java.camp.homework.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建线程池Demo
 * Created by monica on 2020/11/17.
 */
public class ExecutorServiceDemo {

    public static void main(String[] args) {
//        创建固定大小的线程池
//        ExecutorService executorService = Executors.newFixedThreadPool(8);

//        创建单个线程的线程池
//        ExecutorService executorService = Executors.newSingleThreadExecutor();

//        创建大小不固定的线程池
        ExecutorService executorService = Executors.newCachedThreadPool();


        for (int i = 0; i < 10; i++) {
            final int no = i;
            executorService.execute(() -> doTask(no));
        }

        executorService.shutdown();
        System.out.println("Main Thread End!");
    }

    private static void doTask(int no) {
        System.out.println("start:" + no);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end:" + no);
    }
}
