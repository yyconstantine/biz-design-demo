package me.sxl.designdemo.facade;

import me.sxl.designdemo.exception.OrderException;
import me.sxl.designdemo.model.ServiceConstants;
import me.sxl.designdemo.model.dto.RefundDTO;
import me.sxl.designdemo.model.dto.SweepPayDTO;
import me.sxl.designdemo.model.dto.SweptPayDTO;
import me.sxl.designdemo.model.vo.OrderVO;
import me.sxl.designdemo.model.Response;
import me.sxl.designdemo.service.AbstractOrderService;
import org.springframework.stereotype.Component;

@Component
public class OrderRpcFacade extends AbstractOrderService {

    public Response<OrderVO> sweepPayRpcService(SweepPayDTO sweepPayDTO) throws OrderException {
        return this.unifyOrder(ServiceConstants.SWEEP_PAY_SERVICE_VALUE, sweepPayDTO);
    }

    public Response<OrderVO> sweptPayRpcService(SweptPayDTO sweptPayDTO) throws OrderException {
        return this.unifyOrder(ServiceConstants.SWEPT_PAY_SERVICE_VALUE, sweptPayDTO);
    }

    public Response<OrderVO> refundRpcService(RefundDTO refundDTO) throws OrderException {
        return this.unifyOrder(ServiceConstants.REFUND_SERVICE_VALUE, refundDTO);
    }

}
