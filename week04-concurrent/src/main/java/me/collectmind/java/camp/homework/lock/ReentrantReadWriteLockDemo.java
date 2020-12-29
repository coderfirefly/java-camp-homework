package me.collectmind.java.camp.homework.lock;

/**
 * 测试读写锁
 *  读锁不互斥，写锁互斥
 * @author monica
 * @date 2020/11/17
 */
public class ReentrantReadWriteLockDemo {

    public static void main(String[] args) {
        final ReadWriteCount count = new ReadWriteCount();

        for (int i = 0; i < 5; i++) {
            new Thread(() -> count.get()).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(() -> count.put()).start();
        }
    }
}
