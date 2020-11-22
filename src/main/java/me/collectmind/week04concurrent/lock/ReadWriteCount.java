package me.collectmind.week04concurrent.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by monica on 2020/11/17.
 */
public class ReadWriteCount {

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();


    public void get() {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " get begin");
            Thread.sleep(10000);
            System.out.println(Thread.currentThread().getName() + " get end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }


    public void put() {
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " put begin");
            Thread.sleep(10000);
            System.out.println(Thread.currentThread().getName() + " put end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }
}
