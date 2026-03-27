package com.yulintu.fadada.demo.models;

import lombok.Data;

/**
 * 单行文本控件属性参数
 */
@Data
public class FieldTextSingleLine {
    /**
     * 是否必须：false/true，默认为true。
     */
    private Boolean required = true;

    /**
     * 指定默认值。该默认值会直接显示在控件中。
     */
    private String defaultValue;

    /**
     * 是否自动获取个人/企业参与方的信息，参与方无法修改，默认false
     * true：自动获取
     * false：不自动获取
     * 注：仅defaultValue不指定默认值时该设置有效
     */
    private Boolean autofill = false;

    /**
     * 自动获取的内容，仅autofill为true时有效，默认个人姓名
     * userName：个人姓名，如为企业参与方则表示经办人姓名
     * userIdentNo：个人证件号，如为企业参与方则表示经办人证件号
     * corpName：企业名称
     * corpIdentNo：企业统一社会信用代码或各种类型组织的唯一代码
     */
    private String autofillInfo;

    /**
     * 提示语。限制50个字符。
     */
    private String tips;

    /**
     * 文本框宽度，单位px，默认160。为避免文本框宽度超过文档底稿宽度，请合理设置该值。
     */
    private Integer width;

    /**
     * 文本框高度，单位px，默认30。为避免文本框高度超过文档底稿高度，请合理设置该值。
     */
    private Integer height;

    /**
     * 字体类型，默认楷体。
     * songti
     * fangsong
     * heiti
     * kaiti
     * arial
     */
    private String fontType;

    /**
     * 字号：单位px，默认16。输入值不能小于6，不能大于28。
     */
    private Integer fontSize;

    /**
     * 对齐类型，默认左对齐。
     * left
     * center
     * right
     */
    private String alignment;
}

