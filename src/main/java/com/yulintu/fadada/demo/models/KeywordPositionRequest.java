package com.yulintu.fadada.demo.models;

import lombok.Data;
import java.util.List;

/**
 * 查询文档关键字坐标请求参数
 */
@Data
public class KeywordPositionRequest {
    /**
     * 文档Id，与docTemplateId不可同时存在，且只能存在一个
     */
    private String fileId;

    /**
     * 文档模板Id，与fileId不可同时存在，且只能存在一个
     */
    private String docTemplateId;

    /**
     * 需要查找的关键字
     */
    private List<String> keywords;
}
