package com.dili.mtms.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.dili.mtms.domain.LoadingOrder;
import com.dili.mtms.domain.LoadingOrderItem;
import com.dili.mtms.domain.TransportOrderItem;
import com.dili.mtms.dto.BaseData;
import com.dili.mtms.dto.LoadingOrderQuey;
import com.dili.mtms.dto.TransportOrderQuey;
import com.dili.mtms.mapper.LoadingOrderMapper;
import com.dili.mtms.service.LoadingOrderService;
import com.dili.ss.base.BaseServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2021-05-20 17:20:00.
 */
@Service
public class LoadingOrderServiceImpl extends BaseServiceImpl<LoadingOrder, Long> implements LoadingOrderService {

    public LoadingOrderMapper getActualDao() {
        return (LoadingOrderMapper)getDao();
    }

    @Autowired
    private LoadingOrderMapper loadingOrderMapper;

    /**
     * 买卖端-装卸-列表
     * @param order
     * @return
     * @throws Exception
     */
    @Override
    public BaseData loadingList(LoadingOrder order) throws Exception {
        //分页处理
        int page = order.getPage()==null ? 1 : order.getPage();
        int rows = order.getRows()==null ? 10 : order.getRows();
        PageHelper.startPage(page, rows);
        List<LoadingOrderQuey> list = loadingOrderMapper.loadingList(order);
        //数据封装
        int totalPage = list instanceof Page ? ((Page) list).getPages() : 1;
        BaseData baseData = new BaseData();
        baseData.setTotal(totalPage);
        baseData.setRows(list);

        return baseData;
    }

    /**
     * 买卖端-装卸-新增
     * @param order
     * @return
     * @throws Exception
     */
    @Override
    public int insertLoading(LoadingOrderQuey order) throws Exception {
        //订单项数据处理
        List<LoadingOrderItem> list = JSONArray.parseArray(order.getOrderItem(), LoadingOrderItem.class);
        int i = loadingOrderMapper.insertLoading(order);
        int j = loadingOrderMapper.insertLoadingItem(list,order.getId());
        return 1;
    }

    /**
     * 删除订单
     * @param id
     * @throws Exception
     */
    @Override
    public void deleteLoadingOrder(Long id) throws Exception {
        loadingOrderMapper.deleteLoadingOrder(id);
        loadingOrderMapper.deleteLoadingOrderItem(id);
    }
}