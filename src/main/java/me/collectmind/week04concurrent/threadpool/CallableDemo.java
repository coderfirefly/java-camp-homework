package me.collectmind.week04concurrent.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Callable 有返回值
 * Runnable 没有返回值
 *
 * Created by monica on 2020/11/17.
 */
public class CallableDemo {

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(4);

        try {
            String str = executorService.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return "I am a task, which submited by the so called laoda, and run by those anonymous workers";
                }
            }).get();
            System.out.println("str:" + str);
        } catch (Exception e) {
            e.printStackTrace();
        }

        executorService.shutdown();
        System.out.println("Main Thread End!");
    }
}
