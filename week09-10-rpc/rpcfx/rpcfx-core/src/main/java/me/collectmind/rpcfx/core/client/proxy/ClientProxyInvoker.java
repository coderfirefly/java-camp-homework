package me.collectmind.rpcfx.core.client.proxy;

import java.lang.reflect.Method;

/**
 * 客户端代理实现接口
 * @author monica
 * @date 2021/1/2
 */
public interface ClientProxyInvoker {

    /**
     * 代理类执行方法调用
     * @param method
     * @param args
     * @return
     */
    Object invoke(Method method, Object[] args);
}
