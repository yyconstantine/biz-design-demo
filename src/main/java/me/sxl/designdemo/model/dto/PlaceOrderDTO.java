package me.sxl.designdemo.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PlaceOrderDTO {

    private String merId;

    private String storeId;

    private String userId;

    private BigDecimal payableAmount;

    private BigDecimal paidAmount;

}
