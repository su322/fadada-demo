package com.yulintu.fadada.demo.models;

import lombok.Data;
import java.util.List;

/**
 * 查询个人授权状态响应数据
 */
@Data
public class UserAuthState {
    /**
     * 用户在应用中的唯一标识。
     */
    private String clientUserId;

    /**
     * 法大大平台为该用户在该应用appId范围内分配的唯一标识。长度最大64个字符。
     */
    private String openUserId;

    /**
     * 授权状态：
     * authorized: 已授权 (clientUserId和userId已经完成帐号绑定)
     */
    private String bindingStatus;

    /**
     * 用户授权范围列表：
     * 【个人帐号】
     * ident_info：授权允许获取个人身份信息
     * 【签名】
     * seal_info：授权允许获取个人用户的签名资源
     * 【签署任务】
     * signtask_init： 授权允许代表个人发起签署
     * signtask_info： 授权允许获取个人用户的签署任务
     * signtask_file： 授权允许获取个人用户的签署文件 【计费】
     * billaccount_info：授权应用获取个人的计费数据
     */
    private List<String> authScope;

    /**
     * 实名认证状态：
     * identified: 已认证且有效。
     */
    private String identStatus;

    /**
     * 个人用户有效状态：
     * disable: 禁用状态
     * enable: 启用状态
     */
    private String availableStatus;
}
