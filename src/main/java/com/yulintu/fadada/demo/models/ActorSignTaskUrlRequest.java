package com.yulintu.fadada.demo.models;

import lombok.Data;
import javax.validation.constraints.NotBlank;

/**
 * 获取参与方签署链接请求
 */
@Data
public class ActorSignTaskUrlRequest {
    /**
     * 签署任务ID 【必须】
     */
    @NotBlank(message = "signTaskId 不能为空")
    private String signTaskId;

    /**
     * 参与方在签署任务中被设定的唯一标识 【必须】
     */
    @NotBlank(message = "actorId 不能为空")
    private String actorId;

    /**
     * 应用系统中唯一确定登录用户身份的标识（仅集成签署长链接时生效）
     * 注意：
     * 1）该字段可以为空，为空则表示生成的链接不接入账号免登机制。
     * 2）如该字段不为空，会判断clientUserId是否有对应的法大大帐号，如果没有并且参与方未设置快捷登录签署，则需要登录，用户登录后会将clientUserId与对应的法大大帐号进行映射，后续接口传入同样的clientUserId时，用户则无需登录即可进入签署页面（免登机制）。
     * 3）clientUserId对应的用户 无需提前授权 ，和主体资源授权是完全不同的概念。若有进行个人授权则建议和授权时的clientUserId保持一致。
     */
    private String clientUserId;

    /**
     * 重定向地址，系统判断在非小程序环境下会跳转至该地址。长度最大500个字符。redirectUrl需要进行编码，例 URLEncoder.encode("http://www.baidu.com", "UTF-8")
     * 注：用户签署完成后的重定向方式支持立即跳转、点击按钮跳转或延迟跳转，接入方可在法大大SaaS-集成-签署交互配置进行设置。
     */
    private String redirectUrl;

    /**
     * 小程序的重定向地址（微信和支付宝），不支持tabBar页面，长度最大500个字符。
     * 使用场景：小程序中集成该页面，操作完成后跳转地址为小程序原生页面路径，如"/pages/index/index"，系统判断在小程序环境会跳转至该地址。
     * 注：需要进行编码，若非原生页面路径请使用redirectUrl字段
     */
    private String redirectMiniAppUrl;
}
