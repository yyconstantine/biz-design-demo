package me.sxl.designdemo.model.vo;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class PlaceOrderVO {

    private String orderNo;

    private BigDecimal payableAmount;

    private BigDecimal paidAmount;

}
