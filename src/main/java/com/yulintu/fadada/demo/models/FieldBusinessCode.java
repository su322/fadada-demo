package com.yulintu.fadada.demo.models;

import lombok.Data;

/**
 * 业务编号控件属性参数
 */
@Data
public class FieldBusinessCode {
    /**
     * 业务编号宽度，单位px，默认160。为避免文本框宽度超过文档底稿宽度，请合理设置该值。
     */
    private Integer width;

    /**
     * 业务编号高度，单位px，默认50。为避免文本框高度超过文档底稿高度，请合理设置该值。
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
