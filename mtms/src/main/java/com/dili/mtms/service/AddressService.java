package com.dili.mtms.service;

import com.dili.mtms.common.BaseData;
import com.dili.mtms.domain.Address;
import com.dili.ss.base.BaseService;

import java.util.List;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2021-05-20 17:20:00.
 */
public interface AddressService extends BaseService<Address, Long> {
    /**
     * 新增地址
     * @param address
     * @return
     */
    int insertAddress(Address address) throws Exception;

    /**
     * 默认地址唯一
     * @param address
     * @throws Exception
     */
    void updateIsdefaultAddress(Address address)throws Exception;

    /**
     * 获取客户的默认地址
     * @param address
     * @return
     * @throws Exception
     */
    Address getDefaultAddress(Address address)throws Exception;

    /**
     * 获取地址list
     * @param address
     * @return
     */
    BaseData listAddress(Address address)throws Exception;

    /**
     * 根据id获取地址信息
     * @param shipperAddressId
     * @param deliveryAddressId
     * @return
     * @throws Exception
     */
    List<Address> getAdressInfo(Long shipperAddressId, Long deliveryAddressId)throws Exception;
}