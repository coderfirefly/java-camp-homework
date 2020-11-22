package me.collectmind.week04concurrent.lock;
/**
 * 多线程可见性问题
 *
 * @author monica
 * @date 2020/11/17
 */
public class Counter3 {
    private byte[] lock1 = new byte[1];
    private byte[] lock2 = new byte[1];
    // 加 volatile 解决可见性问题
    private volatile int num = 0;

    public void add() {
        // 先对lock1 加锁
        synchronized (lock1) {
            try {
                Thread.sleep(1000L);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 释放lock1的锁

        // 对lock2加锁
        synchronized (lock2) {
            System.out.println(Thread.currentThread().getName() + " before add num:" + num);
            num += 1;
        }

        System.out.println(Thread.currentThread().getName() + "_" + num);
    }


    public void lockMethod() {
        synchronized (lock2) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 先对lock2加锁，再对lock1加锁
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName() + " before add num:" + num);
                num += 1;
            }
        }

        System.out.println(Thread.currentThread().getName() + "_" + num);
    }


    /**
     * 可能输出：
     * 线程B before add num:0
     * 线程A before add num:1
     * 线程A_2
     * 线程B_2
     *
     * @param args
     */
    public static void main(String[] args) {
        Counter3 counter3 = new Counter3();
        ThreadA threadA = new ThreadA(counter3);
        threadA.setName("线程A");
        threadA.start();

        ThreadB threadB = new ThreadB(counter3);
        threadB.setName("线程B");
        threadB.start();
    }
}


class ThreadA extends Thread {
    private Counter3 counter3;


    public ThreadA(Counter3 counter3) {
        this.counter3 = counter3;
    }
    @Override
    public void run() {
        counter3.add();
    }
}

class ThreadB extends Thread {
    private Counter3 counter3;

    public ThreadB(Counter3 counter3) {
        this.counter3 = counter3;
    }

    @Override
    public void run() {
        counter3.lockMethod();
    }

}

