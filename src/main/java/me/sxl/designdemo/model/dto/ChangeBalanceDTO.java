package me.sxl.designdemo.model.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ChangeBalanceDTO {

    private String userId;

    private BigDecimal payableAmount;

}
