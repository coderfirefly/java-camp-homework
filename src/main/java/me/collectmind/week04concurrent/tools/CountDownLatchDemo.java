package me.collectmind.week04concurrent.tools;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch
 * 主线程等待所有worker线程把任务执行完
 *
 * @author monica
 * @date 2020/11/17
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 6; i++) {
            new Thread(new ReadNum(i, countDownLatch)).start();
        }

        // 等待CountDownLatch数量归零
        countDownLatch.await();
        System.out.println("==> 各个子线程结束执行");
        System.out.println("==> 主线程结束执行");

    }


    static class ReadNum implements Runnable {
        private int id;
        private CountDownLatch latch;

        public ReadNum(int id, CountDownLatch latch) {
            this.id = id;
            this.latch = latch;
        }

        @Override
        public void run() {
            synchronized (this) {
                System.out.println("id: " + id + ", " + Thread.currentThread().getName());
                System.out.println("线程组任务" + id + "结束，其他任务继续");
                latch.countDown();
            }
        }
    }
}

