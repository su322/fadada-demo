package com.yulintu.fadada.demo.models;

import lombok.Data;

/**
 * 法大大 API 通用响应模型 todo 集成时在feign拦截器中统一提取data
 * @param <T> 具体的业务数据类型
 */
@Data
public class FadadaResponse<T> {
    /**
     * 返回码
     */
    private String code;

    /**
     * 返回码描述信息
     */
    private String msg;

    /**
     * 返回的业务数据
     */
    private T data;
}
