package me.collectmind.java.camp.spring.framework.study.work.thursday.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 基于注解的AOP
 *
 * @author monica
 * @date 2020/11/29
 */
@Aspect
@Component
public class SimpleAop {

    @PostConstruct
    private void init() {
        System.out.println("simple aop init success");
    }

    @Pointcut(value = "execution(* me.collectmind.java.camp.spring..work.thursday.aop.service.*.*(..))")
    public void point() {
    }

    @Before(value = "point()")
    public void before() {
        System.out.println(">>> before called");
    }

    @After(value = "point()")
    public void after() {
        System.out.println(">>> after called");
    }

    @Around(value = "point()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println(">>> in around");
        Object object = joinPoint.proceed();
        System.out.println(">>> out around");
        return object;
    }
}
