package com.yulintu.fadada.demo.models;

import lombok.Data;

/**
 * 个人签名控件属性参数
 */
@Data
public class FieldPersonSign {
    /**
     * 是否以参与方印章尺寸加盖，默认true
     * true：是，会忽略设置的width和height
     * false：否，以设置的width和height，如未传则按默认尺寸
     */
    private Boolean followSignSize = true;

    /**
     * 签名控��的宽度，单位px，默认171，不能大于229小于38
     */
    private Integer width;

    /**
     * 签名控件的高度，单位px，默认92，不能大于229小于38
     */
    private Integer height;
}

