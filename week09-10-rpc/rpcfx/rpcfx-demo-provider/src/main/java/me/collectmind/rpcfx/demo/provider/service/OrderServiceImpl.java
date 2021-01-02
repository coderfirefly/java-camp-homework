package me.collectmind.rpcfx.demo.provider.service;

import me.collectmind.rpcfx.demo.api.domain.Order;
import me.collectmind.rpcfx.demo.api.service.OrderService;

/**
 * 服务实现类示例
 * @author monica
 * @date 2020/12/26
 */
public class OrderServiceImpl implements OrderService {

    @Override
    public Order findOrderById(int id) {
        return new Order(id, "OrderServiceImpl_" + System.currentTimeMillis(), 9.9f);
    }

}
