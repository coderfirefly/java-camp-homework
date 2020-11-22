package me.collectmind.week04concurrent.work;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 有多少种方式，在main函数启动一个新线程或线程池，
 * 异步运行一个方法，拿到这个方法的返回值后，退出主线程？
 *
 * @author monica
 * @date 2020/11/17
 */
public class HomeWork {

    public static void main(String[] args) {
//        method1();
//        method2();
//        method3();
//        method4();
//        method5();
//        method6();
//        method7();
//        method8();
        method9();

    }

    /**
     * 方法1：线程池+Future
     */
    public static void method1() {
        long start = System.currentTimeMillis();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try {
            int result = executorService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    return sum();
                }
            }).get();
            System.out.println("异步计算结果为：" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        executorService.shutdown();
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * 方法2：Thread + FutureTask
     */
    public static void method2() {
        long start = System.currentTimeMillis();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return sum();
            }
        });

        Thread thread = new Thread(futureTask);
        thread.start();

        try {
            System.out.println("异步计算结果为：" + futureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * 方法3：线程池 + FutureTask
     */
    public static void method3() {
        long start = System.currentTimeMillis();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return sum();
            }
        });

        executorService.submit(futureTask);

        try {
            System.out.println("异步计算结果为：" + futureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        executorService.shutdown();
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * 方法4：CompleteFuture
     */
    public static void method4() {
        long start = System.currentTimeMillis();
        int result = CompletableFuture.supplyAsync(HomeWork::sum).join();
        System.out.println("异步计算结果为：" + result);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * 方法5：synchronized + wait + notifyAll
     */
    public static void method5() {
        long start = System.currentTimeMillis();
        SynchronizedFibo fibo = new SynchronizedFibo();
        Thread thread = new Thread(() -> fibo.sum());
        thread.start();
        int result = fibo.getValue();
        System.out.println("异步计算结果为：" + result);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * 方法6：Lock + Condition
     */
    public static void method6() {
        long start = System.currentTimeMillis();

        LockFibo fibo = new LockFibo();
        Thread thread = new Thread(() -> fibo.sum());
        thread.start();
        int result = fibo.getValue();

        System.out.println("异步计算结果为：" + result);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
    }


    /**
     * 方法7：Semaphore
     */
    public static void method7() {
        long start = System.currentTimeMillis();

        SemaphoreFibo fibo = new SemaphoreFibo();
        Thread thread = new Thread(() -> fibo.sum());
        thread.start();
        int result = fibo.getValue();

        System.out.println("异步计算结果为：" + result);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * 方法8：CountDownLatch
     */
    public static void method8() {
        long start = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        CountDownLatchFibo fibo = new CountDownLatchFibo(countDownLatch);
        Thread thread = new Thread(() -> fibo.sum());
        thread.start();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int result = fibo.getValue();
        System.out.println("异步计算结果为：" + result);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * 方法9：CyclicBarrier
     */
    public static void method9() {
        long start = System.currentTimeMillis();

        CyclicBarrierFibo cyclicBarrierFibo = new CyclicBarrierFibo();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(1, () -> {
            System.out.println("异步计算结果为：" + cyclicBarrierFibo.getValue());
        });
        cyclicBarrierFibo.setCyclicBarrier(cyclicBarrier);

        Thread thread = new Thread(() -> cyclicBarrierFibo.sum());
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
    }

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if (a < 2) {
            return 1;
        }
        return fibo(a - 1) + fibo(a - 2);
    }
}

class SynchronizedFibo {
    private int value;

    public synchronized void sum() {
        this.value = fibo(36);
        notifyAll();
    }

    private static int fibo(int a) {
        if (a < 2) {
            return 1;
        }
        return fibo(a - 1) + fibo(a - 2);
    }

    public synchronized int getValue() {
        try {
            while (value == 0) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return this.value;
    }
}

class LockFibo {
    private int value;
    private ReentrantLock lock = new ReentrantLock();
    private Condition sumDone = lock.newCondition();

    public void sum() {
        lock.lock();
        try {
            this.value = fibo(36);
            sumDone.signal();
        } finally {
            lock.unlock();
        }
    }

    private static int fibo(int a) {
        if (a < 2) {
            return 1;
        }
        return fibo(a - 1) + fibo(a - 2);
    }

    public int getValue() {
        lock.lock();
        try {
            while (value == 0) {
                sumDone.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return this.value;
    }
}


class SemaphoreFibo {
    private int value;
    private Semaphore sumDone = new Semaphore(0);

    public void sum() {
        this.value = fibo(36);
        sumDone.release();
    }

    private static int fibo(int a) {
        if (a < 2) {
            return 1;
        }
        return fibo(a - 1) + fibo(a - 2);
    }

    public int getValue() {
        try {
            sumDone.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.value;
    }
}

class CountDownLatchFibo {
    private int value;
    private CountDownLatch countDownLatch;

    public CountDownLatchFibo(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public void sum() {
        this.value = fibo(36);
        countDownLatch.countDown();
    }

    private static int fibo(int a) {
        if (a < 2) {
            return 1;
        }
        return fibo(a - 1) + fibo(a - 2);
    }

    public int getValue() {
        return this.value;
    }
}


class CyclicBarrierFibo {
    private int value;
    private CyclicBarrier cyclicBarrier;

    public void setCyclicBarrier(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    public void sum() {
        this.value = fibo(36);
        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    private static int fibo(int a) {
        if (a < 2) {
            return 1;
        }
        return fibo(a - 1) + fibo(a - 2);
    }

    public int getValue() {
        return this.value;
    }
}