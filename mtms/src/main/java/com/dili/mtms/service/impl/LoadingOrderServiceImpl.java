package com.dili.mtms.service.impl;

import com.dili.mtms.domain.LoadingOrder;
import com.dili.mtms.mapper.LoadingOrderMapper;
import com.dili.mtms.service.LoadingOrderService;
import com.dili.ss.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2021-05-20 17:20:00.
 */
@Service
public class LoadingOrderServiceImpl extends BaseServiceImpl<LoadingOrder, Long> implements LoadingOrderService {

    public LoadingOrderMapper getActualDao() {
        return (LoadingOrderMapper)getDao();
    }
}