package me.collectmind.java.camp.spring.framework.study.work.thursday.bean;

import me.collectmind.java.camp.spring.framework.study.work.thursday.bean.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 使用 Xml 装配 Bean
 * @author monica
 * @date 2020/11/29
 */
public class SpringXmlBeanMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/spring-work-bean-context.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println("user：" + user);
    }
}
