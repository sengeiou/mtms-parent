package com.dili.mtms.controller;

import com.dili.mtms.domain.TransportOrder;
import com.dili.mtms.service.TransportOrderService;
import com.dili.ss.domain.BaseOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2021-05-20 17:20:00.
 */
@RestController
@RequestMapping("/transportOrder")
public class TransportOrderController {
    @Autowired
    TransportOrderService transportOrderService;

    /**
     * 分页查询TransportOrder，返回easyui分页信息
     * @param transportOrder
     * @return String
     * @throws Exception
     */
    @RequestMapping(value="/listPage.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody String listPage(TransportOrder transportOrder) throws Exception {
        return transportOrderService.listEasyuiPageByExample(transportOrder, true).toString();
    }

    /**
     * 新增TransportOrder
     * @param transportOrder
     * @return BaseOutput
     */
    @RequestMapping(value="/insert.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput insert(TransportOrder transportOrder) {
        transportOrderService.insertSelective(transportOrder);
        return BaseOutput.success("新增成功");
    }

    /**
     * 修改TransportOrder
     * @param transportOrder
     * @return BaseOutput
     */
    @RequestMapping(value="/update.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput update(TransportOrder transportOrder) {
        transportOrderService.updateSelective(transportOrder);
        return BaseOutput.success("修改成功");
    }

    /**
     * 删除TransportOrder
     * @param id
     * @return BaseOutput
     */
    @RequestMapping(value="/delete.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput delete(Long id) {
        transportOrderService.delete(id);
        return BaseOutput.success("删除成功");
    }
}