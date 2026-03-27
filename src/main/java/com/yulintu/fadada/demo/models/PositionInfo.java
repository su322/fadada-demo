package com.yulintu.fadada.demo.models;

import lombok.Data;
import java.util.List;

/**
 * 关键字位置信息 页面左上角确定原点
 */
@Data
public class PositionInfo {
    /**
     * 关键字所在页码
     */
    private Integer positionPageNo;

    /**
     * 关键字中心点XY坐标
     */
    private Coordinate coordinate;

    /**
     * 关键字矩形区域信息，换行关键字可能存在多个矩形区
     * 注：仅pdf格式的文档返回该部分内容
     */
    private List<RectangleInfo> rectangleInfo;
}
