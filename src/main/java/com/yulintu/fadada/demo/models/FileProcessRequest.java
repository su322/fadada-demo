package com.yulintu.fadada.demo.models;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 文件处理请求
 */
@Data
public class FileProcessRequest {
    /**
     * 上传成功后待处理的文件列表，每次最多处理10份文件，每份文件不大于50M。
     * 注：批量处理时，不支持原文件为图片格式和非图片格式的文档同时处理
     */
    @NotBlank(message = "fddFileUrlList 不能为空")
    private List<UploadedFile> fddFileUrlList;

    /**
     * 文件上传的目的存储类型，不传该值时，如集成应用开启了“本地存储”，则会自动上传至接入方本地服务器；如未开启，则上传至法大大云端
     * opdm：上传至接入方本地服务器
     * cloud：上传至法大大云端，如需将本地存储的签署文件上传至云端获取fileId后申请出证、文档验签，则可以设置此参数
     */
    private String storageType;

    /**
     * 多张图片同时处理时，是否每张图片均为一个单独的pdf，默认false
     * false：本次处理的图片合成一个pdf
     * true：每张图片单独一个pdf
     */
    private Boolean separation;
}
