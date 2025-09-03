package com.nbb.seata.order.tcc;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author 胡鹏
 */
public interface TccOrderService {

    @Transactional(rollbackFor = Exception.class)
    boolean createOrder(String userId, String skuCode, Integer count);
}
