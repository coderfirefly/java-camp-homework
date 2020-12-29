package me.collectmind.java.camp.homework.collections;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ConcurrentHashMap 示例
 *
 * @author monica
 * @date 2020/11/21
 */
public class ConcurrentHashMapDemo {

    public static void main(String[] args) {
        demo();
    }

    public static void demo() {
        final Map<String, AtomicInteger> count = new ConcurrentHashMap<>();
        final CountDownLatch endLatch = new CountDownLatch(2);

        Runnable task = () -> {
            AtomicInteger oldValue;
            for (int i = 0; i < 5; i++) {
                oldValue = count.get("a");
                System.out.println(Thread.currentThread().getName() + " oldValue:" + oldValue);
                if (null == oldValue) {
                    AtomicInteger zeroValue = new AtomicInteger(0);
                    oldValue = count.putIfAbsent("a", zeroValue);
                    if (null == oldValue) {
                        oldValue = zeroValue;
                    }
                }
                // 多线程会并发修改map中的value, ConcurrentHashMap使用CAS保证并发安全
                oldValue.incrementAndGet();
            }
            endLatch.countDown();
        };

        new Thread(task).start();
        new Thread(task).start();

        try {
            endLatch.await();
            System.out.println("count:" + count);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
