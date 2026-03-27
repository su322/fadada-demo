package com.yulintu.fadada.demo.models;

import lombok.Data;

/**
 * 统一标识应用系统上的用户主体(个人或企业)。
 */
@Data
public class OpenId {
    /**
     * 主体类型：
     * corp: 企业
     * person: 个人
     */
    private String idType;

    /**
     * 主体标识，长度最大64个字符。
     * 如果idType为corp：代表应用系统上的企业用户，主体方是openCorpId所指定的企业；
     * 如果idType为person：代表应用系统上的个人用户，主体方是openUserId所指定的个人；
     */
    private String openId;
}
