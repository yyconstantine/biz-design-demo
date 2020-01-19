package me.sxl.designdemo.exception;

import me.sxl.designdemo.model.Response;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class OrderExceptionHandler {

    @ExceptionHandler(OrderException.class)
    public Response handleOrderException(OrderException e) {
        return new Response(e.getCode(), e.getMsg(), null);
    }

    @ExceptionHandler(Exception.class)
    public Response handleException(Exception e) {
        return new Response(500, "unknown", null);
    }

}
