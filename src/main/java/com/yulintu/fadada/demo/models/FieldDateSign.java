package com.yulintu.fadada.demo.models;

import lombok.Data;

/**
 * 签署日期控件属性参数
 */
@Data
public class FieldDateSign {
    /**
     * 日期格式，默认YYYY年MM月DD日。
     * YYYY年MM月DD日
     * YYYY-MM-DD
     * YYYY/MM/DD
     */
    private String dateFormat;

    /**
     * 字号：单位px，默认16，范围12-21。
     */
    private Integer fontSize;
}

