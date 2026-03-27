package com.yulintu.fadada.demo.models;

import lombok.Data;

/**
 * 参与方唤起法大大签署小程序的信息
 */
@Data
public class MiniAppInfo {
    /**
     * 法大大签署小程序的原始Id
     */
    private String wxOriginalId;

    /**
     * 参与方签署任务页面路径
     */
    private String path;
}

