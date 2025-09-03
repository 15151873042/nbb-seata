package com.nbb.seata.order.common.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nbb.seata.order.common.model.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 胡鹏
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
