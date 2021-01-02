package me.collectmind.rpcfx.core.client.http.impl;

import com.alibaba.fastjson.JSON;
import me.collectmind.rpcfx.core.client.http.ClientHttpService;
import me.collectmind.rpcfx.core.domain.RpcfxRequest;
import me.collectmind.rpcfx.core.domain.RpcfxResponse;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import java.io.IOException;

/**
 * 使用OkHttp客户端发送请求
 *
 * @author monica
 * @date 2021/1/2
 */
public class ClientHttpServiceOkHttpImpl implements ClientHttpService {

    /**
     *  客户端数据参数
     */
    private static final MediaType JSON_TYPE = MediaType.get("application/json; charset=utf-8");

    @Override
    public RpcfxResponse post(RpcfxRequest rpcfxRequest, String url) {
        return doPost(rpcfxRequest, url);
    }

    /**
     * 执行网络请求
     * @param rpcfxRequest
     * @param url
     * @returnP
     */
    private RpcfxResponse doPost(RpcfxRequest rpcfxRequest, String url) {
        // 请求内容JSON序列化
        String reqJson = JSON.toJSONString(rpcfxRequest);
        System.out.println("req json:" + reqJson);

        // 使用 OkHttp发送网络请求到服务提供方
        OkHttpClient client = new OkHttpClient();
        final Request httpRequest = new Request.Builder()
                .url(url)
                .post(RequestBody.create(JSON_TYPE, reqJson))
                .build();
        try {
            ResponseBody responseBody =  client.newCall(httpRequest).execute().body();
            if (null == responseBody) {
                return null;
            }

            String respJson = responseBody.string();
            System.out.println("resp json:" + respJson);

            // 返回结果反序列化成Java对象
            return JSON.parseObject(respJson, RpcfxResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
