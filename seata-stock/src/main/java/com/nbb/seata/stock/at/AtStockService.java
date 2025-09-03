package com.nbb.seata.stock.at;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author 胡鹏
 */
public interface AtStockService {


    @Transactional(rollbackFor = Exception.class)
    boolean deductStock(String skuCode, Integer count);
}
