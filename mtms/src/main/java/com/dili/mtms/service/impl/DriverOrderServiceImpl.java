package com.dili.mtms.service.impl;


import com.dili.mtms.dto.BaseData;
import com.dili.mtms.dto.DriverOrderQuey;
import com.dili.mtms.dto.TransportOrderQuey;
import com.dili.mtms.mapper.LoadingOrderMapper;
import com.dili.mtms.mapper.TransportOrderMapper;
import com.dili.mtms.service.DriverOrderService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 司机端service
 */
@Service
public class DriverOrderServiceImpl implements DriverOrderService {

    @Autowired
    private LoadingOrderMapper loadingOrderMapper;

    @Autowired
    private TransportOrderMapper mapper;

    /**
     * 司机端列表
     * @param driver
     * @return
     * @throws Exception
     */
    @Override
    public BaseData driverList(DriverOrderQuey driver) throws Exception {
        //分页处理
        /*int page = driver.getPage()==null ? 1 : driver.getPage();
        int rows = driver.getRows()==null ? 10 : driver.getRows();
        PageHelper.startPage(page, rows);
        List<TransportOrderQuey> list = mapper.transportList(driver);
        //数据封装
        int totalPage = list instanceof Page ? ((Page) list).getPages() : 1;
        BaseData baseData = new BaseData();
        baseData.setTotal(totalPage);
        baseData.setRows(list);*/

        return null;
    }

    /**
     * 司机端详情
     * @param driver
     * @return
     * @throws Exception
     */
    @Override
    public Object driverDetail(DriverOrderQuey driver) throws Exception {

        if(driver.getOrderType() == 1){//运输单详情
            return mapper.transportDetail(driver.getId());
        }else if(driver.getOrderType() == 2){//装卸单详情
            return loadingOrderMapper.loadingDetail(driver.getId());
        }else {

        }
        return null;
    }
}