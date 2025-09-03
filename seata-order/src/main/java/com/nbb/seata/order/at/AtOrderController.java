package com.nbb.seata.order.at;

import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 胡鹏
 */
@RequestMapping("/at")
@RestController
public class AtOrderController {

    @Resource
    private AtOrderService atOrderService;

    @GlobalTransactional(rollbackFor = Exception.class, timeoutMills = 30000, lockRetryInternal=3000, lockRetryTimes=10)
    @RequestMapping("/create")
    public boolean createOrder() {
        return atOrderService.createOrder("user_id_01", "sku_code_01", 1);
    }
}
