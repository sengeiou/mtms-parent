package com.dili.mtms.controller;

import bsh.StringUtil;
import com.dili.mtms.domain.TransportOrder;
import com.dili.mtms.dto.BaseData;
import com.dili.mtms.dto.CfgContent;
import com.dili.mtms.dto.TransportOrderQuey;
import com.dili.mtms.service.TransportOrderService;
import com.dili.mtms.utils.DateTimeUtil;
import com.dili.ss.domain.BaseOutput;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2021-05-20 17:20:00.
 */
@RestController
@RequestMapping("/api/transportOrder")
@Slf4j
public class TransportOrderController {
    @Autowired
    TransportOrderService transportOrderService;

    /**
     * 运输单列表
     * @param quey
     * @return
     * @throws Exception
     */
    @PostMapping(value="/listPage")
    public @ResponseBody BaseOutput listByQueryParams(TransportOrderQuey quey) {
        BaseData data = null;
        try {
            //参数组装校验
            TransportOrderQuey checkQuey = assemblyParam(quey);
            data = transportOrderService.listByQueryParams(checkQuey);
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return BaseOutput.failure();
        }
        return BaseOutput.success().setData(data);
    }

    /**
     * 组装查询参数
     * @param quey
     * @return
     */
    public static TransportOrderQuey assemblyParam(TransportOrderQuey quey) throws Exception{

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