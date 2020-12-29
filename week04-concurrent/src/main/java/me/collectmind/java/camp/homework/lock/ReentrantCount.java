package me.collectmind.java.camp.homework.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用可重入锁
 *
 * @author monica
 * @date 2020/11/17
 */
public class ReentrantCount {

    final ReentrantLock lock = new ReentrantLock();

    public void get() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " get begin");
            Thread.sleep(1000L);
            System.out.println(Thread.currentThread().getName() + " get end");
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

     }

     public void put() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " put begin");
            Thread.sleep(1000L);
            System.out.println(Thread.currentThread().getName() + " put end");
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
     }
}
