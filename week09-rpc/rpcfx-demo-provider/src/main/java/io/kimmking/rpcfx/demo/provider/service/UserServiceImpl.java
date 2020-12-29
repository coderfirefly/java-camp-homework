package io.kimmking.rpcfx.demo.provider.service;

import io.kimmking.rpcfx.demo.api.domain.User;
import io.kimmking.rpcfx.demo.api.service.UserService;

/**
 *
 * @author monica
 * @date 2020/12/26
 */
public class UserServiceImpl implements UserService {

    @Override
    public User findUserById(int id) {
        return new User(id, "KK" + System.currentTimeMillis());
    }

}
