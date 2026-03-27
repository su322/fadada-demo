package com.yulintu.fadada.demo.models;

import lombok.Data;

/**
 * 单选框-多项控件属性参数
 */
@Data
public class FieldMultiRadio {
    /**
     * 是否必须：false/true，默认为true。
     */
    private Boolean required = true;

    /**
     * 选项内容，如["选项一","选项二"]。该控件不支持接口新增，仅在查询模板详情时返回。
     */
    private String option;

    /**
     * 指定默认值。false表示未选中，true表示选中，默认为全部未选中，如设置值需存在一个true，如 [true,false,false,false] 。
     */
    private boolean[] defaultValue;
}

