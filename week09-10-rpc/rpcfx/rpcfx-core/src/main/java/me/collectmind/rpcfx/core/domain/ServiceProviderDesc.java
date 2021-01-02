package me.collectmind.rpcfx.core.domain;

import lombok.Builder;
import lombok.Data;

/**
 * 服务提供方实体
 * @author monica
 * @date 2020/12/26
 */
@Data
@Builder
public class ServiceProviderDesc {

    /**
     * 服务提供方IP
     */
    private String host;

    /**
     * 服务提供方端口
     */
    private Integer port;

    /**
     * 服务提供方实现类名称
     */
    private String serviceClass;
}
