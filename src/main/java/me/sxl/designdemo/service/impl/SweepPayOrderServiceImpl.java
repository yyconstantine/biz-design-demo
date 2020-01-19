package me.sxl.designdemo.service.impl;

import me.sxl.designdemo.exception.OrderException;
import me.sxl.designdemo.model.vo.OrderVO;
import me.sxl.designdemo.model.Response;
import me.sxl.designdemo.service.OrderService;
import org.springframework.stereotype.Service;

@Service("sweepPayService")
public class SweepPayOrderServiceImpl implements OrderService {

    @Override
    public <T> Boolean checkParams(T t) throws OrderException {
        return null;
    }

    @Override
    public <T> Response<OrderVO> place(T t) throws OrderException {
        return null;
    }

    @Override
    public <T> Response<OrderVO> pay(T t) throws OrderException {
        return null;
    }
}
