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
 * 常用地址
 * This file was generated on 2021-05-20 17:20:00.
 */
@Table(name = "`address`")
public interface Address extends IBaseDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`")
    @FieldDef(label="主键")
    @EditMode(editor = FieldEditor.Number, required = true)
    Long getId();

    void setId(Long id);

    @Column(name = "`firm_id`")
    @FieldDef(label="市场id")
    @EditMode(editor = FieldEditor.Number, required = false)
    Long getFirmId();

    void setFirmId(Long firmId);

    @Column(name = "`customer_id`")
    @FieldDef(label="客户id")
    @EditMode(editor = FieldEditor.Number, required = false)
    Long getCustomerId();

    void setCustomerId(Long customerId);

    @Column(name = "`content`")
    @FieldDef(label="地址", maxLength = 120)
    @EditMode(editor = FieldEditor.Text, required = false)
    String getContent();

    void setContent(String content);

    @Column(name = "`contact_name`")
    @FieldDef(label="联系人", maxLength = 10)
    @EditMode(editor = FieldEditor.Text, required = false)
    String getContactName();

    void setContactName(String contactName);

    @Column(name = "`gender`")
    @FieldDef(label="性别")
    @EditMode(editor = FieldEditor.Text, required = false)
    Byte getGender();

    void setGender(Byte gender);

    @Column(name = "`cellphone`")
    @FieldDef(label="电话", maxLength = 20)
    @EditMode(editor = FieldEditor.Text, required = false)
    String getCellphone();

    void setCellphone(String cellphone);

    @Column(name = "`is_default`")
    @FieldDef(label="是否默认")
    @EditMode(editor = FieldEditor.Text, required = false)
    Byte getIsDefault();

    void setIsDefault(Byte isDefault);

    @Column(name = "`city_id`")
    @FieldDef(label="省市区id")
    @EditMode(editor = FieldEditor.Number, required = false)
    Long getCityId();

    void setCityId(Long cityId);

    @Column(name = "`city_name`")
    @FieldDef(label="省市区名称", maxLength = 120)
    @EditMode(editor = FieldEditor.Text, required = false)
    String getCityName();

    void setCityName(String cityName);

    @Column(name = "`create_time`")
    @FieldDef(label="创建时间")
    @EditMode(editor = FieldEditor.Datetime, required = false)
    Date getCreateTime();

    void setCreateTime(Date createTime);
}