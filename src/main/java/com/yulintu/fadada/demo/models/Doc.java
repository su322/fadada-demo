package com.yulintu.fadada.demo.models;

import lombok.Data;
import java.util.List;

/**
 * 待签署的文档列表，文档数上限为50个，一个签署任务中可包含多份文档。任务中展示的顺序以该结构体传入的顺序为准。
 */
@Data
public class Doc {
    /**
     * 文档标识，由接入方自定义传入，同一个签署任务中唯一不可重复，长度最大64个字符。
     */
    private String docId;

    /**
     * 文档名称，长度最大200个字符。
     * 注意： 文件名称不支持以下9个字符：/ \ : * " | < >?
     */
    private String docName;

    /**
     * 文档fileId。长度最大为32个字符。
     * 该参数值通过文件处理接口返回fileId获取。
     * 该参数和docTemplateId只能有一个，且必须有一个。
     *
     * 创建任务的原始文档fileId，即底稿，无控件和盖章内容。
     */
    private String docFileId;

    /**
     * 文档模板ID。
     */
    private String docTemplateId;

    /**
     * 可在文档中添加控件。建议采用模板定义控件，或通过获取签署任务编辑链接设置,控件介绍请见帮助文档-签署控件说明
     */
    private List<Field> docFields;

    /**
     * 对该份文档进行自定义命名，不传则按原文档名称
     */
    private String customDocName;
}
