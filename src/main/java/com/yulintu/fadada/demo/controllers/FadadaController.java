//package com.yulintu.fadada.demo.controllers;
//
//import com.yulintu.fadada.demo.models.*;
//import com.yulintu.fadada.demo.services.FadadaService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestPart;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/fadada")
//public class FadadaController {
//
//    @Autowired
//    private FadadaService fadadaService;
//
//    /**
//     * 法大大异步通知回调接收接口 todo 需要在法大大配置可访问的外网地址
//     */
//    @PostMapping(value = "/callback", consumes = "application/x-www-form-urlencoded")
//    public String callback(@RequestParam("bizContent") String bizContent, @RequestHeader HttpHeaders headers) {
//        return fadadaService.handleCallback(bizContent, headers);
//    }
//
//    /**
//     * 获取访问凭证
//     */
//    @PostMapping("/service/get-access-token")
//    public FadadaResponse<FadadaToken> getToken() {
//        return fadadaService.getAccessToken();
//    }
//
//    /**
//     * 获取个人授权链接
//     */
//    @PostMapping("/user/get-auth-url")
//    public FadadaResponse<UserAuthUrl> getUserAuthUrl(@RequestBody UserAuthRequest request) {
//        return fadadaService.getUserAuthUrl(request);
//    }
//
//    /**
//     * 查询个人授权状态
//     */
//    @PostMapping("/user/get-auth-state")
//    public FadadaResponse<UserAuthState> getUserAuthState(@RequestBody UserAuthQuery query) {
//        return fadadaService.getUserAuthState(query);
//    }
//
//    /**
//     * 上传本地文件
//     */
//    @PostMapping(value = "/file/upload", consumes = "multipart/form-data")
//    public FadadaResponse<FileUploadUrl> upload(
//            @RequestPart("file") MultipartFile file,
//            @RequestPart("request") FileUploadUrlRequest request) {
//        return fadadaService.uploadFile(file, request);
//    }
//
//    /**
//     * 文件后处理
//     */
//    @PostMapping("/file/process")
//    public FadadaResponse<FileProcessResult> fileProcess(@RequestBody FileProcessRequest request) {
//        return fadadaService.fileProcess(request);
//    }
//
//    /**
//     * 查询文档关键字坐标
//     */
//    @PostMapping("/file/get-keyword-positions")
//    public FadadaResponse<List<KeywordPositionResult>> getKeywordPositions(@RequestBody KeywordPositionRequest request) {
//        return fadadaService.getKeywordPositions(request);
//    }
//
//    /**
//     * 创建签署任务(基于文档)
//     */
//    @PostMapping("/sign-task/create")
//    public FadadaResponse<SignTaskCreateResult> createSignTask(@RequestBody SignTaskCreateRequest request) {
//        return fadadaService.createSignTask(request);
//    }
//
//    /**
//     * 获取签署文档下载地址
//     */
//    @PostMapping("/sign-task/get-download-url")
//    public FadadaResponse<SignFileDownloadResult> getDownloadUrl(@RequestBody SignFileDownloadRequest request) {
//        return fadadaService.getDownloadUrl(request);
//    }
//
//    /**
//     * 获取参与方签署链接
//     */
//    @PostMapping("/sign-task/actor/get-url")
//    public FadadaResponse<ActorSignTaskUrlResult> getActorSignTaskUrl(@RequestBody ActorSignTaskUrlRequest request) {
//        return fadadaService.getActorSignTaskUrl(request);
//    }
//
//    /**
//     * 查询签署任务详情
//     */
//    @PostMapping("/sign-task/get-detail")
//    public FadadaResponse<SignTaskDetailResult> getSignTaskDetail(@RequestBody SignTaskDetailRequest request) {
//        return fadadaService.getSignTaskDetail(request);
//    }
//
//    @GetMapping("/test")
//    public String test() {
//        return "Test successful!";
//    }
//}
