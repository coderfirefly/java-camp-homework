package me.collectmind.rpcfx.core.domain;

import lombok.Data;

/**
 * 客户端请求实体
 *
 * @author monica
 * @date 2020/12/26
 */
@Data
public class RpcfxRequest {

    /**
     * 要调用的远程的服务接口名
     */
    private String serviceClass;

    /**
     * 要调用的方法
     */
    private String method;

    /**
     * 方法参数
     */
    private Object[] params;
}
