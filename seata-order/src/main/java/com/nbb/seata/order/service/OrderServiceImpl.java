package com.nbb.seata.order.service;

import com.nbb.seata.order.api.StockApi;
import com.nbb.seata.order.dao.OrderMapper;
import com.nbb.seata.order.model.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author 胡鹏
 */
@Service
public class OrderServiceImpl {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private StockApi stockApi;

    @Transactional(rollbackFor = Exception.class)
    public void createOrder(String userId, String skuCode, Integer count) {

        stockApi.deductStock(skuCode, count);



        Order order = Order.builder()
                .userId(userId)
                .skuCode(skuCode)
                .count(count)
                .money(10 * count)
                .build();

//        throw new RuntimeException("测试事务回滚");

        orderMapper.insert(order);

    }
}
