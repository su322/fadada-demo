package com.yulintu.fadada.demo.models;

import lombok.Data;

/**
 * 该参与方的音视频双录文字内容信息，当意愿验证方式为audio_video时才生效，同一个参与方最多设置5条播报内容，5条播报内容合计至少50个字符。
 * 每条内容可包含【播报内容】、【回答】、【是否验证答案】
 */
@Data
public class AudioVideoInfo {
    /**
     * 播报内容，长度150以内，支持汉字、英文、数字、符号。
     * 汉字、英文、数字、符号均视为长度为1
     */
    private String audioText;

    /**
     * 播报内容对应的回答，需要用户朗读。默认内容为“是的”。
     * 注：（1）skipVerification不传或传false时，该字段长度最大为5，且不能包含“不”字，仅支持汉字、数字
     * （2）skipVerification传true时，该字段长度不超过30，回答内容支持汉字、数字、英文字母
     */
    private String answerText;

    /**
     * 是否跳过对用户回答内容的验证，默认为false
     * false：不跳过，系统会对用户回答内容进行正确性验证
     * true：跳过，即使用户回答内容与设置的内容不一致，也可继续完成签署
     */
    private Boolean skipVerification = false;
}
