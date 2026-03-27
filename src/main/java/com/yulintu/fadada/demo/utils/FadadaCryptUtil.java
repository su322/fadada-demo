package com.yulintu.fadada.demo.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * 官方的FddCryptUtil没有找到，但是如果用sdk的话应该就不用考虑了吧
 */
public class FadadaCryptUtil {

    /**
     * 将参数按字典序排序并拼接成字符串
     */
    public static String sortParameters(Map<String, String> params) {
        return new TreeMap<>(params).entrySet().stream()
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .collect(Collectors.joining("&"));
    }

    /**
     * 计算签名
     */
    public static String sign(String paramToSignStr, String timestamp, String appSecret) {
        // 1. 对排序后的参数字符串计算摘要，sha256Hex
        String signText = DigestUtils.sha256Hex(paramToSignStr);

        // 2. 用时间戳计算临时签名密钥 (HmacSHA256(appSecret, timestamp))
        byte[] secretSigning = new HmacUtils(HmacAlgorithms.HMAC_SHA_256, appSecret).hmac(timestamp);

        // 3. 计算参数签名并统一转换成小写 (HmacSHA256(secretSigning, signText))
        return new HmacUtils(HmacAlgorithms.HMAC_SHA_256, secretSigning).hmacHex(signText).toLowerCase();
    }

    /**
     * 封装通用的计算签名逻辑
     * @param appId 应用 ID
     * @param appSecret 应用秘钥
     * @param accessToken 访问凭证 (选填)
     * @param bizContent 业务参数 JSON 字符串 (选填)
     * @return 包含签名、时间戳、随机数等信息的 Map
     */
    public static Map<String, String> generateSignHeaders(String appId, String appSecret, String accessToken, String bizContent) {
        return generateSignHeaders(appId, appSecret, accessToken, bizContent, null);
    }

    /**
     * 封装通用的计算签名逻辑（包含 grantType）
     */
    public static Map<String, String> generateSignHeaders(String appId, String appSecret, String accessToken, String bizContent, String grantType) {
        String timestamp = Long.toString(System.currentTimeMillis());
        String nonce = UUID.randomUUID().toString().replace("-", "").substring(0, 32);
        String signType = "HMAC-SHA256";
        String subVersion = "5.1";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("X-FASC-App-Id", appId);
        paramMap.put("X-FASC-Sign-Type", signType);
        paramMap.put("X-FASC-Timestamp", timestamp);
        paramMap.put("X-FASC-Nonce", nonce);
        paramMap.put("X-FASC-Api-SubVersion", subVersion);

        if (accessToken != null && !accessToken.isEmpty()) {
            paramMap.put("X-FASC-AccessToken", accessToken);
        }
        if (bizContent != null && !bizContent.isEmpty()) {
            paramMap.put("bizContent", bizContent);
        }
        if (grantType != null && !grantType.isEmpty()) {
            paramMap.put("X-FASC-Grant-Type", grantType);
        }

        String paramToSignStr = sortParameters(paramMap);
        String signature = sign(paramToSignStr, timestamp, appSecret);

        Map<String, String> result = new HashMap<>(paramMap);
        result.put("X-FASC-Sign", signature);
        return result;
    }

}
