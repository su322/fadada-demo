package com.yulintu.fadada.demo.models;

import lombok.Data;
import java.util.List;

/**
 * 个人身份信息
 */
@Data
public class UserIdentInfo {
    /**
     * 个人用户真实姓名。长度最大50个字符。
     */
    private String userName;

    /**
     * 证件类型 ：
     * id_card: 身份证
     * hk_mac_rp：港澳居民居住证
     * taiwan_rp：台湾居民居住证
     * foreign_prc：外国人永久居留身份证
     * passport: 护照
     * hk_macao: 港澳居民来往内地通行证
     * taiwan: 台湾居民来往大陆通行证
     */
    private String userIdentType;

    /**
     * 证件号。跟证件类型关联，长度最大50个字符。
     */
    private String userIdentNo;

    /**
     * 国籍代码，证件类型为“港澳居民来往内地通行证(非中国籍)”时有效
     */
    private String nationalityCode;

    /**
     * 个人手机号 ，长度最大30个字符。
     */
    private String mobile;

    /**
     * 个人银行账户号。长度最大30个字符。
     */
    private String bankAccountNo;

    /**
     * 用户实名认证方式，传多项按字段顺序为优先级展示，默认都可以使用，由用户自行选择：
     * face: 人脸识别认证（如在小程序中刷脸，请参考小程序集成说明）
     * mobile: 实名手机号三要素认证
     * bank: 个人银行卡四要素认证
     * offline: 人工审核认证
     */
    private List<String> identMethod;

    /**
     * 指定刷脸核验方式:
     * tencent：腾讯云H5刷脸,
     * megvii：旷视刷脸，该页面可内嵌在小程序中。 注：如需内嵌小程序，客户需在自己微信小程序后台业务域名添加e域名，并上传校验文件至法大大
     */
    private String faceauthMode;
}
