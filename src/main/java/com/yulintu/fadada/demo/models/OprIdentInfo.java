package com.yulintu.fadada.demo.models;

import lombok.Data;

import java.util.List;

/**
 * 企业经办人信息。仅用于需要经办人实名认证时的信息带入，经办人可根据实际情况修改。
 */
@Data
public class OprIdentInfo {
    /**
     * 经办人真实姓名，仅支持中文。长度最大 50 个字符。
     */
    private String userName;

    /**
     * 经办人证件类型：
     * id_card: 身份证
     * hk_mac_rp：港澳居民居住证
     * taiwan_rp：台湾居民居住证
     * foreign_prc：外国人永久居留身份证
     * passport: 护照
     * hk_macao: 港澳居民来往内地通行证
     * taiwan: 台湾居民来往大陆通行证
     * hk_macao_foreigner：港澳居民来往内地通行证(非中国籍)
     * 只有携带这个参数，userIdentNo 参数才有效。
     */
    private String userIdentType;

    /**
     * 经办人证件号，跟证件类型关联，长度最大 50 个字符。
     */
    private String userIdentNo;

    /**
     * 国籍代码，证件类型为“港澳居民来往内地通行证(非中国籍)”时有效
     */
    private String nationalityCode;

    /**
     * 经办人个人手机号 ，长度最大 30 个字符。
     */
    private String mobile;

    /**
     * 经办人个人银行账户号。长度最大 30 个字符。
     */
    private String bankAccountNo;

    /**
     * 经办人实名认证方式：传多项按字段顺序为优先级展示
     * face: 人脸识别认证
     * mobile: 实名手机号三要素认证
     * bank: 个人银行卡四要素认证
     */
    private List<String> oprIdentMethod;

    /**
     * 指定刷脸核验方式:
     * tencent：腾讯云 H5 刷脸,
     * megvii：旷视刷脸
     */
    private String faceauthMode;
}
