package com.yulintu.fadada.demo.configs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "fadada")
public class FadadaConfig {
    private String endpoint;
    private String appId;
    private String appSecret;
}
