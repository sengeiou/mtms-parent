package com.dili.mtms.controller;

import com.dili.mtms.domain.Address;
import com.dili.mtms.service.AddressService;
import com.dili.ss.domain.BaseOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2021-05-20 17:20:00.
 */
@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    /**
     * 分页查询Address，返回easyui分页信息
     * @param address
     * @return String
     * @throws Exception
     */
    @PostMapping(value="/listPage.action")
    public @ResponseBody BaseOutput listPage(Address address) throws Exception {
        //addressService.queryListPage(address);

        return BaseOutput.success("新增成功");
    }

    /**
     * 新增Address
     * @param address
     * @return BaseOutput
     */
    @PostMapping(value="/insert.action")
    public @ResponseBody BaseOutput insert(Address address) {
        addressService.insertSelective(address);
        return BaseOutput.success("新增成功");
    }

    /**
     * 修改Address
     * @param address
     * @return BaseOutput
     */
    @PostMapping(value="/update.action")
    public @ResponseBody BaseOutput update(Address address) {
        addressService.updateSelective(address);
        return BaseOutput.success("修改成功");
    }

    /**
     * 删除Address
     * @param id
     * @return BaseOutput
     */
    @PostMapping(value="/delete.action")
    public @ResponseBody BaseOutput delete(Long id) {
        addressService.delete(id);
        return BaseOutput.success("删除成功");
    }
}