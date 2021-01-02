package me.collectmind.rpcfx.demo.provider;

import me.collectmind.rpcfx.core.api.RpcfxResolver;
import me.collectmind.rpcfx.demo.api.service.OrderService;
import me.collectmind.rpcfx.demo.api.service.UserService;
import me.collectmind.rpcfx.demo.provider.service.OrderServiceImpl;
import me.collectmind.rpcfx.demo.provider.service.UserServiceImpl;
import me.collectmind.rpcfx.core.domain.RpcfxRequest;
import me.collectmind.rpcfx.core.domain.RpcfxResponse;
import me.collectmind.rpcfx.core.server.RpcfxInvoker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务提供方应用程序示例
 *
 * @author monica
 * @date 2020/12/26
 */
@RestController
@SpringBootApplication
public class RpcfxServerApplication {

    @Autowired
    private RpcfxInvoker invoker;

    public static void main(String[] args) {
        SpringApplication.run(RpcfxServerApplication.class, args);
    }

    @PostMapping("/")
    public RpcfxResponse invoke(@RequestBody RpcfxRequest request) {
        return invoker.invoke(request);
    }

    @Bean
    public RpcfxInvoker createInvoker(@Autowired RpcfxResolver resolver) {
        return new RpcfxInvoker(resolver);
    }

    @Bean
    public RpcfxResolver createResolver() {
        return new DemoResolver();
    }

    @Bean(name = "me.collectmind.rpcfx.demo.api.service.UserService")
    public UserService createUserService() {
        return new UserServiceImpl();
    }

    @Bean(name = "me.collectmind.rpcfx.demo.api.service.OrderService")
    public OrderService createOrderService() {
        return new OrderServiceImpl();
    }
}
