package com.dili.mtms.api;

import com.dili.mtms.common.BaseData;
import com.dili.mtms.common.CfgContent;
import com.dili.mtms.domain.Address;
import com.dili.mtms.service.AddressService;
import com.dili.ss.constant.ResultCode;
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
    public @ResponseBody BaseOutput listPage(Address address) {
        BaseData data = null;
        //参数验证
        if(address.getFirmId() == null || address.getCustomerId() == null){
            return BaseOutput.create(ResultCode.DATA_ERROR,CfgContent.LACK_PARAM);
        }

        try {
            data = addressService.listAddress(address);
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return BaseOutput.failure(CfgContent.SYSTEM_EXCEPTION);
        }
        return BaseOutput.success().setData(data);
    }

    /**
     * 新增Address
     * @param address
     * @return BaseOutput
     */
    @PostMapping(value="/insert")
    public @ResponseBody BaseOutput insert(Address address) {
        //参数验证
        if(address.getFirmId() == null || address.getCustomerId() == null){
            return BaseOutput.create(ResultCode.DATA_ERROR,CfgContent.LACK_PARAM);
        }

        try {
            int i = addressService.insertAddress(address);
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return BaseOutput.failure(CfgContent.SYSTEM_EXCEPTION);
        }
        return BaseOutput.success();
    }

    /**
     * 修改Address
     * @param address
     * @return BaseOutput
     */
    @PostMapping(value="/update")
    public @ResponseBody BaseOutput update(Address address) {
        //参数验证
        if(address.getId() == null){
            return BaseOutput.create(ResultCode.DATA_ERROR,CfgContent.LACK_PARAM);
        }

        try {
            //修改地址
            int i = addressService.updateSelective(address);
            //默认地址唯一
            if(i>0 && address.getIsDefault() != null && address.getCustomerId() != null){
                    addressService.updateIsdefaultAddress(address);
            }
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return BaseOutput.failure(CfgContent.SYSTEM_EXCEPTION);
        }
        return BaseOutput.success();
    }

    /**
     * 删除Address
     * @param address
     * @return BaseOutput
     */
    @PostMapping(value="/delete")
    public @ResponseBody BaseOutput delete(Address address) {
        //参数验证
        if(address.getId() == null){
            return BaseOutput.create(ResultCode.DATA_ERROR,CfgContent.LACK_PARAM);
        }

        try {
            int i = addressService.delete(address.getId());
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return BaseOutput.failure(CfgContent.SYSTEM_EXCEPTION);
        }
        return BaseOutput.success("删除成功");
    }

    /**
     * 获取默认地址
     * @param address
     * @return
     */
    @PostMapping(value="/getDefaultAddress")
    public @ResponseBody BaseOutput getDefaultAddress(Address address) {
        Address retrun_address = null;
        //参数验证
        if(address.getFirmId() == null || address.getCustomerId() == null){
            return BaseOutput.create(ResultCode.DATA_ERROR,CfgContent.LACK_PARAM);
        }

        try {
            retrun_address = addressService.getDefaultAddress(address);
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return BaseOutput.failure(CfgContent.SYSTEM_EXCEPTION);
        }
        return BaseOutput.success().setData(retrun_address);
    }
}