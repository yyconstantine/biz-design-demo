package me.sxl.designdemo.service;

import me.sxl.designdemo.exception.OrderException;
import me.sxl.designdemo.model.vo.OrderVO;
import me.sxl.designdemo.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public abstract class AbstractOrderService {

    @Autowired
    protected Map<String, OrderService> orderServiceMap;

    protected <T> Response<OrderVO> unifyOrder(String beanName, T t) throws OrderException {
        OrderService orderService = this.orderServiceMap.get(beanName);
        if (!orderService.checkParams(t)) {
            throw new OrderException(400, "Method Args Illegal, Order failed");
        }
        orderService.place(t);
        return orderService.pay(t);
    }

}
