package me.collectmind.rpcfx.core.server;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import me.collectmind.rpcfx.core.api.RpcfxResolver;
import me.collectmind.rpcfx.core.domain.RpcfxRequest;
import me.collectmind.rpcfx.core.domain.RpcfxResponse;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 服务端查找实现类
 *
 * @author monica
 * @date 2020/12/26
 */
public class RpcfxInvoker {

    /**
     * 服务实现类解析策略
     */
    private RpcfxResolver resolver;

    public RpcfxInvoker(RpcfxResolver resolver) {
        this.resolver = resolver;
    }

    public RpcfxResponse invoke(RpcfxRequest request) {
        RpcfxResponse response = new RpcfxResponse();
        String serviceClass = request.getServiceClass();

        // 解析出请求的实现类
        Object service = resolver.resolve(serviceClass);

        try {
            // 反射调用方法
            Method method = resolveMethodFromClass(service.getClass(), request.getMethod());
            Object result = method.invoke(service, request.getParams());

            response.setResult(JSON.toJSONString(result, SerializerFeature.WriteClassName));
            response.setStatus(true);
            return response;
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            response.setException(e);
            response.setStatus(false);
            return response;
        }
    }

    /**
     * 根据方法名查找匹配的方法
     *
     * @param klass
     * @param methodName
     * @return
     */
    private Method resolveMethodFromClass(Class<?> klass, String methodName) {
        return Arrays.stream(klass.getMethods()).filter(m -> methodName.equals(m.getName())).findFirst().get();
    }

}
