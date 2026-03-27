package com.yulintu.fadada.demo.models;

import lombok.Data;
import java.util.List;

/**
 * 文件处理响应
 */
@Data
public class FileProcessResult {
    /**
     * 文件处理后列表
     */
    private List<ProcessedFile> fileIdList;
}
