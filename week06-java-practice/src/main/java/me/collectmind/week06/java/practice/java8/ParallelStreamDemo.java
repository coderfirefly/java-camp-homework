package me.collectmind.week06.java.practice.java8;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 比较串行stream和并行stream的性能
 *
 * @author monica
 * @date 2020/12/19
 */
public class ParallelStreamDemo {

    public static void main(String[] args) {
        testSerialize();
        testParallel();
    }

    private static void testSerialize() {
        int length = 5000000;
        ArrayList<Object> list =  new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            list.add(UUID.randomUUID().toString());
        }

        System.out.println("start sort");
        long startTime = System.nanoTime();

        list.stream().sorted().count();

        long endTime = System.nanoTime();
        System.out.println("parallel cost time:" + TimeUnit.NANOSECONDS.toMillis(endTime - startTime));
    }

    private static void testParallel() {
        int length = 5000000;
        ArrayList<Object> list =  new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            list.add(UUID.randomUUID().toString());
        }

        System.out.println("start sort");
        long startTime = System.nanoTime();

        list.parallelStream().sorted().count();

        long endTime = System.nanoTime();
        System.out.println("parallel cost time:" + TimeUnit.NANOSECONDS.toMillis(endTime - startTime));

    }
}
