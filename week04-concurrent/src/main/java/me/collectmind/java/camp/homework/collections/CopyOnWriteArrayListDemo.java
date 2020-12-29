package me.collectmind.java.camp.homework.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * List的线程安全Demo
 *
 * @author monica
 * @date 2020/11/21
 */
public class CopyOnWriteArrayListDemo {

    public static void main(String[] args) {
        /**
         * 只有CopyOnWriteArrayList才不会报异常
         * ConcurrentModificationException
         */
//        List<Integer> list = new Vector<>();
//        List<Integer> list = new ArrayList<>();
//        List<Integer> list = new LinkedList<>();
        List<Integer> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }

        T1  t1 = new T1(list);
        T2  t2 = new T2(list);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }


    static class T1 extends Thread {
        private List<Integer> list;

        public T1(List<Integer> list) {
            this.list = list;
        }

        @Override
        public void run() {
            for (Integer i : list) {

            }
        }
    }


    static class T2 extends Thread {
        private List<Integer> list;

        public T2(List<Integer> list) {
            this.list = list;
        }

        @Override
        public void run() {
            for (int i = 0; i < list.size(); i++) {
                list.remove(i);
            }
        }
    }
}
