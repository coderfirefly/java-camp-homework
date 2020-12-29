package me.collectmind.java.camp.spring.framework.study.work.thursday.aop;

import me.collectmind.java.camp.spring.framework.study.work.thursday.aop.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 基于Jdk动态代理实现的简单的AOP
 *
 * @author monica
 * @date 2020/11/29
 */
public class SimpleAopMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("classpath:/META-INF/spring-work-aop-context.xml");
        StudentService studentService = applicationContext.getBean("studentService", StudentService.class);
        studentService.submitHomework();
    }
}