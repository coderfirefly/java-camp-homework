package me.collectmind.java.camp.homework.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

/**
 * 原子类
 * @author monica
 * @date 2020/11/17
 */
public class AtomicDemo {

    public static void main(String[] args) {
//        final SyncCount count = new SyncCount();
        final AtomicCount count = new AtomicCount();
        final LongAdder longAdder = new LongAdder();


        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                for (int j = 0; j< 10000; j++) {
                    count.add();
                    longAdder.increment();
                }
            }).start();
        }

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("num=" + count.getNum());
        System.out.println("num=" + longAdder.sum());
    }
}

class AtomicCount {
    private AtomicInteger num = new AtomicInteger();

    public int add() {
        return num.getAndIncrement();
    }

    public int getNum() {
        return num.get();
    }
}


class SyncCount {
    private int num = 0;

    public synchronized int add() {
        return num++;
    }

    public int getNum() {
        return num;
    }
}