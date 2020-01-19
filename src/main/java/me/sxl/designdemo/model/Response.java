package me.sxl.designdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response<T> {

    private int code;

    private String msg;

    private T data;

}
