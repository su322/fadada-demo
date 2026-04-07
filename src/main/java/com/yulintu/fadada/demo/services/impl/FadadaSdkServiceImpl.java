package com.yulintu.fadada.demo.services.impl;

import com.fasc.open.api.bean.base.BaseRes;
import com.fasc.open.api.exception.ApiException;
import com.fasc.open.api.v5_1.client.*;
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
import com.yulintu.fadada.demo.client.FadadaClient;
import com.yulintu.fadada.demo.services.FadadaSdkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Slf4j
@Service("fadadaSdkServiceImpl")
public class FadadaSdkServiceImpl implements FadadaSdkService {

    @Autowired
    private FadadaClient fadadaClient;

    @Autowired
    private ServiceClient serviceClient;

    @Autowired
    private UserClient userClient;

    @Autowired
    private CorpClient corpClient;

    @Autowired
    private SignTaskClient signTaskClient;

    @Autowired
    private DocClient docClient;

    @Autowired
    private AppClient appClient;

    @Override
    public BaseRes<AccessTokenRes> getAccessToken() throws ApiException {
        return serviceClient.getAccessToken();
    }

    @Override
    public BaseRes<EUrlRes> getUserAuthUrl(GetUserAuthUrlReq req) throws ApiException {
        return userClient.getUserAuthUrl(req);
    }

    @Override
    public BaseRes<UserRes> getUserAuthState(GetUserReq req) throws ApiException {
        return userClient.get(req);
    }

    @Override
    public BaseRes<GetUploadUrlRes> uploadFile(MultipartFile file, GetUploadUrlReq req) throws ApiException {
        BaseRes<GetUploadUrlRes> uploadFileUrl = docClient.getUploadFileUrl(req);
        String uploadUrl = uploadFileUrl.getData().getUploadUrl();

        try {
            // 将 MultipartFile 转为临时 File 以供 Forest 使用
            File tempFile = File.createTempFile("fdd_upload_", file.getOriginalFilename());
            file.transferTo(tempFile);

            fadadaClient.uploadFile(uploadUrl, tempFile);

            // 上传成功后删除临时文件
            tempFile.delete();
        } catch (Exception e) {
            log.error("上传本地文件到法大大异常", e);
        }
        // 有fddFileUrl
        return uploadFileUrl;
    }

    @Override
    public BaseRes<FileProcessRes> fileProcess(FileProcessReq req) throws ApiException {
        return docClient.process(req);
    }

    @Override
    public BaseRes<List<GetKeywordPositionRes>> getKeywordPositions(GetKeywordPositionReq req) throws ApiException {
        return docClient.getKeywordPosition(req);
    }

    @Override
    public BaseRes<CreateSignTaskRes> createSignTask(CreateSignTaskReq req) throws ApiException {
        return signTaskClient.create(req);
    }

    @Override
    public BaseRes<OwnerDownloadUrlRes> getDownloadUrl(GetOwnerDownloadUrlReq req) throws ApiException {
        return signTaskClient.getOwnerDownloadUrl(req);
    }

    @Override
    public BaseRes<SignTaskActorGetUrlRes> getActorSignTaskUrl(SignTaskActorGetUrlReq req) throws ApiException {
        return signTaskClient.signTaskActorGetUrl(req);
    }

    @Override
    public BaseRes<SignTaskDetailRes> getSignTaskDetail(SignTaskBaseReq req) throws ApiException {
        return signTaskClient.getDetail(req);
    }

    @Override
    public BaseRes<BatchSignUrlRes> getActorBatchSignTaskUrl(GetBatchSignUrlReq req) throws ApiException {
        return signTaskClient.getBatchSignUrl(req);
    }

    @Override
    public BaseRes<GetSignTaskPreviewUrlRes> getSignTaskPreviewUrl(GetSignTaskUrlReq req) throws ApiException {
        return signTaskClient.getSignTaskPreviewUrl(req);
    }

    @Override
    public BaseRes<CorpRes> getCorpAuthState(GetCorpReq req) throws ApiException {
        return corpClient.get(req);
    }

    @Override
    public BaseRes<ECorpAuthUrlRes> getCorpAuthUrl(GetCorpAuthResourceUrlReq req) throws ApiException {
        return corpClient.getCorpAuthUrl(req);
    }

    @Override
    public BaseRes<Void> cancelSignTask(SignTaskCancelReq req) throws ApiException {
        return signTaskClient.cancel(req);
    }

    @Override
    public BaseRes<CancelSignTaskCreateRes> abolishSignTask(CancelSignTaskCreateReq req) throws ApiException {
        return signTaskClient.abolishSignTask(req);
    }

    @Override
    public BaseRes<GetAppOpenIdListRes> getOpenIdList(GetAppOpenIdListReq req) throws ApiException {
        return appClient.getOpenIdList(req);
    }

}
