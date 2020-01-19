package me.sxl.designdemo.model.vo;

import lombok.Builder;
import lombok.Data;
import me.sxl.designdemo.model.OrderStatus;

import java.math.BigDecimal;

@Data
@Builder
public class OrderVO {

    private String orderNo;

    private String timeEnd;

    private OrderStatus orderStatus;

    private BigDecimal payableAmount;

    private BigDecimal paidAmount;

}
