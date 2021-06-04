package com.dili.mtms.service;

import com.dili.mtms.domain.LoadingOrder;
import com.dili.mtms.dto.BaseData;
import com.dili.mtms.dto.LoadingOrderQuey;
import com.dili.ss.base.BaseService;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2021-05-20 17:20:00.
 */
public interface LoadingOrderService extends BaseService<LoadingOrder, Long> {
    /**
     * 买卖端-装卸-列表
     * @param loadingOrder
     * @return
     */
    BaseData loadingList(LoadingOrderQuey loadingOrder) throws Exception;

    /**
     * 买卖端-装卸-新增
     * @param order
     * @return
     * @throws Exception
     */
    int insertLoading(LoadingOrderQuey order)throws Exception;

    /**
     * 删除订单
     * @param id
     * @throws Exception
     */
    void deleteLoadingOrder(Long id)throws Exception;

    /**
     * 买卖端-装卸-订单详情
     * @param order
     * @return
     */
    LoadingOrderQuey loadingDetail(LoadingOrderQuey order)throws Exception;
}