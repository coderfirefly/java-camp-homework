package me.collectmind.java.camp.homework.lock;

import java.util.concurrent.locks.LockSupport;

/**
 *
 * @author monica
 * @date 2020/11/17
 */
public class LockSupportDemo2 {

    public static void main(String[] args) {
        Thread parkThread = new Thread(new ParkThread());
        parkThread.start();
        System.out.println("开始线程唤醒");
        LockSupport.unpark(parkThread);
        System.out.println("结束线程唤醒");

    }

    static class ParkThread implements Runnable{

        @Override
        public void run() {
            System.out.println("==开始线程阻塞");
            LockSupport.park();
            System.out.println("==结束线程阻塞");
        }
    }
}
