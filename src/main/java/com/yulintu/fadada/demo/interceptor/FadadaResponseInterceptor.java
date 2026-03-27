package com.yulintu.fadada.demo.interceptor;

import com.dtflys.forest.http.ForestResponse;
import com.dtflys.forest.interceptor.Interceptor;
import com.yulintu.fadada.demo.models.FadadaResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 法大大响应拦截器
 * 用于统一提取 Header 中的 X-FASC-Request-Id，并记录接口调用日志
 * 法大大平台为每次接口调用生成唯一的标识。建议将此参数打印在调用日志中，当需要法大大协助排查调用问题时，可把此参数反馈给法大大的技术支持人员。
 */
@Slf4j
@Component
public class FadadaResponseInterceptor implements Interceptor<Object> {

    @Override
    public void onSuccess(Object data, com.dtflys.forest.http.ForestRequest request, ForestResponse response) {
        // 从 Header 中提取 Request-Id 用于日志记录
        String requestId = response.getHeaderValue("X-FASC-Request-Id");
        if (requestId != null) {
            log.info("[Fadada] 接口调用成功 | Request-Id: {} | URL: {}", requestId, request.getUrl());
        }

        // 如果 data 是 FadadaResponse 类型，将其内容打印在 info 日志中
        if (data instanceof FadadaResponse) {
            FadadaResponse<?> fadadaResponse = (FadadaResponse<?>) data;
            log.info("[Fadada] 接口返回内容 | Code: {} | Msg: {} | Data: {}",
                    fadadaResponse.getCode(), fadadaResponse.getMsg(), fadadaResponse.getData());
        }
    }

    @Override
    public void onError(com.dtflys.forest.exceptions.ForestRuntimeException ex, com.dtflys.forest.http.ForestRequest request, ForestResponse response) {
        String requestId = response != null ? response.getHeaderValue("X-FASC-Request-Id") : "N/A";
        log.error("[Fadada] 接口调用失败 | Request-Id: {} | URL: {} | Error: {}", requestId, request.getUrl(), ex.getMessage());
    }
}
