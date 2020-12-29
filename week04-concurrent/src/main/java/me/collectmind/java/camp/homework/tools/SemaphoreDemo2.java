package me.collectmind.java.camp.homework.tools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 一次获取多个信号量
 *
 * @author monica
 * @date 2020/11/17
 */
public class SemaphoreDemo2 {

    private final static int THREAD_COUNT = 20;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(5);

        for (int i = 0; i < THREAD_COUNT; i++) {
            final int threadNum = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire(3);
                    test(threadNum);
                    semaphore.release(3);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        executorService.shutdown();
    }

    private static void test(int threadNum) throws Exception {
        System.out.println("id: " + threadNum + ", " + Thread.currentThread().getName());
        Thread.sleep(1000);
    }
}
