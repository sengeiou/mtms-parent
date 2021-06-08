package com.dili.mtms.api;

import com.dili.mtms.common.CfgContent;
import com.dili.mtms.domain.Address;
import com.dili.mtms.service.AddressService;
import com.dili.ss.domain.BaseOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 地址管理
 */
@RestController
@RequestMapping("/api/address")
@Slf4j
public class AddressApi {
    @Autowired
    AddressService addressService;


    /**
     * 分页查询Address
     * @param address
     * @return String
     * @throws Exception
     */
    @PostMapping(value="/listPage")
    public @ResponseBody BaseOutput listPage(Address address) throws Exception {
        List list = null;
        try {
            list = addressService.listEasyuiPageByExample(address, true).getRows();
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return BaseOutput.failure(CfgContent.SYSTEM_EXCEPTION);
        }
        return BaseOutput.success("查询成功").setData(list);
    }

    /**
     * 新增Address
     * @param address
     * @return BaseOutput
     */
    @PostMapping(value="/insert")
    public @ResponseBody BaseOutput insert(Address address) {
        try {
            addressService.insertSelective(address);
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return BaseOutput.failure(CfgContent.SYSTEM_EXCEPTION);
        }
        return BaseOutput.success("新增成功");
    }

    /**
     * 修改Address
     * @param address
     * @return BaseOutput
     */
    @PostMapping(value="/update")
    public @ResponseBody BaseOutput update(Address address) {
        try {
            addressService.updateSelective(address);
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return BaseOutput.failure(CfgContent.SYSTEM_EXCEPTION);
        }
        return BaseOutput.success("修改成功");
    }

    /**
     * 删除Address
     * @param address
     * @return BaseOutput
     */
    @PostMapping(value="/delete")
    public @ResponseBody BaseOutput delete(Address address) {
        try {
            addressService.delete(address.getId());
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return BaseOutput.failure(CfgContent.SYSTEM_EXCEPTION);
        }
        return BaseOutput.success("删除成功");
    }
}