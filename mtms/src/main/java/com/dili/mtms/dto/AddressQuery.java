package com.dili.mtms.dto;

import com.dili.mtms.domain.Address;
import com.dili.ss.processor.annotation.GenDTOMethod;
import java.util.Date;
import javax.persistence.Table;

/**
 *   @author: WM
 *   @time: 2021/5/20 17:17
 */
public interface AddressQuery extends Address {
  Date getCreateTimeStart();

  void setCreateTimeStart(Date createTimeStart);

  Date getCreateTimeEnd();

  void setCreateTimeEnd(Date createTimeEnd);
}
