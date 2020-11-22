package me.collectmind.week04concurrent.tools;

import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier
 *
 * @author monica
 * @date 2020/11/17
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> {
            System.out.println("回调>>" + Thread.currentThread().getName());
            System.out.println("回调>>线程组执行结束" + Thread.currentThread().getName());
            System.out.println("==>各个子线程执行结束");
        });

        for (int i = 0; i < 10; i++) {
            new Thread(new ReadNum(i, cyclicBarrier)).start();
        }

        System.out.println("==>主线程执行结束");
    }



    static class ReadNum implements Runnable {
        private int id;
        private CyclicBarrier cyc;

        public ReadNum(int id, CyclicBarrier cyc) {
            this.id = id;
            this.cyc = cyc;
        }

        @Override
        public void run() {
            synchronized (this) {
                System.out.println("id: " + id + "," + Thread.currentThread().getName());
                try {
                    System.out.println("线程组任务" + id + "结束，其他任务继续");
                    // 计数值加1，若不等于指定值（5），线程阻塞等待
                    cyc.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
