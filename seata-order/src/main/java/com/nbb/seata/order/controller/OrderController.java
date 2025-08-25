package com.nbb.seata.order.controller;

import com.nbb.seata.order.service.OrderServiceImpl;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 胡鹏
 */
@RestController
public class OrderController {

    @Resource
    private OrderServiceImpl orderService;

    @GlobalTransactional(rollbackFor = Exception.class, timeoutMills = 30000,lockRetryInternal=3000,lockRetryTimes=10)
    @RequestMapping("/create")
    public String createOrder(String userId, String skuCode, Integer count) {
        orderService.createOrder("user_id_01", "sku_code_01", 1);
        return "success";
    }
}
