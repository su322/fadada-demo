package com.yulintu.fadada.demo.models;

import lombok.Data;
import java.util.List;
import javax.validation.constraints.NotBlank;

/**
 * 获取个人授权链接请求参数
 */
@Data
public class UserAuthRequest {
    /**
     * 个人用户在应用中的唯一标识，由接入方自定义，长度最大 64 个字符。
     */
    @NotBlank(message = "clientUserId 不能为空")
    private String clientUserId;

    /**
     * 个人用户的法大大帐号，仅限手机号或邮箱，长度最大 60 个字符。
     * 如该手机号或邮箱未注册法大大，则用户会以此作为注册账号。
     * 当用户 accountName 与 mobile 传相同手机号，同时设置认证方式为手机号认证，用户打开链接后只需输入一次验证码即可完成认证和授权。
     */
    private String accountName;

    /**
     * 如 clientUserId 已经绑定了法大大帐号（绑定的 accountName 与本次不一致），或绑定的实名信息与本次认证实名信息（姓名、证件号）不一致，用户打开链接后是否默认解绑之前的帐号并以本次登录的帐号更新实名信息，默认为 false
     * false：不解绑
     * true：解绑
     */
    private Boolean unbindAccount;

    /**
     * 个人认证信息。
     */
    private UserIdentInfo userIdentInfo;

    /**
     * 页面中不可编辑的个人信息，默认都可编辑。
     * accountName：个人用户的法大大帐号
     * userName：姓名
     * userIdentType：证件类型
     * userIdentNo：证件号码
     * mobile：手机号
     * bankAccountNo：银行卡号
     */
    private List<String> nonEditableInfo;

    /**
     * 个人用户授权范围：
     * 【个人帐号】
     * ident_info：授权允许获取个人身份信息
     * 【签名】
     * seal_info：授权允许获取个人用户的签名资源
     * 【签署任务】
     * signtask_init： 授权允许代表个人发起签署
     * signtask_info： 授权允许获取个人用户的签署任务
     * signtask_file：授权允许获取个人用户的签署文件
     * file_storage：授权签署文件存储到应用的企业服务器，仅针对应用开启本地存储时生效
     * 【计费】
     * billaccount_info：授权应用获取个人的计费数据
     * 注意： 在授权页面上会显示对应授权项，授权范围将通过redirectUrl的参数告知，同时个人授权事件回调通知应用系统。也可通过查询个人认证授权状态查询
     */
    private List<String> authScopes;

    /**
     * 用户授权同时设置默认签名为免验证签的相关信息
     */
    private FreeSignInfo freeSignInfo;

    /**
     * 重定向地址。即用户在页面上完成操作后重定向跳转到该地址，并且附带上参数。长度最大1000个字符。redirectUrl需要进行编码。例： URLEncoder.encode("http://www.baidu.com", "UTF-8")。
     * 若未设置redirectUrl，则授权完成的参数通过回调事件通知应用系统服务端。
     */
    private String redirectUrl;

    /**
     * 小程序的重定向地址（微信和支付宝），不支持tabBar页面，长度最大1000个字符。
     * 使用场景：小程序中集成该页面，操作完成后跳转地址为小程序原生页面路径，如"/pages/index/index"，系统判断在小程序环境会跳转至该地址。
     * 注：需要进行编码，若非原生页面路径请使用redirectUrl字段
     */
    private String redirectMiniAppUrl;

    /**
     * 设置该用户授权的回调事件发送地址，设置该地址后，该用户的授权事件将会发送到该地址中，不会向集成应用中配置的回调地址发送。请确保该地址可以接收到回调信息。
     */
    private String callbackUrl;
}
