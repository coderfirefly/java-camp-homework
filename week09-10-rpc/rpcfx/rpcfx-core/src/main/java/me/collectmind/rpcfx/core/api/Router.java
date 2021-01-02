package me.collectmind.rpcfx.core.api;

import java.util.List;

/**
 * 请求路由接口
 *
 * @author monica
 * @date 2020/12/26
 */
public interface Router {

    /**
     * 请求路由策略
     * @param urls
     * @return
     */
    List<String> route(List<String> urls);
}
