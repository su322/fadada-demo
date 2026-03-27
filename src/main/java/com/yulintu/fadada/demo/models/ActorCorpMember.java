package com.yulintu.fadada.demo.models;

import lombok.Data;

/**
 * 参与方企业成员信息。根据企业成员memberId，或企业成员的帐号来确认身份。
 */
@Data
public class ActorCorpMember {
    /**
     * 企业成员 ID。长度最大 20 个字符，与 accountName 不可同时为空。
     */
    private String memberId;

    /**
     * 企业成员的帐号，为手机号或邮箱，长度最大 60 个字符。与 memberId 不能同时为空，如传递了 memberId 则会忽略该字段。
     */
    private String accountName;
}
