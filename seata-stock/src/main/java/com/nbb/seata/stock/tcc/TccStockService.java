package com.nbb.seata.stock.tcc;

import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 胡鹏
 */
@LocalTCC
public interface TccStockService {

    /**
     * Try阶段：预留库存
     * name: 全局唯一的TCC方法标识（需与其他服务不重复）
     * commitMethod: Confirm阶段方法名（必须与实际方法名一致）
     * rollbackMethod: Cancel阶段方法名（必须与实际方法名一致）
     */
    @Transactional(rollbackFor = Exception.class)
    @TwoPhaseBusinessAction(name = "deductStock", commitMethod = "confirm", rollbackMethod = "cancel")
    boolean tryDeduct(BusinessActionContext context,
                      // 使用@BusinessActionContextParameter标记参数后，在cancel阶段就可以通过context.getActionContext("skuCode")取到对应的值
                      @BusinessActionContextParameter(paramName = "skuCode") String skuCode,  // 传递到二阶段的参数
                      @BusinessActionContextParameter(paramName = "count") Integer count); // 传递到二阶段的参数


    /**
     * Confirm阶段：确认提交
     */
    @Transactional(rollbackFor = Exception.class)
    boolean confirm(BusinessActionContext context);

    /**
     * Cancel阶段：取消操作（回滚）
     */
    @Transactional(rollbackFor = Exception.class)
    boolean cancel(BusinessActionContext context);

}
