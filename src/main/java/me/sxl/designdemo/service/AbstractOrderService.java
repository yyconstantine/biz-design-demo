package me.sxl.designdemo.service;

import me.sxl.designdemo.exception.OrderException;
import me.sxl.designdemo.model.OrderDO;
import me.sxl.designdemo.model.Response;
import me.sxl.designdemo.model.dto.PlaceOrderDTO;
import me.sxl.designdemo.model.vo.OrderVO;
import me.sxl.designdemo.model.vo.PlaceOrderVO;
import me.sxl.designdemo.utils.OrderNoBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
public abstract class AbstractOrderService {

    protected OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * 定义子类必须实现的参数校验方法
     */
    protected abstract <T> Boolean checkParams(T t) throws OrderException;

    /**
     * 定义子类必须实现的扣款方法
     */
    protected abstract <T> Response<OrderVO> pay(T t) throws OrderException;

    /**
     * 统一下单操作,这里简单演示为创建一笔订单
     *
     * @param t   下单业务参数,这里实际使用的是
     * @param <T>
     * @return orderNo + payableAmount + paidAmount
     * @throws OrderException 自定义业务异常
     * @see PlaceOrderDTO
     */
    private <T> Response<PlaceOrderVO> place(T t) throws OrderException {
        if (t instanceof PlaceOrderDTO) {
            PlaceOrderDTO orderDTO = (PlaceOrderDTO) t;
            String orderId = UUID.randomUUID().toString();
            String orderNo = OrderNoBuilder.getOrderNo();
            String createDate = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            // 下单
            this.orderService.recordOrder(OrderDO.builder()
                    .orderId(orderId)
                    .orderNo(orderNo)
                    .createDate(createDate)
                    .merId(orderDTO.getMerId())
                    .storeId(orderDTO.getStoreId())
                    .userId(orderDTO.getUserId())
                    .payableAmount(orderDTO.getPayableAmount())
                    .paidAmount(orderDTO.getPaidAmount())
                    .build());
            return new Response<>(200, "order success", PlaceOrderVO.builder()
                    .orderNo(orderNo)
                    .payableAmount(orderDTO.getPayableAmount())
                    .paidAmount(orderDTO.getPaidAmount())
                    .build());
        }
        throw new OrderException(400, "Parameter Types Illegal For Service");
    }

    /**
     * 统一的同步支付入口,采用模版方法设计,封装了一笔正常的支付流程的动作,即参数校验、下单、扣款,在子类中实现各自的业务逻辑校验和扣款逻辑
     * PS:使用final防止子类重写
     * PPS:这里最好是做异步处理
     *
     * @param t   支付参数
     * @param <T> 支付参数泛型
     * @return 目前定义为orderNo + timeEnd + orderStatus
     * @throws OrderException 自定义业务异常
     */
    public final <T> Response<OrderVO> syncUnifyOrder(T t) throws OrderException {
        if (!this.checkParams(t)) {
            throw new OrderException(400, "Method Args Illegal");
        }
        Response<PlaceOrderVO> placeResult = this.place(t);
        if (placeResult.getCode() == 200) {
            return this.pay(t);
        }
        throw new OrderException(500, "Place Order Occured Some Error");
    }

}
