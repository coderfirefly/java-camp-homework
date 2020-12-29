package me.collectmind.java.camp.spring.framework.study.practice.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 使用注解的方式定义切面 示例
 *
 * @author monica
 * @date 2020/11/28
 */
@Aspect
public class AopDemo2 {

    @Pointcut(value = "execution(* me.collectmind.java.camp.spring.framework.study.practice.domain.Klass.dong(..))")
    public void point() {
    }


    @Before(value = "point()")
    public void before() {
        System.out.println("=========> begin klass dong...");
    }

    @Before(value = "point()")
    public void after() {
        System.out.println("=========> after klass dong...");
    }

    @Around("point()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around begin klass dong");
        joinPoint.proceed();
        System.out.println("around after klass dong");
    }
}
