package me.collectmind.java.camp.spring.framework.study.work.thursday.bean.repository;

import lombok.ToString;
import me.collectmind.java.camp.spring.framework.study.work.thursday.bean.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 *  用户仓库
 *  用于测试自动装配
 * @author monica
 * @date 2020/11/29
 */
@Component
@ToString(callSuper = true)
public class UserRepository {

    private final User user;

    @Autowired
    public UserRepository(User user) {
        this.user = user;
    }
}
