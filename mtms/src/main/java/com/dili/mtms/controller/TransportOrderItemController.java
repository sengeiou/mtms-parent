package com.dili.mtms.controller;

import com.dili.mtms.domain.TransportOrderItem;
import com.dili.mtms.service.TransportOrderItemService;
import com.dili.ss.domain.BaseOutput;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2021-05-20 17:20:00.
 */
@RestController
@RequestMapping("/transportOrderItem")
public class TransportOrderItemController {
    @Autowired
    TransportOrderItemService transportOrderItemService;

    /**
     * 分页查询TransportOrderItem，返回easyui分页信息
     * @param transportOrderItem
     * @return String
     * @throws Exception
     */
    @RequestMapping(value="/listPage.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody String listPage(TransportOrderItem transportOrderItem) throws Exception {
        return transportOrderItemService.listEasyuiPageByExample(transportOrderItem, true).toString();
    }

    /**
     * 新增TransportOrderItem
     * @param transportOrderItem
     * @return BaseOutput
     */
    @RequestMapping(value="/insert.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput insert(TransportOrderItem transportOrderItem) {
        transportOrderItemService.insertSelective(transportOrderItem);
        return BaseOutput.success("新增成功");
    }

    /**
     * 修改TransportOrderItem
     * @param transportOrderItem
     * @return BaseOutput
     */
    @RequestMapping(value="/update.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput update(TransportOrderItem transportOrderItem) {
        transportOrderItemService.updateSelective(transportOrderItem);
        return BaseOutput.success("修改成功");
    }

    /**
     * 删除TransportOrderItem
     * @param id
     * @return BaseOutput
     */
    @RequestMapping(value="/delete.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput delete(Long id) {
        transportOrderItemService.delete(id);
        return BaseOutput.success("删除成功");
    }
}