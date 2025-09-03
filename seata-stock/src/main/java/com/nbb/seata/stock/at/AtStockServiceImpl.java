package com.nbb.seata.stock.at;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.nbb.seata.stock.common.dao.StockMapper;
import com.nbb.seata.stock.common.model.Stock;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 胡鹏
 */
@Service
public class AtStockServiceImpl implements AtStockService{

    @Resource
    private StockMapper stockMapper;

    @Override
    public boolean deductStock(String skuCode, Integer count) {
        LambdaUpdateWrapper<Stock> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.setSql("count = count - " +count);
        updateWrapper.eq(Stock::getSkuCode, skuCode);

        stockMapper.update(null, updateWrapper);

        return true;
    }
}
