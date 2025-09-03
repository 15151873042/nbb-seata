package com.nbb.seata.stock.tcc;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.nbb.seata.stock.common.dao.StockMapper;
import com.nbb.seata.stock.common.model.Stock;
import io.seata.rm.tcc.api.BusinessActionContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 胡鹏
 */
@Service
@Slf4j
public class TccStockServiceImpl implements TccStockService {


    @Resource
    private StockMapper stockMapper;

    @Override
    public boolean tryDeduct(BusinessActionContext context, String skuCode, Integer count) {
        log.info("执行Try阶段：扣减库存, XID={}", context.getXid());
        LambdaUpdateWrapper<Stock> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.setSql("count = count - " +count);
        updateWrapper.eq(Stock::getSkuCode, skuCode);

        stockMapper.update(null, updateWrapper);
        return false;
    }

    @Override
    public boolean confirm(BusinessActionContext context) {
        log.info("执行Confirm阶段：确认扣减库存, XID=", context.getXid());
        // 实际项目中可以在这里进行最终确认操作
        return true;
    }

    @Override
    public boolean cancel(BusinessActionContext context) {
        log.info("执行Cancel阶段：回滚库存, XID=", context.getXid());

        // 1. 从上下文获取参数
        String skuCode = context.getActionContext("skuCode").toString();
        Integer count = Integer.valueOf(context.getActionContext("count").toString());

        // FIXME，实际业务中要幂等处理（超时时，会执行多次）
        LambdaUpdateWrapper<Stock> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.setSql("count = count + " +count);
        updateWrapper.eq(Stock::getSkuCode, skuCode);

        // 2. 回滚库存（实际项目中应操作数据库）
        stockMapper.update(null, updateWrapper);
        return true;
    }
}
