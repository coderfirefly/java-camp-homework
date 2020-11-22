package me.collectmind.week04concurrent.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 并行Stream
 * @author monica
 * @date 2020/11/22
 */
public class StreamParallelDemo {

    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        List<Integer> list = new ArrayList<>();
        IntStream.range(1, 10000).forEach(list::add);

        BlockingQueue<Long> blockingQueue = new LinkedBlockingDeque<>(10000);
        List<Long> longList = list.stream().parallel()
                .map(Integer::longValue)
                .sorted()
                .collect(Collectors.toList());

        // 串行
//      longList.stream().forEach(
        // 并行，默认cpu核数 * 2
        longList.stream().parallel().forEach(
                i -> {
                    try {
                        blockingQueue.put(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );

        System.out.println("cost: " + (System.currentTimeMillis() - begin) + ", blockingQueue:" + blockingQueue);
    }

}
