package me.collectmind.rpcfx.core.client.http;

import me.collectmind.rpcfx.core.domain.RpcfxRequest;
import me.collectmind.rpcfx.core.domain.RpcfxResponse;

/**
 * 网络通信
 * @author monica
 * @date 2021/1/2
 */
public interface ClientHttpService {
    /**
     * 发送请求
     * @param rpcfxRequest
     * @param url
     * @return
     */
    RpcfxResponse post(RpcfxRequest rpcfxRequest, String url);
}
