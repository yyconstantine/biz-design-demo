package me.sxl.designdemo.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RefundOrderDTO {

    private String orderNo;

    private String merId;

}
