package me.collectmind.java.camp.spring.framework.study.practice.aop;

import me.collectmind.java.camp.spring.framework.study.practice.domain.Klass;
import me.collectmind.java.camp.spring.framework.study.practice.domain.Student;
import me.collectmind.java.camp.spring.framework.study.practice.service.ISchool;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * {@link org.aspectj.lang.annotation.Aspect} 示例
 *
 * @author monica
 * @date 2020/11/22
 */
public class SpringAopDemo {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/spring-aop-context.xml");

        Student student123 = applicationContext.getBean("student123", Student.class);
        System.out.println("find student123:" + student123);

        Student student100 = applicationContext.getBean("student100", Student.class);
        System.out.println("find student100:" + student100);

        Klass class1 = applicationContext.getBean(Klass.class);
        System.out.println("find class1:" + class1);
        // 非接口默认使用CGLib
        System.out.println("Klass对象AOP代理后的实际类型：" + class1.getClass());
        System.out.println("Klass对象AOP代理后的实际类型是否是Klass子类：" + (class1 instanceof Klass));


        // 接口类型AOP默认使用Proxy
        ISchool school = applicationContext.getBean(ISchool.class);
        System.out.println(school);
        System.out.println("ISchool接口AOP代理后的实际类型" + school.getClass());


        ISchool school1 = applicationContext.getBean(ISchool.class);
        System.out.println(school1);
        System.out.println("ISchool接口AOP代理后的实际类型" + school1.getClass());

        school1.ding();

        class1.dong();

        System.out.println("all beanDefinitions ===>> "+ String.join(",", applicationContext.getBeanDefinitionNames()));

    }
}
