package com.yulintu.fadada.demo.models;

import lombok.Data;

import java.util.List;

@Data
public class CorpAuthState {
    /**
     * 企业在应用中的唯一标识。长度最大 64 个字符。
     */
    private String clientCorpId;

    /**
     * 法大大平台为该企业在该应用 appId 范围内分配的唯一标识。长度最大 64 个字符。
     */
    private String openCorpId;

    /**
     * 根据统信码查询到的企业在企业帐号下的类型：
     * primary：主企业，即企业帐号对应的主体
     * subsidiary：子企业，即成员企业
     */
    private String entityType;

    /**
     * 授权状态，表示是否完成帐号授权绑定：
     * unauthorized: 未授权 (clientCorpId 和 corpId 未完成帐号绑定)
     * authorized: 已授权 (clientCorpId 和 corpId 已经完成帐号绑定)
     */
    private String bindingStatus;

    /**
     * 企业授权范围列表，多个以逗号分隔：
     * 【企业帐号】ident_info: 授权应用获取企业身份信息
     * 【印章】seal_info: 授权应用获取企业的印章相关资源
     * 【组织】organization: 授权应用获取企业的组织数据
     * 【模板】template: 授权应用获取企业的模板数据
     * 【签署任务】signtask_init：授权应用代表企业发起签署；signtask_info：授权应用获取企业的签署任务；signtask_file: 授权应用获取企业的签署文件；file_storage: 授权模板和签署文件存储到应用的企业服务器
     * 【合同】contract_info：授权应用获取企业的合同数据
     * 【计费】billaccount_info：授权应用获取企业的计费数据
     */
    private List<String> authScope;

    /**
     * 实名认证状态：
     * unidentified: 未认证 (如果尚未授权绑定帐号，则当做未认证)
     * identified: 已认证且有效。
     */
    private String identStatus;

    /**
     * 企业用户有效状态：
     * disable: 禁用状态
     * enable: 启用状态
     */
    private String availableStatus;
}
