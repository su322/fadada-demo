package com.yulintu.fadada.demo.models;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 获取企业授权链接请求参数
 */
@Data
public class CorpAuthRequest {
    /**
     * 企业在应用中的唯一标识，由接入方自定义。长度最大 64 个字符。
     */
    @NotBlank(message = "clientCorpId 不能为空")
    private String clientCorpId;

    /**
     * 经办人在业务系统中的唯一标识。长度最大 64 个字符。
     * 用于建立经办人在业务系统和法大大帐号的映射关系，以实现帐号免登。
     */
    private String clientUserId;

    /**
     * 经办人个人用户的法大大帐号，仅限手机号或邮箱，长度最大 60 个字符。
     * 如该手机号或邮箱未注册法大大，则用户会以此作为注册账号。
     */
    private String accountName;

    /**
     * 需要开通电子签的企业信息。
     */
    private CorpIdentInfo corpIdentInfo;

    /**
     * 不可修改的企业信息，默认都可修改。
     * corpName：企业名称
     * corpIdentType：企业组织类型
     * corpIdentNo：企业统一社会信用代码或各种类型组织的唯一代码
     */
    private List<String> corpNonEditableInfo;

    /**
     * 企业经办人信息。仅用于需要经办人实名认证时的信息带入，经办人可根据实际情况修改。
     */
    private OprIdentInfo oprIdentInfo;

    /**
     * 不可修改的经办人信息。如不传表示都可修改
     * accountName：个人用户的法大大帐号
     * userName：姓名
     * userIdentType：证件类型
     * userIdentNo：证件号码
     * nationalityCode：国籍代码
     * mobile：手机号
     * bankAccountNo：银行卡号
     */
    private List<String> oprNonEditableInfo;

    /**
     * 业务请求的企业授权范围列表，多个以逗号分隔：
     * ident_info: 授权应用获取企业认证及身份信息
     * seal_info: 授权应用获取企业的印章相关资源
     * organization: 授权应用获取企业的组织数据
     * template: 授权应用获取企业的模板数据
     * signtask_init： 授权应用代表企业发起签署
     * signtask_info： 授权应用获取企业的签署任务
     * signtask_file: 授权应用获取企业的签署文件
     * file_storage: 授权签署文件存储到应用的企业服务器
     * contract_info：授权应用获取企业的合同数据
     * billaccount_info：授权应用获取企业的计费数据
     * smartform：授权应用获取企业的收集表数据
     */
    private List<String> authScopes;

    /**
     * 重定向地址。即用户在页面上完成操作后重定向跳转到该地址，并且附带上参数。长度最大 500 个字符。
     */
    private String redirectUrl;

    /**
     * 小程序的重定向地址（微信和支付宝），不支持 tabBar 页面，长度最大 500 个字符。
     */
    private String redirectMiniAppUrl;

    /**
     * 应用委托代开发信息，如传该对象，企业授权后，系统会基于本应用为其创建一个集成应用
     */
    private AppDevelopInfo appDevelopInfo;

    /**
     * 设置该用户授权的回调事件发送地址，设置该地址后，该用户的授权事件将会发送到该地址中
     */
    private String callbackUrl;
}
