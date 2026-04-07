package com.yulintu.fadada.demo.services;

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
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FadadaSdkService {

    BaseRes<AccessTokenRes> getAccessToken() throws ApiException;

    BaseRes<EUrlRes> getUserAuthUrl(GetUserAuthUrlReq req) throws ApiException;

    BaseRes<UserRes> getUserAuthState(GetUserReq req) throws ApiException;

    BaseRes<GetUploadUrlRes> uploadFile(MultipartFile file, GetUploadUrlReq req) throws ApiException;

    BaseRes<FileProcessRes> fileProcess(FileProcessReq req) throws ApiException;

    BaseRes<List<GetKeywordPositionRes>> getKeywordPositions(GetKeywordPositionReq req) throws ApiException;

    BaseRes<CreateSignTaskRes> createSignTask(CreateSignTaskReq req) throws ApiException;

    BaseRes<OwnerDownloadUrlRes> getDownloadUrl(GetOwnerDownloadUrlReq req) throws ApiException;

    BaseRes<SignTaskActorGetUrlRes> getActorSignTaskUrl(SignTaskActorGetUrlReq req) throws ApiException;

    BaseRes<SignTaskDetailRes> getSignTaskDetail(SignTaskBaseReq req) throws ApiException;

    BaseRes<BatchSignUrlRes> getActorBatchSignTaskUrl(GetBatchSignUrlReq request) throws ApiException;

    BaseRes<GetSignTaskPreviewUrlRes> getSignTaskPreviewUrl(GetSignTaskUrlReq req) throws ApiException;

    BaseRes<CorpRes> getCorpAuthState(GetCorpReq req) throws ApiException;

    BaseRes<ECorpAuthUrlRes> getCorpAuthUrl(GetCorpAuthResourceUrlReq request) throws ApiException;

    BaseRes<Void> cancelSignTask(SignTaskCancelReq req) throws ApiException;

    BaseRes<CancelSignTaskCreateRes> abolishSignTask(CancelSignTaskCreateReq req) throws ApiException;

    BaseRes<GetAppOpenIdListRes> getOpenIdList(GetAppOpenIdListReq req) throws ApiException;
}
