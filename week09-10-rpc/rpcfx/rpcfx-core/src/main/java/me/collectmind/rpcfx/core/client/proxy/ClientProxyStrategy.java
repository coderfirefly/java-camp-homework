package me.collectmind.rpcfx.core.client.proxy;

import me.collectmind.rpcfx.core.api.Filter;
import me.collectmind.rpcfx.core.client.http.ClientHttpService;

/**
 * 代理类接口
 * @author monica
 * @date 2021/1/2
 */
public interface ClientProxyStrategy {

    /**
     * 生成服务的代理类
     * @param serviceClass
     * @param url
     * @param clientHttpService
     * @param filters
     * @param <T>
     * @return
     */
    <T> T create(Class<T> serviceClass, String url, ClientHttpService clientHttpService, Filter... filters);
}
