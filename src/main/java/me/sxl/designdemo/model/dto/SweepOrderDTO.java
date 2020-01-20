package me.sxl.designdemo.model.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * 主扫支付交易参数
 */
@Data
@Builder
public class SweepOrderDTO {

    @NotNull
    @NotEmpty
    private String userId;

    @NotNull
    @NotEmpty
    private String merId;

    @NotNull
    @NotEmpty
    private String storeId;

    @NotNull
    @DecimalMin(value = "0")
    private BigDecimal payableAmount;

    @NotNull
    @DecimalMin(value = "0")
    private BigDecimal paidAmount;

}
