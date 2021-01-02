package me.collectmind.rpcfx.core.client.proxy.impl;

import com.alibaba.fastjson.parser.ParserConfig;
import me.collectmind.rpcfx.core.api.Filter;
import me.collectmind.rpcfx.core.client.http.ClientHttpService;
import me.collectmind.rpcfx.core.client.proxy.ClientProxyStrategy;

import java.lang.reflect.Proxy;

/**
 * 客户端代理实现类，使用jdk动态代理
 *
 * @author monica
 * @date 2020/12/26
 */
public class ClientProxyStrategyJdk implements ClientProxyStrategy {

    static {
        ParserConfig.getGlobalInstance().addAccept("me.collectmind.rpcfx");
    }

    /**
     * 生成接口类的代理
     *
     * @param serviceClass
     * @param url
     * @param filters
     * @param <T>
     * @return
     */
    @Override
    public <T> T create(final Class<T> serviceClass, final String url, ClientHttpService clientHttpService,
                        final Filter... filters) {

        return (T) Proxy.newProxyInstance(ClientProxyStrategyJdk.class.getClassLoader(),
                new Class[]{serviceClass},
                new ClientInvocationHandler(serviceClass, url, filters, clientHttpService));
    }


}
