package com.dili.mtms.service.impl;

import com.dili.mtms.domain.TransportOrder;
import com.dili.mtms.mapper.TransportOrderMapper;
import com.dili.mtms.service.TransportOrderService;
import com.dili.ss.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2021-05-20 17:20:00.
 */
@Service
public class TransportOrderServiceImpl extends BaseServiceImpl<TransportOrder, Long> implements TransportOrderService {

    public TransportOrderMapper getActualDao() {
        return (TransportOrderMapper)getDao();
    }
}