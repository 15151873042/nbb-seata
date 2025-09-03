package com.nbb.seata.stock.at;

import com.nbb.seata.stock.tcc.TccStockService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 胡鹏
 */
@RestController
@RequestMapping("/at")
public class AtStockController {

    @Resource
    private AtStockService atStockService;

    @RequestMapping("/deduct")
    public boolean deductStock(@RequestParam("skuCode") String skuCode,
                              @RequestParam("count") Integer count) {
        return atStockService.deductStock(skuCode, count);
    }
}
