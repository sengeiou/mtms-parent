package com.dili.mtms.api;

import com.dili.mtms.domain.Address;
import com.dili.mtms.service.AddressService;
import com.dili.ss.domain.BaseOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2021-05-20 17:20:00.
 */
@RestController
@RequestMapping("/api/address")
public class AddressApi {
    @Autowired
    AddressService addressService;


    /**
     * 分页查询Address，返回easyui分页信息
     * @param address
     * @return String
     * @throws Exception
     */
    @PostMapping(value="/listPage.action")
    public @ResponseBody String listPage(Address address) throws Exception {
        return addressService.listEasyuiPageByExample(address, true).toString();
    }

    /**
     * 新增Address
     * @param address
     * @return BaseOutput
     */
    @RequestMapping(value="/insert.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput insert(Address address) {
        addressService.insertSelective(address);
        return BaseOutput.success("新增成功");
    }

    /**
     * 修改Address
     * @param address
     * @return BaseOutput
     */
    @RequestMapping(value="/update.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput update(Address address) {
        addressService.updateSelective(address);
        return BaseOutput.success("修改成功");
    }

    /**
     * 删除Address
     * @param id
     * @return BaseOutput
     */
    @RequestMapping(value="/delete.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput delete(Long id) {
        addressService.delete(id);
        return BaseOutput.success("删除成功");
    }
}