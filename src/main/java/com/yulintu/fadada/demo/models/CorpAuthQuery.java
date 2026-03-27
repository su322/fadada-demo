package com.yulintu.fadada.demo.models;

import lombok.Data;

@Data
public class CorpAuthQuery {
    /**
     * 企业统一社会信用代码或各种类型组织的唯一代码，长度最大50个字符。
     */
    private String corpIdentNo;

    /**
     * 企业在应用中的唯一标识。长度最大64个字符。
     */
    private String clientCorpId;

    /**
     * 法大大平台为该企业在该应用appId范围内分配的唯一标识。长度最大64个字符。
     * 注意：corpIdentNo、clientCorpId与openCorpId传值只能三选一，不能同时为空。
     */
    private String openCorpId;
}
