package com.yulintu.fadada.demo.models;

import lombok.Data;

/**
 * 印章位置信息
 */
@Data
public class Position {
    /**
     * 定位页码。首页从1开始。
     */
    private int positionPageNo;

    /**
     * 中心点定位横向坐标。
     * 该参数对骑缝签章无效，因为骑缝章只在Y坐标上。
     * 注意：
     * 1)该字段的值为数字【整数或者小数】。
     */
    private String positionX;

    /**
     * 中心点定位纵向坐标。
     * 注意：
     * 1)该字段的值为数字【整数或者小数】。
     */
    private String positionY;
}

