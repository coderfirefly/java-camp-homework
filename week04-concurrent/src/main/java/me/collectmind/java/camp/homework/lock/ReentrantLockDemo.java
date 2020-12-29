package me.collectmind.java.camp.homework.lock;

/**
 * 可重入锁测试
 *
 * @author monica
 * @date 2020/11/17
 */
public class ReentrantLockDemo {

    public static void main(String[] args) {
        final ReentrantCount count = new ReentrantCount();

        for (int i = 0; i < 2; i++) {
            new Thread(() -> count.get()).start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(() -> count.put()).start();
        }
    }
}
