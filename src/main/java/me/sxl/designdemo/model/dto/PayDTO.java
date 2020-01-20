package me.sxl.designdemo.model.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 统一支付数据模型
 */
@Data
@Builder
public class PayDTO {

    private String orderNo;

    private BigDecimal payableAmount;

    private String userId;

}
