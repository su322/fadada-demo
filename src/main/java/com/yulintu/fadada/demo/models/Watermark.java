package com.yulintu.fadada.demo.models;

import lombok.Data;
import javax.validation.constraints.NotBlank;

/**
 * 水印配置信息
 */
@Data
public class Watermark {
    /**
     * 水印类型
     * text：文字
     * picture：图片
     */
    @NotBlank(message = "水印类型 type 不能为空")
    private String type;

    /**
     * 文字水印内容，水印类型为 text 时必传。不超过 20 个字符
     */
    private String content;

    /**
     * 字体字号，单位 px，默认 14，范围 6-144
     */
    private Integer fontSize;

    /**
     * 字体颜色，默认 #000000
     */
    private String fontColor;

    /**
     * 图片水印的 base64，水印类型为 picture 时必传，图片大小不能超过 300KB
     */
    private String picBase64;

    /**
     * 要求图片水印的宽度，不传表示取图片本身宽度，如设置则图片宽度会等比例压缩
     */
    private Integer picWidth;

    /**
     * 要求图片水印的高度，不传表示取图片本身高度，如设置则图片高度会等比例压缩
     */
    private Integer picHeight;

    /**
     * 逆时针旋转角度，默认 0，范围 0-180，如传 60 表示逆时针旋转 60 度
     */
    private Integer rotation;

    /**
     * 透明度，默认 50，范围 0-100，100 表示全透明
     */
    private Integer transparency;

    /**
     * 水印位置，默认左上
     * top_left：左上
     * top_right：右上
     * bottom_left：左下
     * bottom_right：右下
     * center：居中
     * tile：平铺
     */
    private String position;

    /**
     * 水印平铺密度，仅 position 为 tile 时有效，默认标准
     * sparse：稀疏
     * standard：标准
     * dense：密集
     */
    private String density;
}
