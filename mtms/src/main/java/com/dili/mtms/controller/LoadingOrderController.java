package com.dili.mtms.controller;

import com.dili.mtms.domain.LoadingOrder;
import com.dili.mtms.dto.BaseData;
import com.dili.mtms.dto.CfgContent;
import com.dili.mtms.dto.LoadingOrderQuey;
import com.dili.mtms.dto.TransportOrderQuey;
import com.dili.mtms.service.LoadingOrderService;
import com.dili.mtms.utils.DateTimeUtil;
import com.dili.ss.domain.BaseOutput;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2021-05-20 17:20:00.
 */
@RestController
@RequestMapping("/loadingOrder")
@Slf4j
public class LoadingOrderController {
    @Autowired
    LoadingOrderService loadingOrderService;

    /**
     * pc 装卸 列表
     * @param quey
     * @return
     */
    @PostMapping(value="/listPage.action")
    public @ResponseBody BaseOutput listByQueryParams(LoadingOrderQuey quey){
        BaseData data = null;
        try {
            //参数组装校验
            LoadingOrderQuey checkQuey = assemblyParam(quey);
            data = loadingOrderService.listByQueryParams(checkQuey);
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return BaseOutput.failure();
        }
        return BaseOutput.success().setData(data);
    }

    /**
     * 修改LoadingOrder
     * @param loadingOrder
     * @return BaseOutput
     */
    @RequestMapping(value="/update.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput update(LoadingOrder loadingOrder) {
        loadingOrderService.updateSelective(loadingOrder);
        return BaseOutput.success("修改成功");
    }

    /**
     * 组装查询参数
     * @param quey
     * @return
     */
    public static LoadingOrderQuey assemblyParam(LoadingOrderQuey quey) throws Exception{

        //查询时间校验
        if(StringUtils.isNotBlank(quey.getOrderTime())){
            quey.setOrderStartTime(DateTimeUtil.startTimeConversion(quey.getOrderTime()));
            quey.setOrderEndTime(DateTimeUtil.endTimeConversion(quey.getOrderTime()));
        }
        if(StringUtils.isNotBlank(quey.getServeTime())){
            quey.setServiceStartTime(DateTimeUtil.startTimeConversion(quey.getServeTime()));
            quey.setServiceEndTime(DateTimeUtil.endTimeConversion(quey.getServeTime()));
        }

        if(StringUtils.isNotBlank(quey.getKeyvalue()) && StringUtils.isNotBlank(quey.getKeyword())){
            switch (quey.getKeyword()){
                case CfgContent.CODE:
                    quey.setCode(quey.getKeyvalue());
                    break;
                case CfgContent.SHIPPER_NAME:
                    quey.setShipperName(quey.getKeyvalue());
                    break;
                case CfgContent.SHIPPER_CELLPHONE:
                    quey.setShipperCellphone(quey.getKeyvalue());
                    break;
                default:
                    return quey;
            }
        }
        return quey;
    }

}