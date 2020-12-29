package me.collectmind.java.camp.spring.framework.study.practice.cglib;

import org.springframework.cglib.proxy.Enhancer;

/**
 * CGLib 测试类
 * @author monica
 * @date 2020/11/29
 */
public class CGLibTest {

    public static void main(String[] args) {
        LogInterceptor  logInterceptor = new LogInterceptor();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserDao.class);
        enhancer.setCallback(logInterceptor);

        UserDao userDao = (UserDao) enhancer.create();
        userDao.update();
        userDao.select();
    }
}
