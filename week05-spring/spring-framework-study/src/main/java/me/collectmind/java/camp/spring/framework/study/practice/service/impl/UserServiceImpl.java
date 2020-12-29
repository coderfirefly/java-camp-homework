package me.collectmind.java.camp.spring.framework.study.practice.service.impl;

import me.collectmind.java.camp.spring.framework.study.practice.service.UserService;

/**
 * 动态代理测试接口实现
 *
 * @author monica
 * @date 2020/11/29
 */
public class UserServiceImpl implements UserService {
    @Override
    public void select() {
        System.out.println("查询 selectById");
    }

    @Override
    public void update() {
        System.out.println("更新 update");
    }
}
