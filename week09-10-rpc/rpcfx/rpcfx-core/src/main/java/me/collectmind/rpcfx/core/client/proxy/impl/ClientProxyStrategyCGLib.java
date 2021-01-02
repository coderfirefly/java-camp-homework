package me.collectmind.rpcfx.core.client.proxy.impl;

import com.alibaba.fastjson.parser.ParserConfig;
import me.collectmind.rpcfx.core.api.Filter;
import me.collectmind.rpcfx.core.client.http.ClientHttpService;
import me.collectmind.rpcfx.core.client.proxy.ClientProxyStrategy;
import org.springframework.cglib.proxy.Enhancer;

/**
 * 客户端代理实现类，使用CGLib动态代理实现
 *
 * @author monica
 * @date 2021/1/2
 */
public class ClientProxyStrategyCGLib implements ClientProxyStrategy {
    static {
        ParserConfig.getGlobalInstance().addAccept("me.collectmind.rpcfx");
    }

    @Override
    public <T> T create(Class<T> serviceClass, String url, ClientHttpService clientHttpService, Filter... filters) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(serviceClass);
        enhancer.setCallback(new ClientMethodInterceptor(serviceClass, url, filters, clientHttpService));
        return (T) enhancer.create();
    }
}
