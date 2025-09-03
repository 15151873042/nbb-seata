package com.nbb.seata.stock.tcc;

import io.seata.rm.tcc.api.BusinessActionContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 胡鹏
 */
@RestController
@RequestMapping("/tcc")
public class TccStockController {

    @Resource
    private TccStockService tccStockService;

    @RequestMapping("/deduct")
    public boolean deductStock(@RequestParam("skuCode") String skuCode,
                              @RequestParam("count") Integer count) {
        // 调用TCC的Try方法，context由Seata自动填充
        tccStockService.tryDeduct(null, skuCode, count);
        return true;
    }
}
