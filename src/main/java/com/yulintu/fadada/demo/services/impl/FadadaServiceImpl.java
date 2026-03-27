package com.yulintu.fadada.demo.services.impl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yulintu.fadada.demo.client.FadadaClient;
import com.yulintu.fadada.demo.configs.FadadaConfig;
import com.yulintu.fadada.demo.models.*;
import com.yulintu.fadada.demo.services.FadadaService;
import com.yulintu.fadada.demo.utils.FadadaCryptUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service("fadadaServiceImpl")
public class FadadaServiceImpl implements FadadaService {

    @Autowired
    private FadadaClient fadadaClient;

    @Autowired
    private FadadaConfig fadadaConfig;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public FadadaResponse<FadadaToken> getAccessToken() {
        // todo 这些后面都写进常量
        String grantType = "client_credential";
        // 使用包含 grantType 的签名逻辑
        Map<String, String> h = FadadaCryptUtil.generateSignHeaders(fadadaConfig.getAppId(), fadadaConfig.getAppSecret(), null, null, grantType);

        return fadadaClient.getAccessToken(
                fadadaConfig.getAppId(),
                h.get("X-FASC-Sign-Type"),
                h.get("X-FASC-Sign"),
                h.get("X-FASC-Timestamp"),
                h.get("X-FASC-Nonce"),
                grantType,
                h.get("X-FASC-Api-SubVersion")
        );
    }

    @Override
    public FadadaResponse<UserAuthUrl> getUserAuthUrl(UserAuthRequest request) {
        String accessToken = getAccessToken().getData().getAccessToken();

        // 对 redirectUrl 进行 UTF-8 编码
        String encodedUrl = null;
        try {
            encodedUrl = URLEncoder.encode(request.getRedirectUrl(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("对 redirectUrl 进行 UTF-8 编码异常", e);
        }
        request.setRedirectUrl(encodedUrl);

        // 使用过滤 null 的序列化方式生成 bizContent
        String bizContent = toJsonExcludeNull(request);

        Map<String, String> h = FadadaCryptUtil.generateSignHeaders(fadadaConfig.getAppId(), fadadaConfig.getAppSecret(), accessToken, bizContent);

        // todo 暂停在这里，出现签名错误，转向sdk
        return fadadaClient.getUserAuthUrl(
                fadadaConfig.getAppId(),
                h.get("X-FASC-Sign-Type"),
                h.get("X-FASC-Sign"),
                h.get("X-FASC-Timestamp"),
                h.get("X-FASC-Nonce"),
                accessToken,
                bizContent
        );
    }

    @Override
    public FadadaResponse<UserAuthState> getUserAuthState(UserAuthQuery query) {
        String accessToken = getAccessToken().getData().getAccessToken();
        String bizContent = toJson(query);

        Map<String, String> h = FadadaCryptUtil.generateSignHeaders(
                fadadaConfig.getAppId(),
                fadadaConfig.getAppSecret(),
                accessToken,
                bizContent
        );

        return fadadaClient.getUser(
                fadadaConfig.getAppId(),
                h.get("X-FASC-Sign-Type"),
                h.get("X-FASC-Sign"),
                h.get("X-FASC-Timestamp"),
                h.get("X-FASC-Nonce"),
                accessToken,
                bizContent
        );
    }

    @Override
    public FadadaResponse<FileUploadUrl> uploadFile(MultipartFile file, FileUploadUrlRequest request) {
        // 1. 获取上传地址
        String accessToken = getAccessToken().getData().getAccessToken();
        String bizContent = toJson(request);

        Map<String, String> h = FadadaCryptUtil.generateSignHeaders(
                fadadaConfig.getAppId(),
                fadadaConfig.getAppSecret(),
                accessToken,
                bizContent
        );

        FadadaResponse<FileUploadUrl> response = fadadaClient.getUploadUrl(
                fadadaConfig.getAppId(),
                h.get("X-FASC-Sign-Type"),
                h.get("X-FASC-Sign"),
                h.get("X-FASC-Timestamp"),
                h.get("X-FASC-Nonce"),
                accessToken,
                bizContent
        );

        if (response != null && "100000".equals(response.getCode())) {
            // 2. 执行文件上传到法大大 (PUT)
            FileUploadUrl data = response.getData();
            try {
                // 将 MultipartFile 转为临时 File 以供 Forest 使用
                File tempFile = File.createTempFile("fdd_", file.getOriginalFilename());
                file.transferTo(tempFile);

                fadadaClient.uploadFile(data.getUploadUrl(), tempFile);

                // 上传成功后删除临时文件
                tempFile.delete();
            } catch (Exception e) {
                log.error("上传本地文件到法大大异常", e);
            }
        }

        return response;
    }

    @Override
    public FadadaResponse<FileProcessResult> fileProcess(FileProcessRequest request) {
        String accessToken = getAccessToken().getData().getAccessToken();
        String bizContent = toJson(request);

        Map<String, String> h = FadadaCryptUtil.generateSignHeaders(
                fadadaConfig.getAppId(),
                fadadaConfig.getAppSecret(),
                accessToken,
                bizContent
        );

        return fadadaClient.fileProcess(
                fadadaConfig.getAppId(),
                h.get("X-FASC-Sign-Type"),
                h.get("X-FASC-Sign"),
                h.get("X-FASC-Timestamp"),
                h.get("X-FASC-Nonce"),
                accessToken,
                bizContent
        );
    }

    @Override
    public FadadaResponse<List<KeywordPositionResult>> getKeywordPositions(KeywordPositionRequest request) {
        String accessToken = getAccessToken().getData().getAccessToken();
        String bizContent = toJson(request);

        Map<String, String> h = FadadaCryptUtil.generateSignHeaders(
                fadadaConfig.getAppId(),
                fadadaConfig.getAppSecret(),
                accessToken,
                bizContent
        );

        return fadadaClient.getKeywordPositions(
                fadadaConfig.getAppId(),
                h.get("X-FASC-Sign-Type"),
                h.get("X-FASC-Sign"),
                h.get("X-FASC-Timestamp"),
                h.get("X-FASC-Nonce"),
                accessToken,
                bizContent
        );
    }

    @Override
    public FadadaResponse<SignTaskCreateResult> createSignTask(SignTaskCreateRequest request) {
        String accessToken = getAccessToken().getData().getAccessToken();
        String bizContent = toJson(request);

        Map<String, String> h = FadadaCryptUtil.generateSignHeaders(
                fadadaConfig.getAppId(),
                fadadaConfig.getAppSecret(),
                accessToken,
                bizContent
        );

        return fadadaClient.createSignTask(
                fadadaConfig.getAppId(),
                h.get("X-FASC-Sign-Type"),
                h.get("X-FASC-Sign"),
                h.get("X-FASC-Timestamp"),
                h.get("X-FASC-Nonce"),
                accessToken,
                bizContent
        );
    }

    @Override
    public FadadaResponse<SignFileDownloadResult> getDownloadUrl(SignFileDownloadRequest request) {
        String accessToken = getAccessToken().getData().getAccessToken();
        String bizContent = toJson(request);

        Map<String, String> h = FadadaCryptUtil.generateSignHeaders(
                fadadaConfig.getAppId(),
                fadadaConfig.getAppSecret(),
                accessToken,
                bizContent
        );

        return fadadaClient.getDownloadUrl(
                fadadaConfig.getAppId(),
                h.get("X-FASC-Sign-Type"),
                h.get("X-FASC-Sign"),
                h.get("X-FASC-Timestamp"),
                h.get("X-FASC-Nonce"),
                accessToken,
                bizContent
        );
    }

    @Override
    public FadadaResponse<ActorSignTaskUrlResult> getActorSignTaskUrl(ActorSignTaskUrlRequest request) {
        String accessToken = getAccessToken().getData().getAccessToken();
        String bizContent = toJson(request);

        Map<String, String> h = FadadaCryptUtil.generateSignHeaders(
                fadadaConfig.getAppId(),
                fadadaConfig.getAppSecret(),
                accessToken,
                bizContent
        );

        return fadadaClient.getActorSignTaskUrl(
                fadadaConfig.getAppId(),
                h.get("X-FASC-Sign-Type"),
                h.get("X-FASC-Sign"),
                h.get("X-FASC-Timestamp"),
                h.get("X-FASC-Nonce"),
                accessToken,
                bizContent
        );
    }

    @Override
    public FadadaResponse<SignTaskDetailResult> getSignTaskDetail(SignTaskDetailRequest request) {
        String accessToken = getAccessToken().getData().getAccessToken();
        String bizContent = toJson(request);

        Map<String, String> h = FadadaCryptUtil.generateSignHeaders(
                fadadaConfig.getAppId(),
                fadadaConfig.getAppSecret(),
                accessToken,
                bizContent
        );

        return fadadaClient.getSignTaskDetail(
                fadadaConfig.getAppId(),
                h.get("X-FASC-Sign-Type"),
                h.get("X-FASC-Sign"),
                h.get("X-FASC-Timestamp"),
                h.get("X-FASC-Nonce"),
                accessToken,
                bizContent
        );
    }

    /**
     * 为了保证接收事件回调Web服务的安全性，法大大提供两种机制保证。
     *
     * 1. IP白名单
     * 为了防止回调服务被攻击，接入方需要在接收事件回调的Web服务配上IP白名单：
     * 环境
     * 公网IP
     * 生产环境
     * 118.89.112.13
     * 115.159.196.132
     *
     * 测试环境
     * 111.229.217.225
     * 111.231.141.181
     *
     * 2. 回调数据带上签名计算
     * 接入方在接收回调事件时，可以对整个回调请求进行签名计算。
     */
    @Override
    public String handleCallback(String bizContent, HttpHeaders headers) {
        // 获取请求头参数
        String appId = headers.getFirst("X-FASC-App-Id");
        String signType = headers.getFirst("X-FASC-Sign-Type");
        String sign = headers.getFirst("X-FASC-Sign");
        String timestamp = headers.getFirst("X-FASC-Timestamp");
        String event = headers.getFirst("X-FASC-Event");
        String nonce = headers.getFirst("X-FASC-Nonce");

        log.info("[Fadada] 收到回调通知 | Event: {} | AppId: {} | Timestamp: {}", event, appId, timestamp);
        log.info("[Fadada] 回调内容 bizContent: {}", bizContent);

        // 1. 验证签名
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("X-FASC-App-Id", appId);
        paramMap.put("X-FASC-Event", event);
        paramMap.put("X-FASC-Sign-Type", signType);
        paramMap.put("X-FASC-Timestamp", timestamp);
        paramMap.put("X-FASC-Nonce", nonce);
        paramMap.put("bizContent", bizContent);

        String paramToSignStr = FadadaCryptUtil.sortParameters(paramMap);
        String expectedSign = FadadaCryptUtil.sign(paramToSignStr, timestamp, fadadaConfig.getAppSecret());

        if (!expectedSign.equals(sign)) {
            log.error("[Fadada] 回调签名校验失败 | 计算得: {} | 收到: {}", expectedSign, sign);
            return "{\"msg\":\"success\"}";
        }

        // todo 2. 处理业务回调？
        log.info("[Fadada] 业务回调暂未实现...");

        return "{\"msg\":\"success\"}";
    }

    private String toJson(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("JSON serialization failed", e);
            return "";
        }
    }

    private String toJsonExcludeNull(Object obj) {
        try {
            // 关键：.setSerializationInclusion(JsonInclude.Include.NON_NULL)
            // 这样生成的 JSON 字符串中，所有值为 null 的属性都会被直接剔除
            return objectMapper.copy()
                    .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                    .writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("JSON serialization failed", e);
            return "";
        }
    }

}
