package com.yulintu.fadada.demo.models;

import lombok.Data;

/**
 * 备注区控件属性参数
 */
@Data
public class FieldRemarkSign {
    /**
     * 备注区内的默认值，如传该值则不展示提示语。
     */
    private String defaultValue;

    /**
     * 备注区内的提示语。
     */
    private String tips;

    /**
     * 备注区内默认值是否可以修改，默认为true
     * false：不可修改，如传false则defaultValue不能为空
     * true：可以修改
     */
    private Boolean editable = true;

    /**
     * 备注区的宽度，单位px，默认160
     * 注意：未避免备注区控件大小超出文档范围，请根据文档尺寸设置合适的宽度。
     */
    private Integer width;

    /**
     * 备注区的高度，单位px，默认64
     * 注意：未避免备注区控件大小超出文档范围，请根据文档尺寸设置合适的宽度。
     */
    private Integer height;

    /**
     * 备注区内容字体，默认楷体，可选值：
     * kaiti：楷体
     * songti：宋体
     * fangsong：仿宋
     * heiti：黑体
     * arial：Arial
     */
    private String fontType;

    /**
     * 备注区的字号，单位px，默认16
     * 可设置范围不能小于6，不能大于28
     */
    private Integer fontSize;
}

