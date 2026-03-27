package com.yulintu.fadada.demo.models;

import lombok.Data;

/**
 * 获取签署文档下载地址响应结果
 */
@Data
public class SignFileDownloadResult {
    /**
     * 文档的下载地址，文件压缩格式zip，长度最长1000字符。仅在下载单个签署任务时返回。
     * 有效期内无次数限制。
     * 注意：链接有效期1小时，不支持小程序内嵌下载
     */
    private String downloadUrl;

    /**
     * 本次下载的Id，仅在下载签署任务数大于1时返回。系统完成文件打包后会推送回调事件给接入方，接入方根据该id判断下载内容。
     * 注：接收回调需在SaaS-集成-事件订阅开启相关事件开关
     */
    private String downloadId;
}
