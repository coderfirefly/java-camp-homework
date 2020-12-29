package me.collectmind.java.camp.spring.framework.study.work.thursday.bean;

import me.collectmind.java.camp.spring.framework.study.work.thursday.bean.repository.UserRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 使用自动装配 Bean
 * @author monica
 * @date 2020/11/29
 */
public class SpringAutowiredBeanMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("classpath:/META-INF/spring-work-bean-context-autowire.xml");

        UserRepository userRepository = applicationContext.getBean("userRepository", UserRepository.class);
        System.out.println("userRepository：" + userRepository);
    }
}
