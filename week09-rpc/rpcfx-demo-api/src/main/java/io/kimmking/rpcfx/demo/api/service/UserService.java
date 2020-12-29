package io.kimmking.rpcfx.demo.api.service;

import io.kimmking.rpcfx.demo.api.domain.User;

/**
 * 用户服务接口
 * @author monica
 * @date 2020/12/26
 */
public interface UserService {

    /**
     * 查找用户
     * @param id
     * @return
     */
    User findUserById(int id);
}
