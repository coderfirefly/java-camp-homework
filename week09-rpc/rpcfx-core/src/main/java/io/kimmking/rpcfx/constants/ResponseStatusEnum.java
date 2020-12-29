package io.kimmking.rpcfx.constants;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 客户端请求结果状态枚举
 * @author monica
 * @date 2020/12/26
 */
@Getter
@AllArgsConstructor
public enum ResponseStatusEnum {
    /**
     * 调用成功
     */
    success("0", "调用成功"),

    /**
     * 调用失败
     */
    failed("1", "调用失败");

    private String code;

    private String desc;


}
