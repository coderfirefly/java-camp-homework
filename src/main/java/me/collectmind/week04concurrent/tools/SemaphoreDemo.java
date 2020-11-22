package me.collectmind.week04concurrent.tools;

import java.util.concurrent.Semaphore;

/**
 * 信号量
 *
 * @author monica
 * @date 2020/11/17
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        //  工人数
        int N = 8;
        // 机器数目，如果信号量为1，多线程就变成串行
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < N; i++) {
            new Worker(i, semaphore).start();
        }
    }

}

class Worker extends Thread {
    private int num;
    private Semaphore semaphore;

    public Worker(int num, Semaphore semaphore) {
        this.num = num;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println("工人 " + this.num + "占用一个机器在生产...");
            Thread.sleep(2000);
            System.out.println("工人 " + this.num + "释放出机器...");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

