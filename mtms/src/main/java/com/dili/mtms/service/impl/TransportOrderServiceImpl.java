package com.dili.mtms.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.dili.mtms.domain.TransportOrder;
import com.dili.mtms.domain.TransportOrderItem;
import com.dili.mtms.dto.BaseData;
import com.dili.mtms.dto.CfgContent;
import com.dili.mtms.dto.TransportOrderQuey;
import com.dili.mtms.mapper.TransportOrderMapper;
import com.dili.mtms.service.TransportOrderService;
import com.dili.mtms.utils.DateTimeUtil;
import com.dili.ss.base.BaseServiceImpl;
import com.dili.ss.domain.PageOutput;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2021-05-20 17:20:00.
 */
@Service
public class TransportOrderServiceImpl extends BaseServiceImpl<TransportOrder, Long> implements TransportOrderService {

    public TransportOrderMapper getActualDao() {
        return (TransportOrderMapper)getDao();
    }

    @Autowired
    private TransportOrderMapper mapper;

    /**
     * 运输单列表
     * @param quey
     * @return
     */
    @Override
    public BaseData listByQueryParams(TransportOrderQuey quey) throws Exception{
        //查询数据
        int page = quey.getPage()==null ? 1 : quey.getPage();
        int rows = quey.getRows()==null ? 10 : quey.getRows();
        PageHelper.startPage(page, rows);
        List<TransportOrderQuey> list = mapper.listByQueryParams(quey);
        Long total = list instanceof Page ? ((Page) list).getTotal() : list.size();
        BaseData baseData = new BaseData();
        baseData.setTotal(total);
        baseData.setRows(list);
        return baseData;
    }

    /**
     * 买卖端运输单列表
     * @param order
     * @return
     */
    @Override
    public BaseData transportList(TransportOrderQuey order) throws Exception{
        //分页处理
        int page = order.getPage()==null ? 1 : order.getPage();
        int rows = order.getRows()==null ? 10 : order.getRows();
        PageHelper.startPage(page, rows);
        List<TransportOrderQuey> list = mapper.transportList(order);
        //数据封装
        int totalPage = list instanceof Page ? ((Page) list).getPages() : 1;
        BaseData baseData = new BaseData();
        baseData.setTotal(totalPage);
        baseData.setRows(list);

        return baseData;
    }

    /**
     * 买卖端新增运输单
     * @param order
     * @return
     * @throws Exception
     */
    @Override
    public int insertTransport(TransportOrderQuey order) throws Exception {
        //订单项数据处理
        List<TransportOrderItem> list = JSONArray.parseArray(order.getOrderItem(),TransportOrderItem.class);
        for(TransportOrderItem item:list){
            if(item.getWeightType() == CfgContent.PIECE){//计件
                 item.setTotalWeight(item.getNumber()*item.getUnitWeight());
            }
        }
        int i = mapper.insertTransport(order);
        int j = mapper.insertTransportItem(list,order.getId());
        return 1;
    }

    /**
     * 买卖端-运输单-详情
     * @param order
     * @return
     */
    @Override
    public TransportOrderQuey transportDetail(TransportOrderQuey order) throws Exception{
        return mapper.transportDetail(order.getId());
    }

    /**
     * 买卖段-运输-删除
     * @param order
     * @throws Exception
     */
    @Override
    public int deleteTransporOrder(TransportOrder order) throws Exception {
        int i = mapper.deleteTransporOrder(order);
        if(i>0){
            return mapper.deleteTransporOrderItem(order);
        }
        return 0;

    }

    /**
     * 取消运输单
     * @param order
     * @return
     * @throws Exception
     */
    @Override
    public int transportCancel(TransportOrder order) throws Exception {
        return mapper.transportCancel(order);
    }

    /**
     * 运输单 确认收货
     * @param order
     * @return
     * @throws Exception
     */
    @Override
    public int transportComplete(TransportOrder order) throws Exception {
        return mapper.transportComplete(order);
    }

    /**
     * 运输单（司机确认接单）
     * @param order
     * @return
     * @throws Exception
     */
    @Override
    public int confirmTransportOrder(TransportOrder order) throws Exception {
        return mapper.confirmTransportOrder(order);
    }

}