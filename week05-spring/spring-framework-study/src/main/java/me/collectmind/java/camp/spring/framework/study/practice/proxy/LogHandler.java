package me.collectmind.java.camp.spring.framework.study.practice.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * Jdk动态代理示例
 *
 * @author monica
 * @date 2020/11/29
 */
public class LogHandler implements InvocationHandler {
    /**
     * 被代理的对象
     */
    Object target;

    public LogHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target, args);
        after();
        return result;
    }

    private void before() {
        System.out.println(String.format("log start time [%s]", new Date()));
    }

    private void after() {
        System.out.println(String.format("log end time [%s]", new Date()));
    }
}
