package io.kimmking.rpcfx.demo.provider.service;

import io.kimmking.rpcfx.demo.api.domain.Order;
import io.kimmking.rpcfx.demo.api.service.OrderService;

/**
 *
 * @author monica
 * @date 2020/12/26
 */
public class OrderServiceImpl implements OrderService {

    @Override
    public Order findOrderById(int id) {
        return new Order(id, "Cuijing" + System.currentTimeMillis(), 9.9f);
    }

}
