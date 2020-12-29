package me.collectmind.java.camp.homework.thread;

/**
 *
 *
 * @author monica
 * @date 2020/11/15
 */
public class WaitAndNotify {

    public static void main(String[] args) {
        MethodClass methodClass = new MethodClass();
        Thread t1 = new Thread(methodClass::produce, "t1");
        Thread t2 = new Thread(methodClass::consume, "t2");
        Thread t3 = new Thread(methodClass::consume, "t3");
        t1.start();
        t2.start();
        t3.start();
    }
}

class MethodClass {
    private final int MAX_COUNT = 20;
    private int productCount  = 0;

    public synchronized  void produce() {
        try {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " run , productCount:" + productCount);
                Thread.sleep(10);

                if (productCount >= MAX_COUNT) {
                    System.out.println("货舱已满,,.不必再生产");
                    wait();
                } else {
                    productCount++;
                }
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public synchronized void consume() {
        try {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " productCount:" + productCount);
                Thread.sleep(10);
                if (productCount <= 0) {
                    System.out.println("货舱已无货...无法消费");
                    wait();
                } else {
                    productCount--;
                }
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
