package com.yulintu.fadada.demo.models;

import lombok.Data;

/**
 * 获取文件上传地址请求参数
 * @author YLT0020264
 */
@Data
public class FileUploadUrlRequest {
    /**
     * 文件的用途类型，文件大小不能超过50M：
     * doc：用于签署的文档，只有这种用途的文件才可以被加入签署任务的文档列表中，doc表示文档用途，与文件格式无关，建议上传pdf格式文件
     * 本地的文件如需验签，也需要传此参数为doc。
     * 纸质合同归档支持格式：pdf
     *
     * attach：用于签署任务的附件、文件比对、合同智审、合同起草协商、纸质合同归档、本地存储任务出证。
     *
     * 附件支持格式： doc、docx、wps、jpg、jpeg、png、tiff、pdf、xls、xlsx、zip、rar、mp4、amr、mp3、wav、tiff、txt、ofd
     * 文件比对支持格式：pdf、doc、wps、png、jpg、jpeg、tiff
     * 合同智审支持格式：doc、docx、txt、pdf、png、jpg、jpeg
     * 合同起草协商支持格式：doc、docx
     * 本地存储任务出证支持格式：pdf、ofd
     * auth： 用于获取企业授权链接时的营业执照，大小不超过5M
     */
    private String fileType;

    /**
     * 文件上传的目的存储类型，不传该值时，如集成应用开启了“本地存储”，则会自动上传至接入方本地服务器；如未开启，则上传至法大大云端
     * opdm：上传至接入方本地服务器
     * cloud：上传至法大大云端，如需将本地存储的签署文件上传至云端获取fileId后申请出证、文档验签，则可以设置此参数
     */
    private String storageType;
}

