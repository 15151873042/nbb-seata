package com.nbb.seata.order.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 胡鹏
 */
@FeignClient(value = "seata-stock", contextId = "StockApi")
public interface StockApi {


    @RequestMapping("/deduct")
    String deductStock(@RequestParam("skuCode") String skuCode, @RequestParam("count") Integer count);
}
