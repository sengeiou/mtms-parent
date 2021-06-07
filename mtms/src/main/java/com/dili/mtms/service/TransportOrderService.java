package com.dili.mtms.service;

import com.dili.mtms.domain.TransportOrder;
import com.dili.mtms.dto.BaseData;
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
     * pc运输单列表
     * @param quey
     * @return
     */
    BaseData listByQueryParams(TransportOrderQuey quey) throws Exception;

    /**
     * 买卖端运输单列表
     * @param order
     * @return
     */
    BaseData transportList(TransportOrderQuey order) throws Exception;

    /**
     * 买卖端新增运输单
     * @param order
     * @return
     * @throws Exception
     */
    int insertTransport(TransportOrderQuey order)throws Exception;

    /**
     * 买卖端-运输单-详情
     * @param order
     * @return
     */
    TransportOrderQuey transportDetail(TransportOrderQuey order) throws Exception;

    /**
     * 买卖段-运输-删除
     * @param order
     */
    int deleteTransporOrder(TransportOrder order)throws Exception;

    /**
     * 取消运输单
     * @param order
     * @return
     */
    int transportCancel(TransportOrder order)throws Exception;

    /**
     * 运输单 确认收货
     * @param order
     * @return
     */
    int transportComplete(TransportOrder order)throws Exception;

    /**
     * 运输单（司机确认接单）
     * @param order
     * @return
     */
    int confirmTransportOrder(TransportOrder order)throws Exception;
}