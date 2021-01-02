package me.collectmind.rpcfx.core.client.proxy.impl;

import me.collectmind.rpcfx.core.api.Filter;
import me.collectmind.rpcfx.core.client.http.ClientHttpService;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGLib 动态代理需要实现 MethodInterceptor
 * @author monica
 * @date 2021/1/2
 */
public class ClientMethodInterceptor extends ClientProxyInvokerImpl implements MethodInterceptor {

    public ClientMethodInterceptor(Class<?> serviceClass, String url, Filter[] filters, ClientHttpService clientHttpService) {
        super(serviceClass, url, filters, clientHttpService);
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        return this.invoke(method, objects);
    }
}
