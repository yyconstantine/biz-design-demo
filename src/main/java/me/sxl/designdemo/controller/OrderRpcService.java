package me.sxl.designdemo.controller;

import me.sxl.designdemo.exception.OrderException;
import me.sxl.designdemo.model.Response;
import me.sxl.designdemo.model.dto.RefundOrderDTO;
import me.sxl.designdemo.model.dto.SweepOrderDTO;
import me.sxl.designdemo.model.dto.SweptOrderDTO;
import me.sxl.designdemo.model.vo.OrderVO;
import me.sxl.designdemo.service.AbstractOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * http接口,也可以是暴露rpc服务的类
 * 交易这种涉及动作的接口很难遵循rest规范,所以随便写了些
 */
@RestController
@RequestMapping("/pay")
public class OrderRpcService {

    /**
     * 通过Map持有所有AbstractOrderService的实现类,使用beanName作为key,避免每次调用重新生成
     */
    private Map<String, AbstractOrderService> orderServiceMap;

    @Autowired
    public void setOrderServiceMap(Map<String, AbstractOrderService> orderServiceMap) {
        this.orderServiceMap = orderServiceMap;
    }

    /**
     * 主扫交易
     */
    @PostMapping("/sweep")
    public Response<OrderVO> sweepPay(SweepOrderDTO orderDTO) throws OrderException {
        return orderServiceMap.get("sweepPayServiceImpl").syncUnifyOrder(orderDTO);
    }

    /**
     * 被扫交易
     */
    @PostMapping("/swept")
    public Response<OrderVO> sweptPay(SweptOrderDTO orderDTO) throws OrderException {
        return orderServiceMap.get("sweptPayServiceImpl").syncUnifyOrder(orderDTO);
    }

    /**
     * 退款
     */
    @PostMapping("/refund")
    public Response<OrderVO> refund(RefundOrderDTO orderDTO) throws OrderException {
        return orderServiceMap.get("refundServiceImpl").syncUnifyOrder(orderDTO);
    }

}
