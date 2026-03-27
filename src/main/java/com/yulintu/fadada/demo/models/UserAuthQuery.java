package com.yulintu.fadada.demo.models;

import lombok.Data;

/**
 * 查询个人授权状态请求参数
 */
@Data
public class UserAuthQuery {
    /**
     * 个人用户在应用中的唯一标识，长度最大64个字符。
     */
    private String clientUserId;

    /**
     * 法大大平台为该用户在该应用appId范围内分配的唯一标识。长度最大64个字符。
     * 注意：clientUserId与openUserId传值只能二选一，不能同时为空。
     */
    private String openUserId;
}
