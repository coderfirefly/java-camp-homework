package io.kimmking.rpcfx.demo.provider;

import io.kimmking.rpcfx.api.RpcfxResolver;
import io.kimmking.rpcfx.demo.api.service.OrderService;
import io.kimmking.rpcfx.demo.api.service.UserService;
import io.kimmking.rpcfx.demo.provider.service.OrderServiceImpl;
import io.kimmking.rpcfx.demo.provider.service.UserServiceImpl;
import io.kimmking.rpcfx.domain.RpcfxRequest;
import io.kimmking.rpcfx.domain.RpcfxResponse;
import io.kimmking.rpcfx.domain.ServiceProviderDesc;
import io.kimmking.rpcfx.server.RpcfxInvoker;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
/**
 * 服务提供方应用程序示例
 * @author monica
 * @date 2020/12/26
 */
@RestController
@SpringBootApplication
public class RpcfxServerApplication {

    public static void main(String[] args) {
        // 启动zk客户端
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString("localhost:2181")
                .namespace("rpcfx")
                .build();
        client.start();

        // 注册服务
        String userService = "io.kimking.rpcfx.demo.api.UserService";
        registerService(client, userService);

        String orderService = "io.kimking.rpcfx.demo.api.OrderService";
        registerService(client, orderService);

        // 启动应用
        SpringApplication.run(RpcfxServerApplication.class, args);
    }

    private static void registerService(CuratorFramework client, String service) {
        try {
            ServiceProviderDesc serviceProviderDesc = ServiceProviderDesc.builder()
                    .host(InetAddress.getLocalHost().getHostAddress())
                    .port(8080)
                    .serviceClass(service)
                    .build();

            if (null == client.checkExists().forPath("/" + service)) {
                client.create().withMode(CreateMode.PERSISTENT).forPath("/" + service);
            }

            client.create().withMode(CreateMode.EPHEMERAL)
                    .forPath("/" + service + "/" + serviceProviderDesc.getHost() + "_" + serviceProviderDesc.getPort(), "provider".getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Autowired
    private RpcfxInvoker invoker;

    @PostMapping("/")
    public RpcfxResponse invoke(@RequestBody RpcfxRequest request) {
        return invoker.invoke(request);
    }

    @Bean
    public RpcfxInvoker createInvoker(@Autowired RpcfxResolver resolver) {
        return new RpcfxInvoker(resolver);
    }


    @Bean(name = "io.kimmking.rpcfx.demo.api.service.UserService")
    public UserService createUserService() {
        return new UserServiceImpl();
    }

    @Bean(name = "io.kimmking.rpcfx.demo.api.service.OrderService")
    public OrderService createOrderService() {
        return new OrderServiceImpl();
    }
}
