package io.kimmking.rpcfx.client;

import com.alibaba.fastjson.JSON;
import io.kimmking.rpcfx.api.Filter;
import io.kimmking.rpcfx.domain.RpcfxRequest;
import io.kimmking.rpcfx.domain.RpcfxResponse;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 客户端动态代理实现
 *
 * @author monica
 * @date 2020/12/26
 */
public class RpcfxInvocationHandler implements InvocationHandler {

    /**
     * 代理的接口
     */
    private final Class<?> serviceClass;

    /**
     * 服务端的请求路径
     */
    private final String url;

    /**
     * 自定义请求过滤器
     */
    private final Filter[] filters;


    /**
     *  客户端数据参数
     */
    private static final MediaType JSON_TYPE = MediaType.get("application/json; charset=utf-8");


    public <T> RpcfxInvocationHandler(Class<T> serviceClass, String url, Filter[] filters) {
        this.serviceClass = serviceClass;
        this.url = url;
        this.filters = filters;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // 客户端请求
        RpcfxRequest request = new RpcfxRequest();
        request.setSeviceClass(this.serviceClass.getName());
        request.setMethod(method.getName());
        request.setParams(args);

        // 请求过滤
        if (null != this.filters) {
            for (Filter filter : this.filters) {
                if (!filter.filter(request)) {
                    return null;
                }
            }
        }

        // 请求发送给服务端
        RpcfxResponse response = post(request, url);


        // JSON序列化返回结果
        return JSON.parse(response.getResult().toString());
    }


    /**
     * 执行网络请求
     * @param request
     * @param url
     * @return
     */
    private RpcfxResponse post(RpcfxRequest request, String url) {
        // 请求内容JSON序列化
        String reqJson = JSON.toJSONString(request);
        System.out.println("req json:" + reqJson);

        // 使用 OkHttp发送网络请求到服务提供方
        OkHttpClient client = new OkHttpClient();
        final Request httpRequest = new Request.Builder()
                .url(url)
                .post(RequestBody.create(JSON_TYPE, reqJson))
                .build();
        try {
            String respJson = client.newCall(httpRequest).execute().body().toString();
            System.out.println("resp json:" + respJson);

            // 返回结果反序列化成Java对象
            return JSON.parseObject(respJson, RpcfxResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
