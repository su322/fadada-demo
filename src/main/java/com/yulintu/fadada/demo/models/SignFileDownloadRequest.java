package com.yulintu.fadada.demo.models;

import lombok.Data;
import java.util.List;

/**
 * 获取签署文档下载地址请求参数
 */
@Data
public class SignFileDownloadRequest {
    /**
     * 签署任务发起方或参与方，需检查授权。长度最大64个字符。
     */
    private OpenId ownerId;

    /**
     * 签署任务ID。下载单个任务文档时传此参数，直接返回下载链接。
     * 注：与batchDownloadInfo不可同时存在
     */
    private String signTaskId;

    /**
     * 客户下载后压缩包的自定义名称。长度最大85个字符。
     */
    private String customName;

    /**
     * 如果是单个文档，是否压缩为zip格式，默认false
     * true：单个文档也以zip格式下载，下载后需解压
     * false：单个文档直接以原格式下载，无需解压
     */
    private Boolean compression;

    /**
     * 批量下载时是否需要按签署任务区分文件夹，默认true
     * true：批量下载解压后，每个签署任务独立一个文件夹，任务中的文档和附件分别独立一个文件夹
     * false：批量下载解压后，直接为所有下载的文件，不根据签署任务进行文件夹分类
     */
    private Boolean folderBySigntask;

    /**
     * 如folderBySigntask设置为true，每个签署任务对应的文件夹名称，默认为signTaskId：
     * signTaskId：文件夹以签署任务Id命名
     * signTaskSubject：文件夹以签署任务主题命名
     * 注：folderBySigntask设置为false时，该参数忽略
     */
    private String folderName;

    /**
     * 如果是单个文档，打开下载链接时直接下载或在预览页面中下载，默认preview
     * preview：先预览，在预览页面中点击按钮下载
     * download：直接下载
     */
    private String downloadMode;

    /**
     * 批量下载的文件信息，最多50条。下载多个签署任务时传此参数，返回下载id，接入方根据签署文档下载回调事件获取对应的下载链接。
     * 注：与signtaskId不可同时存在
     */
    private List<BatchDownloadInfo> batchDownloadInfo;
}
