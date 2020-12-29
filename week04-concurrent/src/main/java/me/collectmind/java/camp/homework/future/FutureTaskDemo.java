package me.collectmind.java.camp.homework.future;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * FutureTask 获取线程执行结果
 *
 * @author monica
 * @date 2020/11/17
 */
public class FutureTaskDemo {

    public static void main(String[] args) {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(1000L);
                return new Random().nextInt();
            }
        });
        new Thread(futureTask).start();
        try {
            System.out.println("result:" + futureTask.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Main Thread End.");
    }
}
