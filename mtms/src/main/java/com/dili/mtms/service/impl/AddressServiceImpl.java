package com.dili.mtms.service.impl;

import com.dili.mtms.domain.Address;
import com.dili.mtms.mapper.AddressMapper;
import com.dili.mtms.service.AddressService;
import com.dili.ss.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2021-05-20 17:08:49.
 */
@Service
public class AddressServiceImpl extends BaseServiceImpl<Address, Long> implements AddressService {

    public AddressMapper getActualDao() {
        return (AddressMapper)getDao();
    }
}