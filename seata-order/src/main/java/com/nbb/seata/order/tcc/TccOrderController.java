package com.nbb.seata.order.tcc;

import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 胡鹏
 */
@RequestMapping("/tcc")
@RestController
public class TccOrderController {

    @Resource
    private TccOrderService tccOrderService;

    @GlobalTransactional(rollbackFor = Exception.class, timeoutMills = 30000, lockRetryInternal=3000, lockRetryTimes=10)
    @RequestMapping("/create")
    public boolean createOrder() {
        return tccOrderService.createOrder("user_id_01", "sku_code_01", 1);
    }
}
