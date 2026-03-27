package com.yulintu.fadada.demo.models;

import lombok.Data;
import java.util.List;

/**
 * 批量下载的文件信息
 */
@Data
public class BatchDownloadInfo {
    /**
     * 需要下载的签署任务Id
     */
    private String batchSignTaskId;

    /**
     * 需要下载的该签署任务中的文档信息，不传表示都下载
     */
    private List<Doc> docInfos;

    /**
     * 需要下载的该签署任务中的附件信息，不传表示都下载
     */
    private List<Attach> attachInfos;
}

