package com.yulintu.fadada.demo.models;

import lombok.Data;

/**
 * 文件处理后详情
 */
@Data
public class ProcessedFile {
    /**
     * 文件ID，长度最大32个字符。
     * 注意：文件ID顺序与请求参数中源文件顺序一一对应。
     */
    private String fileId;

    /**
     * 文件的用途类型，一次处理多份文件时便于区分fileId对应的是哪份文件。
     */
    private String fileType;

    /**
     * 存储中的源文件地址，一次处理多份文件时便于区分fileId对应的是哪份文件。
     */
    private String fddFileUrl;

    /**
     * 文件名，一次处理多份文件时便于区分fileId对应的是哪份文件。
     */
    private String fileName;

    /**
     * 文件总页数（仅fileType为doc时有值）
     */
    private Integer fileTotalPages;
}
