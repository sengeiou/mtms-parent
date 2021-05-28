package com.dili.mtms.api;

import com.dili.mtms.domain.TransportOrder;
import com.dili.ss.domain.BaseOutput;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 司机端订单
 */
@RestController
@RequestMapping("/api/driver")
public class DriverOrderApi {

    /**
     * 订单列表
     * @param firmId
     * @return
     */
    @PostMapping(value="/listPage.action")
    public @ResponseBody BaseOutput listPage(Long firmId){
        return BaseOutput.success();
    }

    /**
     * 订单详情
     * @param transportOrder
     * @return
     * @throws Exception
     */
    @PostMapping(value="/detail.action")
    public @ResponseBody BaseOutput detail(TransportOrder transportOrder) throws Exception {
        return BaseOutput.success();
    }
}
