package me.sxl.designdemo.service.impl;

import me.sxl.designdemo.exception.OrderException;
import me.sxl.designdemo.model.Response;
import me.sxl.designdemo.model.vo.OrderVO;
import me.sxl.designdemo.service.AbstractOrderService;
import org.springframework.stereotype.Service;

@Service
public class SweptPayServiceImpl extends AbstractOrderService {

    @Override
    protected <T> Boolean checkParams(T t) throws OrderException {
        return null;
    }

    @Override
    protected <T> Response<OrderVO> pay(T t) throws OrderException {
        return null;
    }
}
