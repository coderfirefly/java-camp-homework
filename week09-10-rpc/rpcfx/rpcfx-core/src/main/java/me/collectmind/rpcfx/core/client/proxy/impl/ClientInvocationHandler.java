package me.collectmind.rpcfx.core.client.proxy.impl;

import me.collectmind.rpcfx.core.api.Filter;
import me.collectmind.rpcfx.core.client.http.ClientHttpService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * JdkProxy 动态代理需要实现 InvocationHandler
 *
 * @author monica
 * @date 2020/12/26
 */
public class ClientInvocationHandler extends ClientProxyInvokerImpl implements InvocationHandler {

    public ClientInvocationHandler(Class<?> serviceClass, String url, Filter[] filters, ClientHttpService clientHttpService) {
        super(serviceClass, url, filters, clientHttpService);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return this.invoke(method, args);
    }
}
