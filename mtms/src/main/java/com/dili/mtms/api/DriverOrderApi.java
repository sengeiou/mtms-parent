package com.dili.mtms.api;

import com.dili.mtms.domain.TransportOrder;
import com.dili.mtms.dto.BaseData;
import com.dili.mtms.dto.DriverOrderQuey;
import com.dili.mtms.dto.TransportOrderQuey;
import com.dili.mtms.service.DriverOrderService;
import com.dili.ss.domain.BaseOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 司机端订单
 */
@RestController
@RequestMapping("/api/driver")
@Slf4j
public class DriverOrderApi {

    @Autowired
    private DriverOrderService driverOrderService;

    /**
     * 订单列表
     * @param driver
     * @return
     */
    @PostMapping(value="/listPage")
    public @ResponseBody BaseOutput driverList(DriverOrderQuey driver){
        BaseData data = null;
        try {
            data = driverOrderService.driverList(driver);
        }catch (Exception e){
            log.error(e.getMessage(), e);
            return BaseOutput.failure();
        }
        return BaseOutput.success().setData(data);
    }

    /**
     * 订单详情
     * @param driver
     * @return
     * @throws Exception
     */
    @PostMapping(value="/detail")
    public @ResponseBody BaseOutput driverDetail(DriverOrderQuey driver) {
        Object detailInfo = null;
        try {
            detailInfo = driverOrderService.driverDetail(driver);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return BaseOutput.failure();
        }
        return BaseOutput.success().setData(detailInfo);
    }


}
