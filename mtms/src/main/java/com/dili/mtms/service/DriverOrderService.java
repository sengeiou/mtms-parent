package com.dili.mtms.service;

import com.dili.mtms.dto.BaseData;
import com.dili.mtms.dto.DriverOrderQuey;

/***
 * 司机端service
 */
public interface DriverOrderService {

    /**
     * 司机端列表
     * @param driver
     * @return
     * @throws Exception
     */
    BaseData driverList(DriverOrderQuey driver) throws Exception;

    /**
     * 司机端订单详情
     * @param driver
     * @return
     * @throws Exception
     */
    Object driverDetail(DriverOrderQuey driver)throws Exception;
}