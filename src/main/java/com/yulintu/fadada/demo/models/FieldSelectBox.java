package com.yulintu.fadada.demo.models;

import lombok.Data;

/**
 * 下拉选择控件属性参数
 */
@Data
public class FieldSelectBox {
    /**
     * 是否必须：false/true，默认为true。
     */
    private Boolean required = true;

    /**
     * 选项，[“选项一”,“选项二”]
     */
    private String[] option;

    /**
     * 指定默认值，下拉选项的选项值，如：选项一 。
     */
    private String defaultValue;

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

