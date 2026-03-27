package com.yulintu.fadada.demo.models;

import lombok.Data;

/**
 * 用户授权同时设置默认签名为免验证签的相关信息
 */
@Data
public class FreeSignInfo {
    /**
     * 需要绑定默认签名的免验证签场景码。如何获取场景码请查看帮助文档-免验证签使用说明
     * 注：如选择人工审核认证方式，认证完成后无法开通免验证签
     */
    private String businessId;
}
