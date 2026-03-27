package com.yulintu.fadada.demo.models;

import lombok.Data;

import java.util.List;

/**
 * 应用委托代开发信息，如传该对象，企业授权后，系统会基于本应用为其创建一个集成应用，创建的应用配置与本应用一致
 * 仅开启了委托代开发模式的第三方应用可用此功能，如需使用请联系法大大人员
 */
@Data
public class AppDevelopInfo {
    /**
     * 是否为授权企业创建委托代开发应用，默认false
     * false：不创建
     * true：创建
     */
    private Boolean createApp;

    /**
     * 创建应用的名称，如不传则与本应用一致
     */
    private String appName;

    /**
     * 创建应用后是否自动提交审核，默认true
     * false：系统不自动提交上线审核，由接入方在法大大手动提交
     * true：系统自动提交上线审核
     * 提交审核后，如授权企业订购了【集成对接许可】且【可集成应用数】容量足额，可直接通过审核并上线
     */
    private Boolean autocommit;

    /**
     * 创建的代开发应用的回调地址，如不传，创建应用后回调地址会与本应用一致
     */
    private String feedbackUrl;

    /**
     * 创建的代开发应用的iframe白名单域名，如不传，创建应用后会与本应用一致
     */
    private List<String> iframeUrls;
}
