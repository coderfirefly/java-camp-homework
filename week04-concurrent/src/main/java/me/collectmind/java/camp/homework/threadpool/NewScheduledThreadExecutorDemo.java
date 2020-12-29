package me.collectmind.java.camp.homework.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 创建周期执行的线程池
 *
 * Created by monica on 2020/11/17.
 */
public class NewScheduledThreadExecutorDemo {

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(4);

        for (int i = 0; i < 10; i++) {
            final int no = i;

            Runnable task = () -> {
                System.out.println("start:" + no);
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("end:" + no);
            };

            // 10s后开始执行
            executorService.schedule(task, 10, TimeUnit.SECONDS);
        }

        executorService.shutdown();
        System.out.println("Main Thread End!");
    }

}
