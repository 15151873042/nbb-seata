package com.nbb.seata.order.at;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author 胡鹏
 */
public interface AtOrderService {

    @Transactional(rollbackFor = Exception.class)
    boolean createOrder(String userId, String skuCode, Integer count);
}
