package com.yulintu.fadada.demo.services;

import com.fasc.open.api.exception.ApiException;
import com.yulintu.fadada.demo.models.*;
import org.springframework.http.HttpHeaders;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FadadaService {
    /**
     * 获取访问凭证
     * @return 接口返回的封装对象
     */
    FadadaResponse<FadadaToken> getAccessToken();

    /**
     * 获取个人授权链接
     * @param request 请求参数
     * @return 授权链接响应
     */
    FadadaResponse<UserAuthUrl> getUserAuthUrl(UserAuthRequest request);

    /**
     * 查询个人授权状态
     * @param query 查询参数
     * @return 授权状态响应
     */
    FadadaResponse<UserAuthState> getUserAuthState(UserAuthQuery query);

    /**
     * 上传本地文件
     * @param file 外部传入的 MultipartFile
     * @param request 获取上传地址请求
     * @return 文件上传结果
     */
    FadadaResponse<FileUploadUrl> uploadFile(MultipartFile file, FileUploadUrlRequest request);

    /**
     * 文件后处理
     * @param request 处理参数
     * @return 处理结果
     */
    FadadaResponse<FileProcessResult> fileProcess(FileProcessRequest request);

    /**
     * ��询文档关键字坐标
     * @param request 查询参数
     * @return 坐标结果
     */
    FadadaResponse<List<KeywordPositionResult>> getKeywordPositions(KeywordPositionRequest request);

    /**
     * 创建签署任务(基于文档)
     * @param request 创建参数
     * @return 创建结果
     */
    FadadaResponse<SignTaskCreateResult> createSignTask(SignTaskCreateRequest request);

    /**
     * 获取签署文档下载地址
     * @param request 下载请求参数
     * @return 下载地址结果
     */
    FadadaResponse<SignFileDownloadResult> getDownloadUrl(SignFileDownloadRequest request);

    /**
     * 获取参与方签署链接
     * @param request 请求参数
     * @return 签署链接结果
     */
    FadadaResponse<ActorSignTaskUrlResult> getActorSignTaskUrl(ActorSignTaskUrlRequest request);

    /**
     * 查询签署任务详情
     * @param request 查询参数
     * @return 详情结果
     */
    FadadaResponse<SignTaskDetailResult> getSignTaskDetail(SignTaskDetailRequest request);

    /**
     * 处理法大大异步通知（包含有效性校验）
     * @param bizContent 业务内容
     * @param headers 请求头
     * @return 响应结果
     */
    String handleCallback(String bizContent, HttpHeaders headers);
}
