package me.collectmind.java.camp.homework.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by monica on 2020/11/15.
 */
public class ThreadMain {

    public static void main(String[] args) throws Exception {
        ThreadA threadA = new ThreadA();
        threadA.start();
        System.out.println("主线程---1");

        ThreadB threadB = new ThreadB();
        threadB.start();
        System.out.println("主线程---2");

        ThreadC threadC = new ThreadC();
        FutureTask<String> futureTask = new FutureTask<>(threadC);
        new Thread(futureTask).start();
        System.out.println("主线程---3");

        try {
            System.out.println("得到的返回结果是:" + futureTask.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
// 等待线程执行完
//        System.in.read();
    }
}


class ThreadA extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("这是线程A");
    }
}

class ThreadB extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("这是线程B");

        Thread currentThread = Thread.currentThread();
        String currentThreadName = currentThread.getName();
        System.out.println("当前线程名称：" + currentThreadName);
        System.out.println("当前线程：" + currentThreadName + "的线程组中活跃线程的数量：" + currentThread.getThreadGroup().activeCount());
        System.out.println("当前线程：" + currentThreadName + "的标识符：" + currentThread.getId());
        System.out.println("当前线程：" + currentThreadName + "的优先级：" + currentThread.getPriority());
        System.out.println("当前线程：" + currentThreadName + "的状态：" + currentThread.getState());
        System.out.println("当前线程：" + currentThreadName + "所属的线程组：" + currentThread.getThreadGroup());
        System.out.println("当前线程：" + currentThreadName + "是否处于活跃状态：" + currentThread.isAlive());
        System.out.println("当前线程：" + currentThreadName + "是否为守护线程：" + currentThread.isDaemon());
    }
}

class ThreadC implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(500);
        System.out.println("这是线程");
        return "线程C";
    }
}