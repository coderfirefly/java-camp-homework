package io.kimmking.rpcfx.demo.consumer;

import io.kimmking.rpcfx.client.Rpcfx;
import io.kimmking.rpcfx.demo.api.domain.User;
import io.kimmking.rpcfx.demo.api.service.UserService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 客户端服务调用方应用示例
 *
 * @author monica
 * @date 2020/12/26
 */
@SpringBootApplication
public class RpcfxClientApplication {

    public static void main(String[] args) {
        UserService userService = Rpcfx.create(UserService.class, "http://localhost:8080");
        User user = userService.findUserById(1);
        System.out.println("find user id=1 from server:" + user.getName());


    }
}
