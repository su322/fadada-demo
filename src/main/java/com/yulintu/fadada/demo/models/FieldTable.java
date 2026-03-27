package com.yulintu.fadada.demo.models;

import lombok.Data;
import java.util.List;

/**
 * 表格控件属性参数
 */
@Data
public class FieldTable {
    /**
     * 是否必须：false/true，默认为true。
     */
    private Boolean required = true;

    /**
     * 表头名称: ["表头1","表头2","表头3"]
     */
    private String[] header;

    /**
     * 横向表格至少填写的行数，竖向表格至少填写的列数，required为true才有效。
     */
    private Integer requiredCount;

    /**
     * 字体类型，默认楷体。
     * songti
     * fangsong
     * heiti
     * kaiti
     * arial
     */
    private String fontType;

    /**
     * 字号：单位px，默认16。输入值不能小于6，不能大于28。
     */
    private Integer fontSize;

    /**
     * 对齐类型，默认左对齐。
     * left
     * center
     * right
     */
    private String alignment;

    /**
     * 表格方向，默认横向
     * broadwise：横向
     * vertical：竖向，竖向无法设置动态表格
     */
    private String headerPosition;

    /**
     * 行数，默认3
     */
    private Integer rows;

    /**
     * 列数，默认3
     */
    private Integer cols;

    /**
     * 行高，单位px，默认32，不能小于22
     */
    private Integer rowHeight;

    /**
     * 每列的宽度，单位px，默认100，示例： [32,32,48,67]表示有4列
     */
    private int[] widths;

    /**
     * 是否可额外动态增删行数，默认false。
     * 仅横向表格支持动态填写。
     */
    private Boolean dynamicFilling = false;

    /**
     * [["填写内容11","填写内容12","填写内容13"],["填写内容21","填写内容22","填写内容23"],["填写内容31","填写内容32","填写内容33"]]
     * 注：如为动态表格，在填充时表格可根据填充内容动态增加，但超过文档大小时会发生表格位移，建议创建时在文档中预留足够的位置
     */
    private List<String[]> defaultValue;

    /**
     * 是否隐藏表头，默认faslse
     */
    private Boolean hideHeader = false;
}

