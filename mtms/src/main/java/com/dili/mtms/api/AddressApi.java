package com.dili.mtms.api;

import com.dili.mtms.domain.Address;
import com.dili.mtms.service.AddressService;
import com.dili.ss.domain.BaseOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 地址管理
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
    public @ResponseBody BaseOutput listPage(Address address) throws Exception {
        List list = null;
        try {
            list = addressService.listEasyuiPageByExample(address, true).getRows();
        }catch (Exception e){
            return BaseOutput.failure();
        }
        return BaseOutput.success("查询成功").setData(list);
    }

    /**
     * 新增Address
     * @param address
     * @return BaseOutput
     */
    @PostMapping(value="/insert.action")
    public @ResponseBody BaseOutput insert(Address address) {
        try {
            addressService.insertSelective(address);
        }catch (Exception e){
            return BaseOutput.failure();
        }
        return BaseOutput.success("新增成功");
    }

    /**
     * 修改Address
     * @param address
     * @return BaseOutput
     */
    @PostMapping(value="/update.action")
    public @ResponseBody BaseOutput update(Address address) {
        try {
            addressService.updateSelective(address);

        }catch (Exception e){
            return BaseOutput.failure();
        }
        return BaseOutput.success("修改成功");
    }

    /**
     * 删除Address
     * @param id
     * @return BaseOutput
     */
    @PostMapping(value="/delete.action")
    public @ResponseBody BaseOutput delete(Long id) {
        try {
            addressService.delete(id);
        }catch (Exception e){
            return BaseOutput.failure();
        }
        return BaseOutput.success("删除成功");
    }
}