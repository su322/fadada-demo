package com.yulintu.fadada.demo.models;

import lombok.Data;

/**
 * 创建签署任务响应数据
 */
@Data
public class SignTaskCreateResult {
    /**
     * 签署任务ID，长度最大20个字符。
     */
    private String signTaskId;
}

