package com.yulintu.fadada.demo.models;

import lombok.Data;

/**
 * 文件上传地址响应数据
 */
@Data
public class FileUploadUrl {
    /**
     * 文件上传地址，通过该链接，可以将用于签署的文档或附件上传到存储空间，长度最大为500个字符。
     * 注意： 上传的源文件必须带有扩展名，如合同.doc,否则可能会处理失败
     * 上传链接有效期30分钟。
     */
    private String uploadUrl;

    /**
     * 存储空间中的源文件地址，长度最大为250个字符。
     */
    private String fddFileUrl;
}

