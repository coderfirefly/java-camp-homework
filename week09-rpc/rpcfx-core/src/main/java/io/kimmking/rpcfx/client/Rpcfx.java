package io.kimmking.rpcfx.client;

import com.alibaba.fastjson.parser.ParserConfig;
import io.kimmking.rpcfx.api.Filter;
import io.kimmking.rpcfx.api.LoadBalancer;
import io.kimmking.rpcfx.api.Router;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * RPC框架 客户端代理实现
 *
 * @author monica
 * @date 2020/12/26
 */
public final class Rpcfx {

    static {
        ParserConfig.getGlobalInstance().addAccept("io.kimmking");
    }

    public static <T, filters> T createFromRegistry(final Class<T> serviceClass, final String zkUrl, Router router,
                                                    LoadBalancer loadBalancer, Filter filter) {
        List<String> invokers = new ArrayList<>();
        List<String> urls = router.route(invokers);
        String url = loadBalancer.select(urls);

        return create(serviceClass, url, filter);
    }


    /**
     * 创建一个动态代理实例
     * @param serviceClass
     * @param url
     * @param filters
     * @param <T>
     * @return
     */
    public static <T> T create(final Class<T> serviceClass, final String url, final Filter ... filters) {
        return (T) Proxy.newProxyInstance(Rpcfx.class.getClassLoader(),
                new Class[]{serviceClass}, new RpcfxInvocationHandler(serviceClass, url, filters));
    }



}
