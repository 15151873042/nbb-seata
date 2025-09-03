package com.nbb.seata.order.at;

import com.nbb.seata.order.common.dao.OrderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 胡鹏
 */
@Service
public class AtOrderServiceImpl implements AtOrderService {

    @Resource
    private AtStockApi atStockApi;

    @Resource
    private OrderMapper orderMapper;

    @Override
    public boolean createOrder(String userId, String skuCode, Integer count) {

        // 1、扣减库存
        atStockApi.deductStock(skuCode, count);

        // 2、模拟报错
        throw new RuntimeException("测试事务回滚");




//        // 2、新增订单
//        Order order = Order.builder()
//                .userId(userId)
//                .skuCode(skuCode)
//                .count(count)
//                .money(10 * count)
//                .build();
//
//        orderMapper.insert(order);
    }
}
