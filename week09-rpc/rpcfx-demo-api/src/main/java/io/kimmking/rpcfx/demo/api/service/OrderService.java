package io.kimmking.rpcfx.demo.api.service;

import io.kimmking.rpcfx.demo.api.domain.Order;

/**
 * 订单服务接口
 *
 * @author monica
 * @date 2020/12/26
 */
public interface OrderService {

    /**
     * 查找订单
     * @param id
     * @return
     */
    Order findOrderById(int id);
}
