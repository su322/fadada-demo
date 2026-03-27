package com.yulintu.fadada.demo.models;

import lombok.Data;

/**
 * 关键字矩形区域信息，换行关键字可能存在多个矩形区
 * 注：仅pdf格式的文档返回该部分内容
 */
@Data
public class RectangleInfo {
    /**
     * 关键字矩形区域左上角X坐标
     */
    private String minX;

    /**
     * 关键字矩形区域左上角Y坐标
     */
    private String minY;

    /**
     * 关键字矩形区域右下角X坐标
     */
    private String maxX;

    /**
     * 关键字矩形区域右下角Y坐标
     */
    private String maxY;

    /**
     * 关键字矩形区域宽度
     */
    private String width;

    /**
     * 关键字矩形区域高度
     */
    private String height;
}

