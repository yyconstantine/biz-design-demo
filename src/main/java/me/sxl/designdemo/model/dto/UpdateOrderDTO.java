package me.sxl.designdemo.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateOrderDTO {

    private String orderId;

    private String orderNo;

    private String merId;

    private String storeId;

    private String userId;

    private String timeEnd;

}
