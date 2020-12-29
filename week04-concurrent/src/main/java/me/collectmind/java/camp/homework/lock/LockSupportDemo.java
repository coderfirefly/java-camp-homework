package me.collectmind.java.camp.homework.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * LockSupport线程阻塞工具类
 *
 * @author monica
 * @date 2020/11/17
 */
public class LockSupportDemo {

    private static Object u = new Object();
    private static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    private static ChangeObjectThread t2 = new ChangeObjectThread("t2");

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(1000L);
        t2.start();
        Thread.sleep(1000L);
        // t1发送中断信号
        t1.interrupt();
        // 此时
        LockSupport.unpark(t2);
        t1.join();
        t2.join();

    }

    static class ChangeObjectThread extends Thread {

        public ChangeObjectThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (u) {
                System.out.println("in " + getName());
                // 当前线程阻塞
                LockSupport.park();
                // 被阻塞的线程收到中断的信号，会继续执行
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("in " + getName() + " 被中断了");
                }
                System.out.println("in " + getName() + " 继续执行");
            }
        }
    }
}