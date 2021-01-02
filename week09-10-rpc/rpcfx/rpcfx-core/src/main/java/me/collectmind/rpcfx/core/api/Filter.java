package me.collectmind.rpcfx.core.api;

import me.collectmind.rpcfx.core.domain.RpcfxRequest;

/**
 * 请求过滤
 *
 * @author monica
 * @date 2020/12/26
 */
public interface Filter {

    /**
     * 请求过滤策略
     * @param request
     * @return
     */
    boolean filter(RpcfxRequest request);
}
