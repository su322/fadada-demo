package com.yulintu.fadada.demo.models;

import lombok.Data;

/**
 * 获取参与方签署链接结果
 */
@Data
public class ActorSignTaskUrlResult {
    /**
     * 参与方签署短链接，一年有效。该链接由应用主动分发给对应参与方，页面自适应PC、H5端。
     * 注意: 需要参与方使用自己的法大大帐号进行登录访问
     */
    private String actorSignTaskUrl;

    /**
     * 参与方签署长链接，有效期10分钟，1次有效。该链接由应用主动分发给对应参与方，可嵌入小程序或iframe，页面自适应PC、H5端。
     * 注意:
     * 1、若请求参数传入clientUserId，会判断clientUserId是否有对应的法大大帐号，没有并且签署任务未设置快捷登录签署，则用户会进行第一次登录，登录后会将clientUserId与法大大帐号进行绑定，后续clientUserId对应用户支持免登进入签署页面
     * 2、若是小程序集成H5页面，涉及到人脸识别签署情况，请阅读微信小程序集成页面流程
     * 3、链接有效期最长可配置为30天，可在SaaS-集成-签署交互配置-用户签署页面中自助配置。
     * 4、链接无需解码
     */
    private String actorSignTaskEmbedUrl;

    /**
     * 参与方唤起法大大签署小程序的信息，用于在客户APP内唤起法大大签署小程序的签署功能。
     */
    private MiniAppInfo actorSignTaskMiniAppInfo;
}
