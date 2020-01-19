package me.sxl.designdemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OrderStatus {

    WAITING(0, ""),
    PENDING(1, ""),
    PAID(2, ""),
    REVOKE(3, ""),
    REFUND(4, "");

    private int code;

    private String description;

}
