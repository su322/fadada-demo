package com.yulintu.fadada.demo.models;

import lombok.Data;

/**
 * 获取企业授权链接响应数据
 */
@Data
public class CorpAuthUrl {
    /**
     * 企业授权链接，可嵌入小程序或iframe。有效期7天，页面自适应PC、H5端
     * 注：仅pc端支持iframe，H5及微信小程序使用web-view方式，微信公众号内使用跳转的方式
     */
    private String authUrl;
}
