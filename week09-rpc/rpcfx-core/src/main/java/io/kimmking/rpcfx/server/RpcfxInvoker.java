package io.kimmking.rpcfx.server;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import io.kimmking.rpcfx.api.RpcfxResolver;
import io.kimmking.rpcfx.domain.RpcfxRequest;
import io.kimmking.rpcfx.domain.RpcfxResponse;

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
        String serviceClass = request.getSeviceClass();

        Object service = resolver.resolve(serviceClass);

        try {
            Method method = resolveMethodFromClass(service.getClass(), request.getMethod());
            Object result = method.invoke(service, request.getParams());

            response.setResult(JSON.toJSONString(request, SerializerFeature.WriteClassName));
            response.setStatus(true);
            return response;

        } catch (IllegalAccessException | InvocationTargetException e) {

            e.printStackTrace();
            response.setException(e);
            response.setStatus(false);
            return response;
        }
    }



    private Method resolveMethodFromClass(Class<?> klass, String methodName) {
        return Arrays.stream(klass.getMethods()).filter(m -> methodName.equals(m.getName())).findFirst().get();
    }
}
