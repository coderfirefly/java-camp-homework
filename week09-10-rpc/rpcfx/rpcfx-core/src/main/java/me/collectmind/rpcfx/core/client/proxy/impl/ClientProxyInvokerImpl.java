package me.collectmind.rpcfx.core.client.proxy.impl;

import com.alibaba.fastjson.JSON;
import me.collectmind.rpcfx.core.api.Filter;
import me.collectmind.rpcfx.core.client.http.ClientHttpService;
import me.collectmind.rpcfx.core.client.proxy.ClientProxyInvoker;
import me.collectmind.rpcfx.core.domain.RpcfxRequest;
import me.collectmind.rpcfx.core.domain.RpcfxResponse;

import java.lang.reflect.Method;

/**
 * 客户端代理方法调用实现类
 * 用于代理策略实现类继承公共功能
 *
 * @author monica
 * @date 2021/1/2
 */
public class ClientProxyInvokerImpl implements ClientProxyInvoker {
    /**
     * 代理的接口
     */
    private final Class<?> serviceClass;

    /**
     * 服务端的请求路径
     */
    private final String url;

    /**
     * 请求过滤器
     */
    private final Filter[] filters;

    /**
     * 网络请求实现
     */
    private ClientHttpService clientHttpService;

    public ClientProxyInvokerImpl(Class<?> serviceClass, String url, Filter[] filters, ClientHttpService clientHttpService) {
        this.serviceClass = serviceClass;
        this.url = url;
        this.filters = filters;
        this.clientHttpService = clientHttpService;
    }

    @Override
    public Object invoke(Method method, Object[] args) {
        // 客户端请求
        RpcfxRequest rpcfxRequest = new RpcfxRequest();
        rpcfxRequest.setServiceClass(this.serviceClass.getName());
        rpcfxRequest.setMethod(method.getName());
        rpcfxRequest.setParams(args);

        // 请求过滤
        if (null != this.filters) {
            for (Filter filter : this.filters) {
                if (!filter.filter(rpcfxRequest)) {
                    return null;
                }
            }
        }

        // 请求发送给服务端
        RpcfxResponse response = this.clientHttpService.post(rpcfxRequest, this.url);
        if (null == response) {
            return null;
        }

        // JSON序列化返回结果
        return JSON.parse(response.getResult().toString());
    }

}
