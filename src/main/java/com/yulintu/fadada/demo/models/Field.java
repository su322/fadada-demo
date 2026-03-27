package com.yulintu.fadada.demo.models;

import lombok.Data;

import java.text.FieldPosition;

/**
 * 文档控件。控件有很多种，每种控件都有可能有独特的属性字段，因此这是一个容器对象结构，其中可选地包含不同的控件属性子对象。虽然这种表达方法比较不好看，但可扩展。
 */
@Data
public class Field {
    /**
     * 控件编码。由接入方自定义传入，在一个文档范围内指定的唯一控件标识，一个文档中的所有类型的控件的编码不可重复，长度最大32个字符。
     */
    private String fieldId;

    /**
     * 控件名称。名称只是为了方便辨识，在一个文档中，多个控件可以有相同的名称，长度最大32个字符。
     */
    private String fieldName;

    /**
     * 控件标识，在一个文档中，多个控件可以有相同的标识，长度最大32个字符
     */
    private String fieldKey;

    /**
     * 控件定位。
     */
    private FieldPosition position;

    /**
     * 参与方签署时控件是否可拖动控件位置，默认false。注：仅对签章控件有效。
     */
    private Boolean moveable;

    /**
     * 控件类型。目前主要有二类控件：
     * 1)签章控件：
     * person_sign: 个人签名
     * corp_seal: 企业印章
     * corp_seal_cross_page：企业骑缝章
     * date_sign: 日期戳
     * remark_sign：备注区
     * 2)填写控件：
     * text_single_line: 单行文本
     * text_multi_line: 多行文本
     * number：数字控件
     * id_card：身份证号控件
     * fill_date：填写日期控件
     * multi_radio：单选框-多项控件
     * multi_checkbox：复选框-多项控件
     * picture：图片
     * select_box: 下拉选择项
     * table：表格
     * verification_code：核验码
     * business_code：业务编号
     */
    private String fieldType;

    /**
     * 个人签名属性参数。
     */
    private FieldPersonSign fieldPersonSign;

    /**
     * 企业印章属性参数。
     */
    private FieldCorpSeal fieldCorpSeal;

    /**
     * 签署日期属性参数。
     */
    private FieldDateSign fieldDateSign;

    /**
     * 备注区属性参数。
     */
    private FieldRemarkSign fieldRemarkSign;

    /**
     * 企业骑缝章控件属性参数。
     */
    private FieldCorpSealCross fieldCorpSealCross;

    /**
     * 单行文本控件属性参数。
     */
    private FieldTextSingleLine fieldTextSingleLine;

    /**
     * 多行文本控件属性参数。
     */
    private FieldTextMultiLine fieldTextMultiLine;

    /**
     * 数字控件属性参数。
     */
    private FieldNumber fieldNumber;

    /**
     * 身份证控件属性参数。
     */
    private FieldIdCard fieldIdCard;

    /**
     * 填写日期控件属性参数。
     */
    private FieldFillDate fieldFillDate;

    /**
     * 单选框-多项控件属性参数。
     * 注：不支持接口添加，可通过【签署编辑EUI】页面添加
     */
    private FieldMultiRadio fieldMultiRadio;

    /**
     * 复选框-多项控件属性参数。
     * 注：不支持接口添加，可通过【签署编辑EUI】页面添加
     */
    private FieldMultiCheckbox fieldMultiCheckbox;

    /**
     * 图片控件属性参数。
     */
    private FieldPicture fieldPicture;

    /**
     * 下拉选择控件属性参数。
     */
    private FieldSelectBox fieldSelectBox;

    /**
     * 表格控件属性参数。
     */
    private FieldTable fieldTable;

    /**
     * 核验码控件属性参数
     */
    private FieldVerificationCode fieldVerificationCode;

    /**
     * 业务编号控件属性参数
     */
    private FieldBusinessCode fieldBusinessCode;
}
