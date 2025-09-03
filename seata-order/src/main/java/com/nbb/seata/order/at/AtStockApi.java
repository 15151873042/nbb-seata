package com.nbb.seata.order.at;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 胡鹏
 */
@FeignClient(value = "seata-stock", contextId = "AtStockApi")
public interface AtStockApi {


    @RequestMapping("/at/deduct")
    String deductStock(@RequestParam("skuCode") String skuCode,
                       @RequestParam("count") Integer count);
}
