package me.collectmind.rpcfx.core.domain;

import lombok.Data;

/**
 * 客户端请求返回结果实体
 *
 * @author monica
 * @date 2020/12/26
 */
@Data
public class RpcfxResponse {
    /**
     * 客户端请求的返回结果
     */
    private Object result;

    /**
     * 客户端请求的状态
     */
    private boolean status;

    /**
     * 客户端请求返回的异常
     */
    private Exception exception;
}
