package com.nbb.seata.stock.service;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.nbb.seata.stock.dao.StockMapper;
import com.nbb.seata.stock.model.Stock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author 胡鹏
 */
@Service
public class StockServiceImpl {

    @Resource
    private StockMapper stockMapper;

    @Transactional(rollbackFor = Exception.class)
    public void deductStock(String skuCode, Integer count) {
        LambdaUpdateWrapper<Stock> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.setSql("count = count - " +count);
        updateWrapper.eq(Stock::getSkuCode, skuCode);

        stockMapper.update(null, updateWrapper);
    }
}
