package com.yulintu.fadada.demo.models;

import lombok.Data;

@Data
public class Attach {
    /**
     * 设置附件标识，在同一个签署任务中不可重复，长度最大64个字符。
     */
    private String attachId;

    /**
     * 指定在本签署任务中的附件名称 ，长度最大200个字符。
     * 注意： 文件名称不支持以下9个字符：/ \ : * " | < >?
     */
    private String attachName;

    /**
     * 签署任务附件fileId。长度最大为32个字符。
     * 该参数值通过文件处理接口返回fileId获取。
     */
    private String attachFileId;

    /**
     * 对该份附件进行自定义命名，不传则按原附件名称
     */
    private String customAttachName;
}
