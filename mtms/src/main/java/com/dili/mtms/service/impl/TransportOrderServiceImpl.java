package com.dili.mtms.service.impl;

import com.dili.mtms.domain.TransportOrder;
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
    public PageOutput<List<TransportOrderQuey>> listByQueryParams(TransportOrderQuey quey) throws Exception{
        //设置查询时间
        /*quey.setOrderStarTime(DateTimeUtil.startTimeConversion(quey.getOrderTime().split("-")[0]));
        quey.setOrderEndTime(DateTimeUtil.endTimeConversion(quey.getOrderTime().split("-")[1]));
        quey.setServiceStarTime(DateTimeUtil.startTimeConversion(quey.getServeTime().split("-")[0]));
        quey.setServiceEndTime(DateTimeUtil.startTimeConversion(quey.getServeTime().split("-")[1]));*/
        //查询数据
        PageHelper.startPage(1, 10);
        List<TransportOrderQuey> list = mapper.listByQueryParams(quey);
        Long total = list instanceof Page ? ((Page) list).getTotal() : list.size();
        PageOutput<List<TransportOrderQuey>> output = PageOutput.success();
        output.setData(list).setTotal(total);
        return output;
    }
}