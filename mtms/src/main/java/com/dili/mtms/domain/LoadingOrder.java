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
 * 装卸单
 * This file was generated on 2021-05-20 17:20:00.
 */
@Table(name = "`loading_order`")
public interface LoadingOrder extends IBaseDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`")
    @FieldDef(label="主键")
    @EditMode(editor = FieldEditor.Number, required = true)
    Long getId();

    void setId(Long id);

    @Column(name = "`code`")
    @FieldDef(label="订单号", maxLength = 20)
    @EditMode(editor = FieldEditor.Text, required = false)
    String getCode();

    void setCode(String code);

    @Column(name = "`shipper_id`")
    @FieldDef(label="发货人")
    @EditMode(editor = FieldEditor.Number, required = false)
    Long getShipperId();

    void setShipperId(Long shipperId);

    @Column(name = "`shipper_address_id`")
    @FieldDef(label="发货地址id")
    @EditMode(editor = FieldEditor.Number, required = false)
    Long getShipperAddressId();

    void setShipperAddressId(Long shipperAddressId);

    @Column(name = "`shipper_name`")
    @FieldDef(label="发货人姓名", maxLength = 10)
    @EditMode(editor = FieldEditor.Text, required = false)
    String getShipperName();

    void setShipperName(String shipperName);

    @Column(name = "`shipper_cellphone`")
    @FieldDef(label="发货人手机号", maxLength = 20)
    @EditMode(editor = FieldEditor.Text, required = false)
    String getShipperCellphone();

    void setShipperCellphone(String shipperCellphone);

    @Column(name = "`taker_id`")
    @FieldDef(label="接单人(司机)")
    @EditMode(editor = FieldEditor.Number, required = false)
    Long getTakerId();

    void setTakerId(Long takerId);

    @Column(name = "`taker_name`")
    @FieldDef(label="接单人姓名", maxLength = 20)
    @EditMode(editor = FieldEditor.Text, required = false)
    String getTakerName();

    void setTakerName(String takerName);

    @Column(name = "`taker_cellphone`")
    @FieldDef(label="接单人电话", maxLength = 20)
    @EditMode(editor = FieldEditor.Text, required = false)
    String getTakerCellphone();

    void setTakerCellphone(String takerCellphone);

    @Column(name = "`offer`")
    @FieldDef(label="报价(元)")
    @EditMode(editor = FieldEditor.Number, required = false)
    Long getOffer();

    void setOffer(Long offer);

    @Column(name = "`firm_id`")
    @FieldDef(label="市场id")
    @EditMode(editor = FieldEditor.Number, required = false)
    Long getFirmId();

    void setFirmId(Long firmId);

    @Column(name = "`state`")
    @FieldDef(label="订单状态(已创建、已接单、已完成、已失效、已取消、已关闭)")
    @EditMode(editor = FieldEditor.Text, required = false)
    Byte getState();

    void setState(Byte state);

    @Column(name = "`address`")
    @FieldDef(label="需求地址", maxLength = 60)
    @EditMode(editor = FieldEditor.Text, required = false)
    String getAddress();

    void setAddress(String address);

    @Column(name = "`service_time`")
    @FieldDef(label="服务时间")
    @EditMode(editor = FieldEditor.Datetime, required = false)
    Date getServiceTime();

    void setServiceTime(Date serviceTime);

    @Column(name = "`service_type`")
    @FieldDef(label="服务类型(装货、卸货)")
    @EditMode(editor = FieldEditor.Text, required = false)
    Byte getServiceType();

    void setServiceType(Byte serviceType);

    @Column(name = "`create_time`")
    @FieldDef(label="下单时间")
    @EditMode(editor = FieldEditor.Datetime, required = false)
    Date getCreateTime();

    void setCreateTime(Date createTime);

    @Column(name = "`cancel_time`")
    @FieldDef(label="取消时间")
    @EditMode(editor = FieldEditor.Datetime, required = false)
    Date getCancelTime();

    void setCancelTime(Date cancelTime);

    @Column(name = "`take_time`")
    @FieldDef(label="接单时间")
    @EditMode(editor = FieldEditor.Datetime, required = false)
    Date getTakeTime();

    void setTakeTime(Date takeTime);

    @Column(name = "`invalid_time`")
    @FieldDef(label="失效时间")
    @EditMode(editor = FieldEditor.Datetime, required = false)
    Date getInvalidTime();

    void setInvalidTime(Date invalidTime);

    @Column(name = "`complete_time`")
    @FieldDef(label="完成时间")
    @EditMode(editor = FieldEditor.Datetime, required = false)
    Date getCompleteTime();

    void setCompleteTime(Date completeTime);

    @Column(name = "`close_time`")
    @FieldDef(label="关闭时间")
    @EditMode(editor = FieldEditor.Datetime, required = false)
    Date getCloseTime();

    void setCloseTime(Date closeTime);

    @Column(name = "`notes`")
    @FieldDef(label="备注", maxLength = 120)
    @EditMode(editor = FieldEditor.Text, required = false)
    String getNotes();

    void setNotes(String notes);
}