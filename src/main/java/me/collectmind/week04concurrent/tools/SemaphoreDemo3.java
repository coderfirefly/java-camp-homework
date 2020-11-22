package me.collectmind.week04concurrent.tools;

import java.util.concurrent.Semaphore;

/**
 * 使用信号量实现生产者消费者模型
 *
 * @author monica
 * @date 2020/11/17
 */
public class SemaphoreDemo3 {

    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            new Thread(new Producer(), "Producer-" + i).start();
            new Thread(new Consumer(), "Consumer-" + i).start();
        }
    }

    static Warehouse buffer = new Warehouse();

    static class Producer implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    String text = Thread.currentThread().getName();
                    buffer.put(text);
                    System.out.println(">>>" + text);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("Consume <<<" + buffer.get());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    static class Warehouse {
        // 初始化信号量的大小
        private final Semaphore notFull = new Semaphore(10);
        private final Semaphore notEmpty = new Semaphore(0);
        // 控制并发读写
        private final Semaphore mutex = new Semaphore(1);

        private final Object[] items = new Object[10];
        private int putPtr, takePtr, count;

        public void put(Object obj) throws InterruptedException {
            notFull.acquire();
            mutex.acquire();
            items[putPtr] = obj;
            try {
                if (++putPtr == items.length) {
                    putPtr = 0;
                    ++count;
                }
            } finally {
                mutex.release();
                notEmpty.release();

            }
        }

        public Object get() throws InterruptedException {
            notEmpty.acquire();
            mutex.acquire();
            Object obj = items[takePtr];
            try {
                if (++takePtr == items.length) {
                    takePtr = 0;
                    --count;
                }
                return obj;
            } finally {
                mutex.release();
                notFull.release();
            }
        }
    }
}