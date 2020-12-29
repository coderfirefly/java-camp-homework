package me.collectmind.java.camp.spring.framework.study.work.thursday.bean;

import me.collectmind.java.camp.spring.framework.study.work.thursday.bean.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 使用注解装配 Bean
 *
 * @author monica
 * @date 2020/11/29
 */
public class SpringAnnotationBeanMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanConfig.class);
        applicationContext.refresh();

        User user = applicationContext.getBean("user", User.class);
        System.out.println("user：" + user);
    }
}


