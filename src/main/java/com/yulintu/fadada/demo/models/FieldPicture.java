package com.yulintu.fadada.demo.models;

import lombok.Data;

/**
 * 图片控件属性参数
 */
@Data
public class FieldPicture {
    /**
     * 是否必须：false/true，默认为true。
     */
    private Boolean required = true;

    /**
     * 上传图片fileId，即表示将已上传的图片填入该控件内。
     */
    private String defaultValue;

    /**
     * 文本框宽度，单位px，默认160。为避免文本框宽度超过文档底稿宽度，请合理设置该值。
     */
    private Integer width;

    /**
     * 文本框高度，单位px，默认120。为避免文本框高度超过文档底稿高度，请合理设置该值。
     */
    private Integer height;
}

