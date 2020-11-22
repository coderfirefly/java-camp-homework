package me.collectmind.week04concurrent.thread;

/**
 * 线程创建示例、守护线程
 * @author monica
 * @date 2020/11/15
 */
public class ThreadCreate {

    public static void main(String[] args) {
        Runnable task = () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread t = Thread.currentThread();
            System.out.println("当前线程：" + t.getName());
        };

        Thread thread = new Thread(task);
        thread.setName("test-thread-1");
//        如果设置成守护线程，线程任务不会被执行
//        thread.setDaemon(true);
        thread.start();
    }
}
