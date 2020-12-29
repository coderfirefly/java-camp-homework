package me.collectmind.java.camp.homework.threadsafe;

/**
 * 多线程修改sum会出现并发问题
 *
 * @author monica
 * @date 2020/11/15
 */
public class Counter {

    private int sum = 0;

    // 这里不加Synchronized就会出现多线程并发问题
    public synchronized void incr() {
        sum = sum + 1;
    }

    public int getSum() {
        return sum;
    }

    public static void main(String[] args) throws Exception {
        int loop = 100000;

        Counter counter = new Counter();
        for (int i = 0; i < loop; i++) {
            counter.incr();
        }
        System.out.println("single thread counter:" + counter.getSum());


        final Counter counter2 = new Counter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < loop / 2; i++) {
                counter2.incr();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < loop / 2; i++) {
                counter2.incr();
            }
        });
        t1.start();
        t2.start();
        Thread.sleep(1000);

        System.out.println("multi-thread counter:" + counter2.getSum());
    }
}
