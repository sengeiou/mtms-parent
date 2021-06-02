package com.dili.mtms.service;

import com.dili.mtms.domain.TransportOrder;
import com.dili.mtms.dto.TransportOrderQuey;
import com.dili.ss.base.BaseService;
import com.dili.ss.domain.PageOutput;

import java.util.List;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2021-05-20 17:20:00.
 */
public interface TransportOrderService extends BaseService<TransportOrder, Long> {

    /**
     * 运输单列表
     * @param quey
     * @return
     */
    PageOutput<List<TransportOrderQuey>> listByQueryParams(TransportOrderQuey quey) throws Exception;

}