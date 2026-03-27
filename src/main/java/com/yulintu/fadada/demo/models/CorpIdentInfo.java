package com.yulintu.fadada.demo.models;

import lombok.Data;

import java.util.List;

/**
 * 企业身份信息
 */
@Data
public class CorpIdentInfo {
    /**
     * 法大大平台上企业主体的名称。
     * 用于匹配用户登录后从企业列表中精准匹配需要授权的企业。长度最大 128 个字符。
     */
    private String corpName;

    /**
     * 企业组织类型，不传默认为企业：
     * corp: 企业
     * individual_biz: 个体工商户
     * other: 其他类型。
     */
    private String corpIdentType;

    /**
     * 企业统一社会信用代码或各种类型组织的唯一代码，长度最大 50 个字符。
     */
    private String corpIdentNo;

    /**
     * 法定代表人姓名，长度最大 50 个字符。
     */
    private String legalRepName;

    /**
     * 营业执照的图片的 fileId，可通过文件上传及处理接口获取，大小不超过 5M
     */
    private String licenseFileId;

    /**
     * 企业实名认证方式：
     * legalRep：法定代表人认证（经办人是法定代表人，包含法定代表人刷脸认证、法定代表人短信认证）
     * legalRepFace：法定代表人刷脸认证
     * legalRepSms：法定代表人短信认证
     * agent：代理人认证（经办人不是法定代表人，包含邀请法定代表人在线认证、对公账户打款认证、邮寄授权公函原件 3 种方式）
     * invite：代理人邀请法定代表人在线认证
     * bank：代理人通过对公账户打款认证
     * letter：代理人通过邮寄授权公函原件认证。
     */
    private List<String> corpIdentMethod;
}
