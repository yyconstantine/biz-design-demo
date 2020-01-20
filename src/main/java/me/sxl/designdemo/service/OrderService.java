package me.sxl.designdemo.service;

import me.sxl.designdemo.model.OrderDO;
import me.sxl.designdemo.model.dto.ChangeBalanceDTO;
import me.sxl.designdemo.model.dto.UpdateOrderDTO;

public interface OrderService {

    /**
     * 记录一笔订单
     */
    Boolean recordOrder(OrderDO orderDO);

    /**
     * 更新订单状态(用于扣款结束后)
     */
    Boolean updateOrder(UpdateOrderDTO updateOrderDTO);

    /**
     * 变更账户余额
     */
    Boolean changeBalance(ChangeBalanceDTO changeBalanceDTO);

}
