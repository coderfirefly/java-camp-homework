package me.collectmind.java.camp.spring.framework.study.work.thursday.bean;

import me.collectmind.java.camp.spring.framework.study.work.thursday.bean.domain.User;
import org.springframework.context.annotation.Bean;

/**
 * 基于注解的配置类
 *
 * @author monica
 * @date 2020/11/29
 */
public class BeanConfig {

    @Bean(name = "user")
    public User user() {
        User user = new User();
        user.setAge(18);
        user.setName("monica");
        return user;
    }
}
