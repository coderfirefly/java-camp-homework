package me.collectmind.rpcfx.core.client;

import me.collectmind.rpcfx.core.api.Filter;
import me.collectmind.rpcfx.core.client.http.ClientHttpService;
import me.collectmind.rpcfx.core.client.proxy.ClientProxyStrategy;

/**
 * 实现客户端请求代理
 *
 * @author monica
 * @date 2021/1/2
 */
public class RpcfxClientInvoker {

    public static  <T> T create(final Class<T> serviceClass, final String url, ClientHttpService clientHttpService,
                                ClientProxyStrategy clientProxyStrategy, final Filter... filters) {
        return clientProxyStrategy.create(serviceClass, url, clientHttpService, filters);
    }

}
