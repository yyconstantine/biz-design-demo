package me.sxl.designdemo.service.impl;

import me.sxl.designdemo.exception.OrderException;
import me.sxl.designdemo.model.Response;
import me.sxl.designdemo.model.dto.ChangeBalanceDTO;
import me.sxl.designdemo.model.dto.PayDTO;
import me.sxl.designdemo.model.dto.RefundOrderDTO;
import me.sxl.designdemo.model.vo.OrderVO;
import me.sxl.designdemo.service.AbstractOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class RefundServiceImpl extends AbstractOrderService {

    @Override
    protected <T> Boolean checkParams(T t) throws OrderException {
        if (t instanceof RefundOrderDTO) {
            RefundOrderDTO refundOrderDTO = (RefundOrderDTO) t;

            // 校验订单是否存在

            // 校验是否已进行退款操作

            // 校验所退订单是否归属于当前商户

            return true;
        }
        throw new OrderException(400, "Parameter Types Illegal For Service");
    }

    @Override
    @Transactional(rollbackFor = OrderException.class)
    protected <T> Response<OrderVO> pay(T t) throws OrderException {
        if (t instanceof PayDTO) {
            PayDTO payDTO = (PayDTO) t;
            if (!this.orderService.changeBalance(ChangeBalanceDTO.builder()
                    .payableAmount(payDTO.getPayableAmount().multiply(new BigDecimal("-1")))
                    .userId(payDTO.getUserId())
                    .build())) {
                throw new OrderException(500, "Change User Balance Occured Some Error, Start Rollback");
            }
            // 再标记原订单或创建退款订单,这里不再展开
        }
        throw new OrderException(400, "Parameter Types Illegal For Service");
    }
}
