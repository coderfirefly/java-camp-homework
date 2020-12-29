package io.kimmking.rpcfx.api;

import java.util.List;

/**
 * 负载均衡接口
 * @author monica
 * @date 2020/12/26
 */
public interface LoadBalancer {

    /**
     * 负载均衡策略
     * @param urls
     * @return
     */
    String select(List<String> urls);
}
