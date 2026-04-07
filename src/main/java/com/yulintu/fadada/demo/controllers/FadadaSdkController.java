package com.yulintu.fadada.demo.controllers;

import com.fasc.open.api.bean.base.BaseRes;
import com.fasc.open.api.exception.ApiException;
import com.fasc.open.api.v5_1.req.app.GetAppOpenIdListReq;
import com.fasc.open.api.v5_1.req.corp.GetCorpAuthResourceUrlReq;
import com.fasc.open.api.v5_1.req.corp.GetCorpReq;
import com.fasc.open.api.v5_1.req.doc.FileProcessReq;
import com.fasc.open.api.v5_1.req.doc.GetKeywordPositionReq;
import com.fasc.open.api.v5_1.req.doc.GetUploadUrlReq;
import com.fasc.open.api.v5_1.req.signtask.*;
import com.fasc.open.api.v5_1.req.user.GetUserAuthUrlReq;
import com.fasc.open.api.v5_1.req.user.GetUserReq;
import com.fasc.open.api.v5_1.res.app.GetAppOpenIdListRes;
import com.fasc.open.api.v5_1.res.common.ECorpAuthUrlRes;
import com.fasc.open.api.v5_1.res.common.EUrlRes;
import com.fasc.open.api.v5_1.res.corp.CorpRes;
import com.fasc.open.api.v5_1.res.doc.FileProcessRes;
import com.fasc.open.api.v5_1.res.doc.GetKeywordPositionRes;
import com.fasc.open.api.v5_1.res.doc.GetUploadUrlRes;
import com.fasc.open.api.v5_1.res.service.AccessTokenRes;
import com.fasc.open.api.v5_1.res.signtask.*;
import com.fasc.open.api.v5_1.res.user.UserRes;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yulintu.fadada.demo.services.FadadaSdkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/fadada/sdk")
public class FadadaSdkController {

    @Autowired
    private FadadaSdkService fadadaSdkService;

    /**
     * 获取访问凭证
     */
    @PostMapping("/service/get-access-token")
    public BaseRes<AccessTokenRes> getToken() throws ApiException {
        return fadadaSdkService.getAccessToken();
    }

    /**
     * 获取个人授权链接
     */
    @PostMapping("/user/get-auth-url")
    public BaseRes<EUrlRes> getUserAuthUrl(@RequestBody GetUserAuthUrlReq request) throws ApiException {
        return fadadaSdkService.getUserAuthUrl(request);
    }

    /**
     * 查询个人授权状态
     */
    @PostMapping("/user/get-auth-state")
    public BaseRes<UserRes> getUserAuthState(@RequestBody GetUserReq query) throws ApiException {
        return fadadaSdkService.getUserAuthState(query);
    }

    /**
     * 获取企业授权链接
     */
    @PostMapping("/corp/get-auth-url")
    public BaseRes<ECorpAuthUrlRes> getCorpAuthUrl(@RequestBody GetCorpAuthResourceUrlReq request) throws ApiException {
        return fadadaSdkService.getCorpAuthUrl(request);
    }

    /**
     * 查询企业授权状态
     */
    @PostMapping("/corp/get-auth-state")
    public BaseRes<CorpRes> getCorpAuthState(@RequestBody GetCorpReq query) throws ApiException {
        return fadadaSdkService.getCorpAuthState(query);
    }

    /**
     * 查询企业成员列表
     */


    /**
     * 上传本地文件
     */
    @PostMapping(value = "/file/upload", consumes = "multipart/form-data")
    public BaseRes<GetUploadUrlRes> upload(
            @RequestPart("file") MultipartFile file,
            @RequestPart("request") String requestJson) throws ApiException, JsonProcessingException {
        // 手动解析 JSON，这样 Spring 不会因为 Content-Type 不匹配而拦截请求
        GetUploadUrlReq request = new ObjectMapper().readValue(requestJson, GetUploadUrlReq.class);

        return fadadaSdkService.uploadFile(file, request);
    }

    /**
     * 文件后处理
     */
    @PostMapping("/file/process")
    public BaseRes<FileProcessRes> fileProcess(@RequestBody FileProcessReq request) throws ApiException {
        return fadadaSdkService.fileProcess(request);
    }

    /**
     * 查询文档关键字坐标
     */
    @PostMapping("/file/get-keyword-positions")
    public BaseRes<List<GetKeywordPositionRes>> getKeywordPositions(@RequestBody GetKeywordPositionReq request) throws ApiException {
        return fadadaSdkService.getKeywordPositions(request);
    }

    /**
     * 创建签署任务(基于文档)
     */
    @PostMapping("/sign-task/create")
    public BaseRes<CreateSignTaskRes> createSignTask(@RequestBody CreateSignTaskReq request) throws ApiException {
        return fadadaSdkService.createSignTask(request);
    }

    /**
     * 获取签署文档下载地址
     */
    @PostMapping("/sign-task/get-download-url")
    public BaseRes<OwnerDownloadUrlRes> getDownloadUrl(@RequestBody GetOwnerDownloadUrlReq request) throws ApiException {
        return fadadaSdkService.getDownloadUrl(request);
    }

    /**
     * 获取参与方签署链接
     */
    @PostMapping("/sign-task/actor/get-url")
    public BaseRes<SignTaskActorGetUrlRes> getActorSignTaskUrl(@RequestBody SignTaskActorGetUrlReq request) throws ApiException {
        return fadadaSdkService.getActorSignTaskUrl(request);
    }

    /**
     * 查询签署任务详情
     */
    @PostMapping("/sign-task/get-detail")
    public BaseRes<SignTaskDetailRes> getSignTaskDetail(@RequestBody SignTaskBaseReq request) throws ApiException {
        return fadadaSdkService.getSignTaskDetail(request);
    }

    /**
     * 获取参与方批量签署链接 todo 这个下面是和前面开始写的FadadaController相比多的接口（如果有），FadadaController没有接着写了
     */
    @PostMapping("/sign-task/actor/get-batch-url")
    public BaseRes<BatchSignUrlRes> getActorBatchSignTaskUrl(@RequestBody GetBatchSignUrlReq request) throws ApiException {
        return fadadaSdkService.getActorBatchSignTaskUrl(request);
    }

    /**
     * 获取签署任务预览链接
     */
    @PostMapping("/sign-task/get-preview-url")
    public BaseRes<GetSignTaskPreviewUrlRes> getSignTaskPreviewUrl(@RequestBody GetSignTaskUrlReq request) throws ApiException {
        return fadadaSdkService.getSignTaskPreviewUrl(request);
    }

    /**
     * 撤销签署任务
     */
    @PostMapping("/sign-task/cancel")
    public BaseRes<Void> cancelSignTask(@RequestBody SignTaskCancelReq request) throws ApiException {
        return fadadaSdkService.cancelSignTask(request);
    }

    /**
     * 作废签署任务
     */
    @PostMapping("/sign-task/abolish")
    public BaseRes<CancelSignTaskCreateRes> abolishSignTask(@RequestBody CancelSignTaskCreateReq request) throws ApiException {
        return fadadaSdkService.abolishSignTask(request);
    }

    /**
     * 查询授权用户列表
     */
    @PostMapping("/app/get-openId-list")
    public BaseRes<GetAppOpenIdListRes> getOpenIdList(@RequestBody GetAppOpenIdListReq request) throws ApiException {
        return fadadaSdkService.getOpenIdList(request);
    }
}
