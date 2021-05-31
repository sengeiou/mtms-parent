package com.dili.mtms.api;

import com.dili.mtms.domain.TransportOrder;
import com.dili.mtms.service.TransportOrderService;
import com.dili.ss.domain.BaseOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 运输单管理
 */
@RestController
@RequestMapping("/api/transport")
public class TransportOrderApi {

    @Autowired
    TransportOrderService transportOrderService;

    /**
     * 买卖端运输单列表
     * @param transportOrder
     * @return
     * @throws Exception
     */
    @PostMapping(value="/listPage")
    public @ResponseBody BaseOutput listPage(TransportOrder transportOrder) throws Exception {
        return BaseOutput.success();
    }

    /**
     * 买卖端发布运输单
     * @param transportOrder
     * @return
     */
    @PostMapping(value="/insert")
    public @ResponseBody BaseOutput insert(TransportOrder transportOrder) {
        return BaseOutput.success();
    }

    /**
     * 订单详情
     * @param transportOrder
     * @return
     */
    @PostMapping(value="/detail")
    public @ResponseBody BaseOutput detail(TransportOrder transportOrder) {
        return BaseOutput.success();
    }

    /**
     * 取消订单
     * @param transportOrder
     * @return
     */
    @PostMapping(value="/cancel")
    public @ResponseBody BaseOutput cancel(TransportOrder transportOrder) {
        return BaseOutput.success();
    }

    /**
     * 订单完成
     * @param transportOrder
     * @return
     */
    @PostMapping(value="/complete")
    public @ResponseBody BaseOutput complete(TransportOrder transportOrder) {
        return BaseOutput.success();
    }

    /**
     * 删除订单
     * @param transportOrder
     * @return
     */
    @PostMapping(value="/delete")
    public @ResponseBody BaseOutput delete(TransportOrder transportOrder) {
        return BaseOutput.success();
    }
}
