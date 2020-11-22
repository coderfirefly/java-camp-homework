package me.collectmind.week04concurrent.thread;


/**
 * Join 释放锁的例子
 *
 * Created by monica on 2020/11/15.
 */
public class JoinDemo {
    public static void main(String[] args) {
        Object o = new Object();
        MyThread thread = new MyThread("thread1-----");
        thread.setO(o);
        thread.start();

        // 获取锁
        synchronized (thread) {
            for (int i = 0; i < 100; i++) {
                if (i == 20) {
                    try {
                        // 释放锁
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + "---i=" + i);
            }
        }

    }
}

class MyThread extends Thread {
    private String name;
    private Object o;

    public MyThread(String name) {
        this.name = name;
    }

    public Object getO() {
        return o;
    }

    public void setO(Object o) {
        this.o = o;
    }

    @Override
    public void run() {
        // 获取锁
       synchronized (o) {
           for (int i = 0; i < 100; i++) {
               System.out.println(name + i);
           }
       }
    }
}