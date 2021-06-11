package com.dili.mtms.service.impl;

import com.dili.mtms.common.BaseData;
import com.dili.mtms.domain.Address;
import com.dili.mtms.dto.LoadingOrderQuey;
import com.dili.mtms.mapper.AddressMapper;
import com.dili.mtms.service.AddressService;
import com.dili.ss.base.BaseServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2021-05-20 17:20:00.
 */
@Service
public class AddressServiceImpl extends BaseServiceImpl<Address, Long> implements AddressService {

    public AddressMapper getActualDao() {
        return (AddressMapper)getDao();
    }

    @Autowired
    private AddressMapper addressMapper;

    /**
     * 新增地址
     * @param address
     * @return
     * @throws Exception
     */
    @Override
    public int insertAddress(Address address) throws Exception {
         int i = addressMapper.insertAddress(address);
         //默认地址唯一
         if(i>0 && address.getIsDefault() != null && address.getCustomerId() != null){
             addressMapper.updateIsdefaultAddress(address);
         }
        return i;
    }

    /**
     * 默认地址唯一
     * @param address
     * @throws Exception
     */
    @Override
    public void updateIsdefaultAddress(Address address) throws Exception {
        addressMapper.updateIsdefaultAddress(address);
    }

    /**
     * 获取客户的默认地址
     * @param address
     * @return
     * @throws Exception
     */
    @Override
    public Address getDefaultAddress(Address address) throws Exception {
        return addressMapper.getDefaultAddress(address);
    }

    @Override
    public BaseData listAddress(Address address) throws Exception {
        //分页处理
        int page = address.getPage()==null ? 1 : address.getPage();
        int rows = address.getRows()==null ? 10 : address.getRows();
        PageHelper.startPage(page, rows);
        List<Address> list = addressMapper.listAddress(address);
        //数据封装
        int totalPage = list instanceof Page ? ((Page) list).getPages() : 1;
        BaseData baseData = new BaseData();
        baseData.setTotal(totalPage);
        baseData.setRows(list);
        return baseData;
    }

    /**
     * 根据id获取地址信息
     * @param shipperAddressId
     * @param deliveryAddressId
     * @return
     * @throws Exception
     */
    @Override
    public List<Address> getAdressInfo(Long shipperAddressId, Long deliveryAddressId) throws Exception {
        return addressMapper.getAdressInfo(shipperAddressId,deliveryAddressId);
    }
}