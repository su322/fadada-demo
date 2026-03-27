package com.yulintu.fadada.demo.models;

import lombok.Data;

/**
 * 获取个人授权链接响应数据
 */
@Data
public class UserAuthUrl {
    /**
     * 个人授权链接，可嵌入小程序或 iframe。有效期 7 天。该链接自适应 PC、H5 端。
     * 注：仅 pc 端支持 iframe，H5 及微信小程序使用 web-view 方式，微信公众号内使用跳转的方式
     */
    private String authUrl;

    /**
     * 个人授权短连接，有效期 7 天。该链接自适应 PC、H5 端。
     */
    private String authShortUrl;
}
