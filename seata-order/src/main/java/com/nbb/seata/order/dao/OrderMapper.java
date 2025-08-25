package com.nbb.seata.order.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nbb.seata.order.model.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 胡鹏
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
