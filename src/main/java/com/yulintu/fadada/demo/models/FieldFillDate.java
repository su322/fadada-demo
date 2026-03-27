package com.yulintu.fadada.demo.models;

import lombok.Data;

/**
 * 填写日期控件属性参数
 */
@Data
public class FieldFillDate {
    /**
     * 是否必须：false/true，默认为true。
     */
    private Boolean required = true;

    /**
     * 指定默认值。该默认值会直接显示在控件中。
     */
    private String defaultValue;

    /**
     * 日期格式，默认YYYY年MM月DD日。
     * YYYY年MM月DD日
     * YYYY-MM-DD
     * YYYY/MM/DD
     */
    private String dateFormat;

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

