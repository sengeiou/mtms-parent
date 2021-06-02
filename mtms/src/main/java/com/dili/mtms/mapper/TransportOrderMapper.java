package com.dili.mtms.mapper;

import com.dili.mtms.domain.TransportOrder;
import com.dili.mtms.dto.TransportOrderQuey;
import com.dili.ss.base.MyMapper;

import java.util.List;

public interface TransportOrderMapper extends MyMapper<TransportOrder> {

    List<TransportOrderQuey> listByQueryParams(TransportOrderQuey quey);
}