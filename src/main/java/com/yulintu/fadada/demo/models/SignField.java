package com.yulintu.fadada.demo.models;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 该节点下的签署控件，该节点下任意参与方可签署
 */
@Data
public class SignField {
    /**
     * 控件所在的文档标识。文档标识必须在文档列表中存在，确定要设置的控件放在哪个文档。
     */
    @NotBlank(message = "fieldDocId 不能为空")
    private String fieldDocId;

    /**
     * 控件编码。长度最大32个字符。控件编码必须在文档控件列表中存在
     */
    private String fieldId;

    /**
     * 控件名称
     * 1、如果提供了fieldId参数，则fieldName参数会被忽略
     * 2、fieldId和fieldName不能同时为空
     * 3、因控件名称可重复，指定该值时，文档中所有相同名称的签署控件都会绑定在该节点下
     */
    private String fieldName;

    /**
     * 印章位置是否可以拖动，默认为false
     */
    private Boolean moveable;

    /**
     * 签章控件状态：
     * stamped：已盖章
     * unstamped：未盖章
     */
    private String signFieldStatus;

    /**
     * 指定该签署控件必须使用的印章或者签名Id
     */
    private Long sealId;

    /**
     * 指定该控件使用的印章类型，仅对企业参与方有效，如指定sealId时该字段无效 ：
     * official_seal：法定名称章（公章）
     * contract_seal：合同专用章
     * hr_seal：人事专用章
     * financial_seal：财务专用章
     * legal_representative_seal：法定代表人名章
     * other：其他。
     */
    private String categoryType;

    /**
     * 如果是备注区控件，参与方在该备注区内输入的内容
     */
    private String signRemark;

    /**
     * 印章位置信息
     */
    private Position position;
}
