package me.collectmind.rpcfx.demo.provider.service;

import me.collectmind.rpcfx.demo.api.domain.User;
import me.collectmind.rpcfx.demo.api.service.UserService;

/**
 * 服务实现类示例
 * @author monica
 * @date 2020/12/26
 */
public class UserServiceImpl implements UserService {

    @Override
    public User findUserById(int id) {
        return new User(id, "UserServiceImpl_" + System.currentTimeMillis());
    }

}
