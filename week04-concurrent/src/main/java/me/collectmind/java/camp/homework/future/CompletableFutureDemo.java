package me.collectmind.java.camp.homework.future;

import java.util.concurrent.CompletableFuture;

/**
 * CompletableFuture 的用法
 *
 * @author monica
 * @date 2020/11/17
 */
public class CompletableFutureDemo {

    public static void main(String[] args) {
//        System.out.println("========>1.变换结果");
//        String result1 = CompletableFuture.supplyAsync(() -> "Hello")
//                .thenApplyAsync(v -> v + "world").join();
//        System.out.println(result1);

        CompletableFuture.supplyAsync(() -> "Hello")
                .thenAccept(v -> {System.out.println("====>2.消费"); System.out.println("consumer:" + v);});
    }
}
