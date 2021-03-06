package com.dili.mtms.service;

import com.dili.mtms.common.BaseData;
import com.dili.mtms.domain.LoadingOrder;
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
    LoadingOrderQuey insertLoading(LoadingOrderQuey order)throws Exception;

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

    /**
     * pc端-装卸-列表
     * @param checkQuey
     * @return
     * @throws Exception
     */
    BaseData listByQueryParams(LoadingOrderQuey checkQuey)throws Exception;

    /**
     * 取消装卸单
     * @param loadingOrder
     * @return
     */
    int loadingCancel(LoadingOrder loadingOrder)throws Exception;

    /**
     * 订单完成
     * @param loadingOrder
     * @return
     * @throws Exception
     */
    int loadingComplete(LoadingOrder loadingOrder)throws Exception;

    /**
     * 装卸单 确认接单
     * @param loadingOrder
     * @return
     */
    int confirmLoadingOrder(LoadingOrder loadingOrder)throws Exception;

    /**
     * 订单失效处理
     * @param id
     * @return
     * @throws Exception
     */
    int orderFailure(String id)throws Exception;
}