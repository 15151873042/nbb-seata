package com.nbb.seata.stock.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nbb.seata.stock.model.Stock;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 胡鹏
 */
@Mapper
public interface StockMapper extends BaseMapper<Stock> {
}
