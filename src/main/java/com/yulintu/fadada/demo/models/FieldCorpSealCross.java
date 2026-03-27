package com.yulintu.fadada.demo.models;

import lombok.Data;

/**
 * 企业骑缝章控件属性参数
 */
@Data
public class FieldCorpSealCross {
    /**
     * 骑缝章应用页面，默认all
     * all：在文档所有页面加盖
     * odd：在文档奇数页面加盖
     * even：在文档偶数页面加盖
     * other：自定义页码加盖（仅免验证签生效）
     * 注：文档仅单页时不可设置骑缝章；文档只有两页时无法设置骑缝章至奇偶页；文档只有三页时无法设置骑缝章至偶数页
     */
    private String applyMode;

    /**
     * 自定义加盖骑缝章的页码，applyMode为other时必传，页码从1开始。
     * 例如传1,3,5-10,11-20，表示在第1页、第3页、第5到10页、第11到20页加盖骑缝章
     */
    private String applyPageNo;

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

