package com.yulintu.fadada.demo.models;

import lombok.Data;

/**
 * 企业印章控件属性参数
 */
@Data
public class FieldCorpSeal {
    /**
     * 是否以参与方印章尺寸加盖，默认true
     * true：是，会忽略设置的width和height
     * false：否，以设置的width和height，如未传则按默认尺寸
     */
    private Boolean followSignSize = true;

    /**
     * 印章控件的宽度，单位px，默认166，不能大于229小于38
     */
    private Integer width;

    /**
     * 印章控件的高度，单位px，默认166，不能大于229小于38
     */
    private Integer height;

    /**
     * 指定该控件使用的印章类型，仅对企业参与方有效，支持指定多个，多个之间用英文逗号分隔。如指定sealId时该字段无效 ：
     * official_seal：法定名称章（公章）
     * contract_seal：合同专用章
     * hr_seal：人事专用章
     * financial_seal：财务专用章
     * legal_representative_seal：法定代表人名章
     * other：其他。
     */
    private String categoryType;
}

