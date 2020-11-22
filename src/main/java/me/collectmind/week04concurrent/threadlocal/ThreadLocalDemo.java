package me.collectmind.week04concurrent.threadlocal;

/**
 * ThreadLocal 每个线程维护一份数据
 * 线程执行结束时要清空
 * @author monica
 * @date 2020/11/22
 */
public class ThreadLocalDemo {

    private static ThreadLocal<Integer> seqNum = ThreadLocal.withInitial(() -> 0);

    public ThreadLocal<Integer> getThreadLocal() {
        return seqNum;
    }

    public int getNextNum() {
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }

    static class SnThread extends Thread {
        private ThreadLocalDemo sn;

        public SnThread(ThreadLocalDemo sn) {
            this.sn = sn;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println("thread[" + Thread.currentThread().getName() + "]---> sn [" + sn.getNextNum() + "]");
            }
            sn.getThreadLocal().remove();
        }
    }

    public static void main(String[] args) {
        ThreadLocalDemo threadLocalDemo = new ThreadLocalDemo();

        SnThread client1 = new SnThread(threadLocalDemo);
        SnThread client2 = new SnThread(threadLocalDemo);
        SnThread client3 = new SnThread(threadLocalDemo);

        client1.start();
        client2.start();
        client3.start();

        try {
            client1.join();
            client2.join();
            client3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
