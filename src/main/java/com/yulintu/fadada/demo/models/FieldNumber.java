package com.yulintu.fadada.demo.models;

import lombok.Data;

/**
 * 数字控件属性参数
 */
@Data
public class FieldNumber {
    /**
     * 是否必须：false/true，默认为true。
     */
    private Boolean required = true;

    /**
     * 指定默认值。该默认值会直接显示在控件中。长度最大26（包含小数点和数字），其中小数点后最大10位
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

