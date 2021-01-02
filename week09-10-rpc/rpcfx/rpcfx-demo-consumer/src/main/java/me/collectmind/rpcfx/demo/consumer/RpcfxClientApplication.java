package me.collectmind.rpcfx.demo.consumer;

import me.collectmind.rpcfx.core.client.RpcfxClientInvoker;
import me.collectmind.rpcfx.core.client.http.impl.ClientHttpServiceOkHttpImpl;
import me.collectmind.rpcfx.core.client.proxy.impl.ClientProxyStrategyCGLib;
import me.collectmind.rpcfx.demo.api.domain.User;
import me.collectmind.rpcfx.demo.api.service.UserService;
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
        UserService userService = RpcfxClientInvoker.create(UserService.class, "http://localhost:8080",
                new ClientHttpServiceOkHttpImpl(), new ClientProxyStrategyCGLib());
        User user = userService.findUserById(1);
        System.out.println("find user id=1 from server:" + user.getName());
    }

}
