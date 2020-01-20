package me.sxl.designdemo.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class OrderDO {

    private String orderId;

    private String orderNo;

    private String createDate;

    private String timeEnd;

    private String merId;

    private String storeId;

    private String userId;

    private BigDecimal payableAmount;

    private BigDecimal paidAmount;

}
