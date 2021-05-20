package com.dili.mtms.domain;

import com.dili.ss.dto.IBaseDomain;
import com.dili.ss.metadata.FieldEditor;
import com.dili.ss.metadata.annotation.EditMode;
import com.dili.ss.metadata.annotation.FieldDef;
import java.util.Date;
import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 由MyBatis Generator工具自动生成
 * 装卸单项
 * This file was generated on 2021-05-20 17:20:00.
 */
@Table(name = "`loading_order_item`")
public interface LoadingOrderItem extends IBaseDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`")
    @FieldDef(label="主键")
    @EditMode(editor = FieldEditor.Number, required = true)
    Long getId();

    void setId(Long id);

    @Column(name = "`loading_order_id`")
    @FieldDef(label="装卸单id")
    @EditMode(editor = FieldEditor.Number, required = false)
    Long getLoadingOrderId();

    void setLoadingOrderId(Long loadingOrderId);

    @Column(name = "`goods_name`")
    @FieldDef(label="货物名", maxLength = 40)
    @EditMode(editor = FieldEditor.Text, required = false)
    String getGoodsName();

    void setGoodsName(String goodsName);

    @Column(name = "`weight_type`")
    @FieldDef(label="计量方式(计件和计重)")
    @EditMode(editor = FieldEditor.Text, required = false)
    Byte getWeightType();

    void setWeightType(Byte weightType);

    @Column(name = "`number`")
    @FieldDef(label="件数")
    @EditMode(editor = FieldEditor.Number, required = false)
    Integer getNumber();

    void setNumber(Integer number);

    @Column(name = "`unit_weight`")
    @FieldDef(label="件重(包括一位小数)")
    @EditMode(editor = FieldEditor.Number, required = false)
    Integer getUnitWeight();

    void setUnitWeight(Integer unitWeight);

    @Column(name = "`total_weight`")
    @FieldDef(label="总重(包括一位小数)")
    @EditMode(editor = FieldEditor.Number, required = false)
    Integer getTotalWeight();

    void setTotalWeight(Integer totalWeight);

    @Column(name = "`create_time`")
    @FieldDef(label="创建时间")
    @EditMode(editor = FieldEditor.Datetime, required = false)
    Date getCreateTime();

    void setCreateTime(Date createTime);
}