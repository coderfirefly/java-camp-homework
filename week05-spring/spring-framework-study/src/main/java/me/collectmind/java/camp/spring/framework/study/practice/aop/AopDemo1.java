package me.collectmind.java.camp.spring.framework.study.practice.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * AOP 示例1
 * 使用XML配置切面
 *
 * @author monica
 * @date 2020/11/22
 */
public class AopDemo1 {
    /**
     * 切面前置通知
     */
    public void startTransaction() {
        System.out.println("==========> begin ding...");
    }

    /**
     * 切面后置通知
     */
    public void commitTransaction() {
        System.out.println("==========> finish ding...");
    }

    /**
     * 切面环绕通知
     * @param joinPoint
     * @throws Throwable
     */
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("=========>around begin");
        joinPoint.proceed();
        System.out.println("=========>around end");
    }
}
