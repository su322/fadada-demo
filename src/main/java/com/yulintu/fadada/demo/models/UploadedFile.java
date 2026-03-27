package com.yulintu.fadada.demo.models;

import lombok.Data;
import javax.validation.constraints.NotBlank;

/**
 * 待处理的文件条目
 */
@Data
public class UploadedFile {
    /**
     * 文件的用途类型，即上传的文件后续在什么场景使用，二选一传入：
     * doc：用于签署（签字盖章）的文档，后续创建签署任务时使用，需要转换成pdf或ofd。
     * 本地的文件如需要验签，需要传此参数为doc。
     * attach：用于签署的附件查看、文件比对、合同智审。
     * auth： 用于获取企业授权链接时的营业执照，大小不超过5M
     */
    @NotBlank(message = "fileType 不能为空")
    private String fileType;

    /**
     * 存储中的源文件地址，长度最大为250个字符。
     */
    @NotBlank(message = "fddFileUrl 不能为空")
    private String fddFileUrl;

    /**
     * 指定文件名称，必须包含扩展名。扩展名需要与上传文件扩展名一致。如：合同.doc 。长度最大为200个字符。
     */
    @NotBlank(message = "fileName 不能为空")
    private String fileName;

    /**
     * 转换后的文档格式，默认pdf
     * pdf：将待签文档转换为pdf格式，签署时适用国际加密标准
     * ofd：将待签文档转换为ofd格式，签署时适用国密加密标准
     */
    private String fileFormat;

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
