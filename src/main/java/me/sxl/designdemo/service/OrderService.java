package me.sxl.designdemo.service;

import me.sxl.designdemo.exception.OrderException;
import me.sxl.designdemo.model.vo.OrderVO;
import me.sxl.designdemo.model.Response;

public interface OrderService {

    /**
     * 统一参数校验
     */
    <T> Boolean checkParams(T t) throws OrderException;

    /**
     * 统一下单
     */
    <T> Response<OrderVO> place(T t) throws OrderException;

    /**
     * 统一支付
     */
    <T> Response<OrderVO> pay(T t) throws OrderException;

}
