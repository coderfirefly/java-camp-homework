package me.collectmind.java.camp.spring.framework.study.practice.cglib;

/**
 * 普通类，用于测试CGLib动态代理
 *
 * @author monica
 * @date 2020/11/29
 */
public class UserDao {

    public void select() {
        System.out.println("UserDao 查询 selectById");
    }

    public void update() {
        System.out.println("UserDao 更新 update");
    }
}

