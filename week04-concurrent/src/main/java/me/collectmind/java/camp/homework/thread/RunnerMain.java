package me.collectmind.java.camp.homework.thread;

/**
 * Created by monica on 2020/11/15.
 */
public class RunnerMain {

    public static void main(String[] args) {
        Runner1 runner1 = new Runner1();
        Thread thread1 = new Thread(runner1);

        Runner2 runner2 = new Runner2();
        Thread thread2 = new Thread(runner2);

        thread1.start();
        thread2.start();

        // 打断线程2状态
        thread2.interrupt();

        System.out.println(Thread.activeCount());

        Thread.currentThread().getThreadGroup().list();
        System.out.println(Thread.currentThread().getThreadGroup().getParent().activeCount());
        Thread.currentThread().getThreadGroup().getParent().list();
    }
}

class Runner1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("进入Runner1运行状态——————————" + i);
        }
    }
}


class Runner2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("进入Runner2运行状态——————————" + i);
        }

        boolean result1 = Thread.currentThread().isInterrupted();
        // 重置线程状态
        boolean result2 = Thread.interrupted();
        boolean result3 = Thread.currentThread().isInterrupted();

        System.out.println("Runner2.run result1 ===>" + result1);
        System.out.println("Runner2.run result2 ===>" + result2);
        System.out.println("Runner2.run result3 ===>" + result3);
    }
}
