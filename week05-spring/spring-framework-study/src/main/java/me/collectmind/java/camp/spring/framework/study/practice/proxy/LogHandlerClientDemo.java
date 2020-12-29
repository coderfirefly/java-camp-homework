package me.collectmind.java.camp.spring.framework.study.practice.proxy;

import me.collectmind.java.camp.spring.framework.study.practice.service.UserService;
import me.collectmind.java.camp.spring.framework.study.practice.service.impl.UserServiceImpl;
import me.collectmind.java.camp.spring.framework.study.practice.utils.ProxyUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Jdk 动态代理测试示例
 *
 * @author monica
 * @date 2020/11/29
 */
public class LogHandlerClientDemo {

    public static void main(String[] args) {
        // 创建被代理的对象
        UserServiceImpl userService = new UserServiceImpl();
        // 获取对象的类加载器
        ClassLoader classLoader = userService.getClass().getClassLoader();
        // 获取被代理对象实现的所有接口
        Class[] interfaces = userService.getClass().getInterfaces();
        // 创建代理类，传入代理对象
        InvocationHandler logHandler = new LogHandler(userService);
        // 创建代理对象（生成字节码、生成Class对象、创建代理实例对象）
        UserService proxy = (UserService) Proxy.newProxyInstance(classLoader,interfaces, logHandler);
        proxy.select();
        proxy.update();

        // 生成代理类到本地
        ProxyUtils.generateClassFile(userService.getClass(), "UserServiceProxy");
    }
}
