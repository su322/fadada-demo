package com.yulintu.fadada.demo.models;

import lombok.Data;
import java.util.List;

/**
 * 查询文档关键字坐标响应结果
 */
@Data
public class KeywordPositionResult {
    /**
     * 关键字
     */
    private String keyword;

    /**
     * 关键字位置信息
     */
    private List<PositionInfo> positions;
}
