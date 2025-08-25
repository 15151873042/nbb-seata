package com.nbb.seata.stock.controller;

import com.nbb.seata.stock.service.StockServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 胡鹏
 */
@RestController
public class StockController {

    @Resource
    private StockServiceImpl stockService;

    @RequestMapping("/deduct")
    public String deductStock(@RequestParam("skuCode") String skuCode, @RequestParam("count") Integer count) {
        stockService.deductStock(skuCode, count);
        return "success";
    }
}
