package me.collectmind.week04concurrent.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition的使用
 *
 * Created by monica on 2020/11/17.
 */
public class ConditionDemo {
    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    final Object[] items = new Object[20];
    int putPtr, takePtr, count;


    public static void main(String[] args) {
        ExecutorService producer = Executors.newSingleThreadExecutor();
        ExecutorService consumer = Executors.newSingleThreadExecutor();
        ConditionDemo conditionDemo = new ConditionDemo();

        producer.execute(() -> {
            try {
                for (int i = 0; i < 30; i++) {
                    conditionDemo.put(new Object());
                    System.out.println("***producer put end.   count:" + conditionDemo.count);
                    Thread.sleep(100L);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        consumer.execute(() -> {
            try {
                for (int i = 0; i < 30; i++) {
                    Object object = conditionDemo.take();
                    Thread.sleep(100L);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        producer.shutdown();
        consumer.shutdown();
        System.out.println("Main Thread End!");
    }

    public void put(Object x) throws InterruptedException {
        System.out.println("***producer put start. count:" + count);
        lock.lock();
        System.out.println("***producer take lock. count:" + count);
        try {
            // 数组已满，线程等待，收到notFull的通知时才唤醒线程
            while (count == items.length) {
                notFull.await();
            }

            items[putPtr] = x;
            if (++putPtr == items.length) {
                putPtr = 0;
            }
            ++count;
            notEmpty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        System.out.println("===consumer take start. count:" + count);
        System.out.println("===consumer take lock. count:" + count);
        lock.lock();
        try {
            // 当count为0时，线程阻塞在这里，等待被notEmpty的通知
            while (count == 0) {
                notEmpty.await();
            }
            // 收到通知后线程被唤醒，继续执行

            Object x = items[takePtr];
            if (++takePtr == items.length) {
                takePtr = 0;
            }
            --count;
            notFull.signal();
            System.out.println("===consumer take end.   count:" + count);
            return x;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } finally {
            lock.unlock();
        }
    }





}
