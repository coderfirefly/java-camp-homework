package me.collectmind.rpcfx.core.api;

/**
 * 服务端实现类解析
 *
 * @author monica
 * @date 2020/12/26
 */
public interface RpcfxResolver {

    /**
     * 实现类解析策略
     * @param serviceClass
     * @return
     */
    Object resolve(String serviceClass);
}
