package me.collectmind.java.camp.homework.example;

/**
 * Netty 课程示例
 *
 * Created by monica on 2020/11/7.
 */
public class NettyServerApplication {

    public static void main(String[] args) {
        HttpServer httpServer = new HttpServer(false, 8808);
        try {
            httpServer.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
