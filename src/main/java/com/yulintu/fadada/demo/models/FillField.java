package com.yulintu.fadada.demo.models;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 该节点下的填写控件，该节点下任意一个参与方可填写
 */
@Data
public class FillField {
    /**
     * 控件所在的文档标识。文档标识必须在文档列表中存在
     */
    @NotBlank(message = "fieldDocId 不能为空")
    private String fieldDocId;

    /**
     * 控件编码。长度最大 32 个字符。控件编码必须在文档控件列表中存在
     */
    private String fieldId;

    /**
     * 控件名称
     * 1、如果提供了 fieldId 参数，则 fieldName 参数会被忽略
     * 2、fieldId 和 fieldName 不能同时为空
     * 3、因控件名称可重复，指定该值时，文档中所有相同名称的填写控件都会绑定在该节点下
     */
    private String fieldName;

    /**
     * 控件缺省填充值。该值将会展示给该参与方，但该参与方可修改和确认，用于业务预先知道应填内容，但需要参与方确认的场景。
     * 注：填充控件的值格式与控件类型相关
     */
    private String fieldValue;
}
