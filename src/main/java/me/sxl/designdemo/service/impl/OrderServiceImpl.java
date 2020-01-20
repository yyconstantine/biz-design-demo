package me.sxl.designdemo.service.impl;

import me.sxl.designdemo.model.OrderDO;
import me.sxl.designdemo.model.dto.ChangeBalanceDTO;
import me.sxl.designdemo.model.dto.UpdateOrderDTO;
import me.sxl.designdemo.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public Boolean recordOrder(OrderDO orderDO) {
        return null;
    }

    @Override
    public Boolean updateOrder(UpdateOrderDTO updateOrderDTO) {
        return null;
    }

    @Override
    public Boolean changeBalance(ChangeBalanceDTO changeBalanceDTO) {
        return null;
    }
}
