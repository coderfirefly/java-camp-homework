package me.collectmind.java.camp.spring.framework.study.practice.cglib;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * 代理类
 * @author monica
 * @date 2020/11/29
 */
public class LogInterceptor implements MethodInterceptor {

    /**
     *
     * @param o
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        // MethodProxy#invokesuper() 执行的是原始类的方法
        // Method#invoke() 执行的是子类的方法
        Object result = methodProxy.invokeSuper(o, objects);
        after();
        return result;
    }

    private void before() {
        System.out.println(String.format("log start time [%s]", new Date()));
    }

    private void after() {
        System.out.println(String.format("log after time [%s]", new Date()));
    }
}
