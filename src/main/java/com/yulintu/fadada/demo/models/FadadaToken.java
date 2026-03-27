package com.yulintu.fadada.demo.models;

import lombok.Data;

@Data
public class FadadaToken {
    /**
     * 服务访问凭证
     */
    private String accessToken;

    /**
     * accessToken的过期时间，单位秒
     */
    private String expiresIn;
}
