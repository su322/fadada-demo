package com.yulintu.fadada.demo.models;

import lombok.Data;

/**
 * 核验码控件属性参数
 */
@Data
public class FieldVerificationCode {
    /**
     * 核验码控件的矩形边长，单位px，默认120，不能大于500小于100
     */
    private Integer size;
}

