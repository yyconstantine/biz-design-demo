package me.sxl.designdemo.service.impl;

import me.sxl.designdemo.exception.OrderException;
import me.sxl.designdemo.model.OrderStatus;
import me.sxl.designdemo.model.Response;
import me.sxl.designdemo.model.dto.ChangeBalanceDTO;
import me.sxl.designdemo.model.dto.PayDTO;
import me.sxl.designdemo.model.dto.SweepOrderDTO;
import me.sxl.designdemo.model.dto.UpdateOrderDTO;
import me.sxl.designdemo.model.vo.OrderVO;
import me.sxl.designdemo.service.AbstractOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class SweepPayServiceImpl extends AbstractOrderService {

    @Override
    protected <T> Boolean checkParams(T t) throws OrderException {
        if (t instanceof SweepOrderDTO) {
            SweepOrderDTO payDTO = (SweepOrderDTO) t;
            // 进行业务逻辑校验

            // 校验门店与商户的匹配关系

            // 校验用户是否存在

            // 校验用户名下账户是否可用

            // 校验用户余额是否足够支付

            return true;
        }
        throw new OrderException(400, "Parameter Types Illegal For Service");
    }

    @Override
    @Transactional(rollbackFor = OrderException.class)
    protected <T> Response<OrderVO> pay(T t) throws OrderException {
        if (t instanceof PayDTO) {
            PayDTO payDTO = (PayDTO) t;
            String timeEnd = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            if (this.orderService.changeBalance(ChangeBalanceDTO.builder()
                    .payableAmount(payDTO.getPayableAmount())
                    .userId(payDTO.getUserId())
                    .build()) &&
                    this.orderService.updateOrder(UpdateOrderDTO.builder()
                            .orderNo(payDTO.getOrderNo())
                            .timeEnd(timeEnd)
                            .build())) {
                return new Response<>(200, "pay success", OrderVO.builder()
                        .orderNo(payDTO.getOrderNo())
                        .orderStatus(OrderStatus.PAID)
                        .timeEnd(timeEnd)
                        .build());
            }
            throw new OrderException(500, "pay fail");
        }
        throw new OrderException(400, "Parameter Types Illegal For Service");
    }
}
