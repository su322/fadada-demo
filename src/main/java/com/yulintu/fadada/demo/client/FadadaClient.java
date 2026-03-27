package com.yulintu.fadada.demo.client;

import com.dtflys.forest.annotation.*;
import com.dtflys.forest.http.ForestResponse;
import com.yulintu.fadada.demo.models.FadadaResponse;
import com.yulintu.fadada.demo.models.FadadaToken;
import com.yulintu.fadada.demo.interceptor.FadadaResponseInterceptor;
import com.yulintu.fadada.demo.models.UserAuthUrl;
import com.yulintu.fadada.demo.models.UserAuthRequest;
import com.yulintu.fadada.demo.models.UserAuthState;
import com.yulintu.fadada.demo.models.UserAuthQuery;
import com.yulintu.fadada.demo.models.CorpAuthUrl;
import com.yulintu.fadada.demo.models.CorpAuthRequest;
import com.yulintu.fadada.demo.models.CorpAuthState;
import com.yulintu.fadada.demo.models.CorpAuthQuery;
import com.yulintu.fadada.demo.models.FileUploadUrl;
import com.yulintu.fadada.demo.models.FileUploadUrlRequest;
import com.yulintu.fadada.demo.models.FileProcessRequest;
import com.yulintu.fadada.demo.models.FileProcessResult;
import com.yulintu.fadada.demo.models.SignTaskCreateRequest;
import com.yulintu.fadada.demo.models.SignTaskCreateResult;
import com.yulintu.fadada.demo.models.SignTaskListRequest;
import com.yulintu.fadada.demo.models.SignTaskListResult;
import com.yulintu.fadada.demo.models.SignFileDownloadRequest;
import com.yulintu.fadada.demo.models.SignFileDownloadResult;
import com.yulintu.fadada.demo.models.KeywordPositionRequest;
import com.yulintu.fadada.demo.models.KeywordPositionResult;
import com.yulintu.fadada.demo.models.ActorSignTaskUrlRequest;
import com.yulintu.fadada.demo.models.ActorSignTaskUrlResult;
import com.yulintu.fadada.demo.models.SignTaskDetailRequest;
import com.yulintu.fadada.demo.models.SignTaskDetailResult;

import java.io.File;
import java.util.List;

/**
 * todo 请求头的后面都在拦截器统一处理？
 */
@BaseRequest(
        baseURL = "${fadada.endpoint}",
        interceptor = FadadaResponseInterceptor.class
)
public interface FadadaClient {
    /**
     * 获取服务访问凭证
     */
    @Post("/service/get-access-token")
    FadadaResponse<FadadaToken> getAccessToken(
            @Header("X-FASC-App-Id") String appId,
            @Header("X-FASC-Sign-Type") String signType,
            @Header("X-FASC-Sign") String sign,
            @Header("X-FASC-Timestamp") String timestamp,
            @Header("X-FASC-Nonce") String nonce,
            @Header("X-FASC-Grant-Type") String grantType,
            @Header("X-FASC-Api-SubVersion") String subVersion
    );

    /**
     * 获取个人授权链接
     */
    @Post("/user/get-auth-url")
    FadadaResponse<UserAuthUrl> getUserAuthUrl(
            @Header("X-FASC-App-Id") String appId,
            @Header("X-FASC-Sign-Type") String signType,
            @Header("X-FASC-Sign") String sign,
            @Header("X-FASC-Timestamp") String timestamp,
            @Header("X-FASC-Nonce") String nonce,
            @Header("X-FASC-AccessToken") String accessToken,
            @Body("bizContent") String bizContent
    );

    /**
     * 获取企业授权链接
     */
    @Post("/corp/get-auth-url")
    FadadaResponse<CorpAuthUrl> getCorpAuthUrl(
            @Header("X-FASC-App-Id") String appId,
            @Header("X-FASC-Sign-Type") String signType,
            @Header("X-FASC-Sign") String sign,
            @Header("X-FASC-Timestamp") String timestamp,
            @Header("X-FASC-Nonce") String nonce,
            @Header("X-FASC-AccessToken") String accessToken,
            @Body("bizContent") String bizContent
    );

    /**
     * 查询个人授权状态
     */
    @Post("/user/get")
    FadadaResponse<UserAuthState> getUser(
            @Header("X-FASC-App-Id") String appId,
            @Header("X-FASC-Sign-Type") String signType,
            @Header("X-FASC-Sign") String sign,
            @Header("X-FASC-Timestamp") String timestamp,
            @Header("X-FASC-Nonce") String nonce,
            @Header("X-FASC-AccessToken") String accessToken,
            @Body("bizContent") String bizContent
    );

    /**
     * 查询企业授权状态
     */
    @Post("/corp/get")
    FadadaResponse<CorpAuthState> getCorp(
            @Header("X-FASC-App-Id") String appId,
            @Header("X-FASC-Sign-Type") String signType,
            @Header("X-FASC-Sign") String sign,
            @Header("X-FASC-Timestamp") String timestamp,
            @Header("X-FASC-Nonce") String nonce,
            @Header("X-FASC-AccessToken") String accessToken,
            @Body("bizContent") String bizContent
    );

    /**
     * 获取文件上传地址
     */
    @Post("/file/get-upload-url")
    FadadaResponse<FileUploadUrl> getUploadUrl(
            @Header("X-FASC-App-Id") String appId,
            @Header("X-FASC-Sign-Type") String signType,
            @Header("X-FASC-Sign") String sign,
            @Header("X-FASC-Timestamp") String timestamp,
            @Header("X-FASC-Nonce") String nonce,
            @Header("X-FASC-AccessToken") String accessToken,
            @Body("bizContent") String bizContent
    );

    /**
     * 上传本地文件 (PUT 请求)
     * 对应原生代码的 PUT 上传逻辑，忽略响应体解析，仅获取响应结果
     */
    @Put(url = "{url}")
    @Header(name = "Content-Type", value = "application/octet-stream")
    ForestResponse uploadFile(@Var("url") String url, @Body File file);

    /**
     * 文件后处理
     * 接口说明
     * 应用上传文件成功后，在签署任务中使用上传的文件，需要先通过接口对文件进行后处理生成文件fileId，在后续发起签署创建签署任务相关接口中会需要使用fileId。
     * <p>
     * 注意：
     * 1、【文档用途】类型支持：
     * （1）如使用pdf格式签署，支持doc、docx、wps、pdf、xls、xlsx、jpg、jpeg、png、bmp格式转为pdf格式
     * （2）如使用ofd格式签署，支持doc、docx、xls、xlsx、ofd格式转为ofd格式
     * 2、【附件用途】文件支持 doc、docx、wps、jpg、jpeg、png、pdf、xls、xlsx、zip、rar、mp4、amr、mp3、wav、tiff、txt 、ofd格式
     * 3、文件名称需要与上传文件名保持一致，包含扩展名。文件名不支持以下9个字符：/ \ : * " < >|?
     * 4、签署文件一定是pdf或ofd格式，因此若是文档用途的源文件不是pdf或ofd，通过该接口处理后，会将源文件转换成pdf或ofd格式
     * 5、文件最多不超过1000页
     */
    @Post("/file/process")
    FadadaResponse<FileProcessResult> fileProcess(
            @Header("X-FASC-App-Id") String appId,
            @Header("X-FASC-Sign-Type") String signType,
            @Header("X-FASC-Sign") String sign,
            @Header("X-FASC-Timestamp") String timestamp,
            @Header("X-FASC-Nonce") String nonce,
            @Header("X-FASC-AccessToken") String accessToken,
            @Body("bizContent") String bizContent
    );

    /**
     * 创建签署任务(基于文档)
     * 接口说明
     * 创建一个签署任务。该接口可创建一个简单的或要素完备的签署任务，因此可选参数较多，主要的参数对应页面上的字段展示可查看文章末尾的【接口参数对照图说明】，建议阅读便于对接口字段的理解，控件说明请见帮助文档-签署控件说明
     * <p>
     * 创建签署任务接口方式：
     * <p>
     * 【推荐】提前准备好签署任务要素信息，创建包含文档、参与方等要素完善的签署任务， 只需调用一次接口，无需再调用其他接口。
     * 【推荐】创建一个签署任务，后续通过获取签署任务编辑链接，在编辑页面完善签署任务要素，或进行控件设置，通过API+EUI配合可以减少接口调用次数。
     * 【非特殊情况不推荐该方式】创建一个空白的签署任务，即暂不包含任何文档和参与方等核心要素，后续调用添加签署任务文档、添加签署任务参与方等接口添加和完善签署任务要素，这种方式会调用多个接口才可完成创建。
     * 授权要求： 个人/企业用户进行授权【signtask_init: 授权允许发起签署任务】后方可调用该接口，若未获得授权请先调用获取个人授权链接或获取企业授权链接提供给用户进行授权，集成应用所属企业默认已授权。
     * <p>
     * 免验证签署： 若企业/个人想实现自动落章/签名，无需进入签署页面手动签署。具体使用请查看免验证签使用说明
     * <p>
     * 注意：
     * <p>
     * 如果创建时未设置自动提交，后续需要调用提交签署任务接口，签署任务才会流转到内容定稿阶段。如果创建时设置自动提交，将会检查是否满足提交条件，若不满足提交条件，任务将会创建失败。
     * 如果创建时未设置自动定稿，后续需要调用定稿签署任务接口，签署任务才会流转到签署阶段。如果创建时设置自动定稿 且 设置自动提交，任务在自动提交成功后，将会自动定稿并流转到签署阶段。
     */
    @Post("/sign-task/create")
    FadadaResponse<SignTaskCreateResult> createSignTask(
            @Header("X-FASC-App-Id") String appId,
            @Header("X-FASC-Sign-Type") String signType,
            @Header("X-FASC-Sign") String sign,
            @Header("X-FASC-Timestamp") String timestamp,
            @Header("X-FASC-Nonce") String nonce,
            @Header("X-FASC-AccessToken") String accessToken,
            @Body("bizContent") String bizContent
    );

    /**
     * 查询签署任务列表
     */
    @Post("/sign-task/owner/get-list")
    FadadaResponse<SignTaskListResult> getSignTaskList(
            @Header("X-FASC-App-Id") String appId,
            @Header("X-FASC-Sign-Type") String signType,
            @Header("X-FASC-Sign") String sign,
            @Header("X-FASC-Timestamp") String timestamp,
            @Header("X-FASC-Nonce") String nonce,
            @Header("X-FASC-AccessToken") String accessToken,
            @Body("bizContent") String bizContent
    );

    /**
     * 获取签署文档下载地址
     * 接入方根据该接口返回的下载地址下载具体的签署文档或附件。
     * 接口说明
     * 获取签署文档的下载地址，接入方根据该接口返回的下载地址下载具体的签署文档或附件。
     * <p>
     * 如果根据指定参数查询签署任务，查询到单个文件时，打开链接下载该单个文件：
     * （1）如请求参数中未传“customName”，则文件名为签署任务主题；
     * （2）如请求参数中传了“customName”，则文件名为customName对应的值。
     * 如果根据指定参数查询签署任务，查询到多个文件，打开链接下载一个zip压缩包文件：
     * （1）如请求参数中未传“customName”，则压缩包名称为时间戳，解压目录结构如下：
     * 时间戳
     * - attachment  // 附件子目录。如果没有附件，则无。附件名称与签署任务中保持一致，如有多份文件名称一致，则会在后面增加（n）。
     * - 参考资料.doc
     * - 补充资料.doc
     * - document    // 文档子目录。如果没有文档，则无。文档名称与签署任务中保持一致，如有多份文件名称一致，则会在后面增加（n）。
     * - 买卖合同.pdf
     * - 补充合同.pdf
     * （2）如请求参数中传了“customName”，则压缩包名称为customName对应的值，解压目录结构如下：
     * 请求参数中customName对应的值
     * - attachment  // 附件子目录。如果没有附件，则无。附件名称与签署任务中保持一致。
     * - 参考资料.doc
     * - 补充资料.doc
     * - document    // 文档子目录。如果没有文档，则无。文档名称与签署任务中保持一致。
     * - 买卖合同.pdf
     * 授权要求： 个人/企业用户进行授权【signtask_file： 授权允许获取个人用户的签署文件】后方可调用该接口，若未获得授权请先调用获取个人授权链接或获取企业授权链接提供给用户进行授权，集成应用所属企业默认已授权。
     */
    @Post("/sign-task/owner/get-download-url")
    FadadaResponse<SignFileDownloadResult> getDownloadUrl(
            @Header("X-FASC-App-Id") String appId,
            @Header("X-FASC-Sign-Type") String signType,
            @Header("X-FASC-Sign") String sign,
            @Header("X-FASC-Timestamp") String timestamp,
            @Header("X-FASC-Nonce") String nonce,
            @Header("X-FASC-AccessToken") String accessToken,
            @Body("bizContent") String bizContent
    );

    /**
     * 获取参与方签署链接
     * 接口说明
     * 在签署任务 提交 后，接入方可以获取签署任务各个参与方的签署链接分发给各方进行签署，适用于自行通知的场景。
     * <p>
     * 注：若通过法大大平台通知的可无需调用该接口
     */
    @Post("/sign-task/actor/get-url")
    FadadaResponse<ActorSignTaskUrlResult> getActorSignTaskUrl(
            @Header("X-FASC-App-Id") String appId,
            @Header("X-FASC-Sign-Type") String signType,
            @Header("X-FASC-Sign") String sign,
            @Header("X-FASC-Timestamp") String timestamp,
            @Header("X-FASC-Nonce") String nonce,
            @Header("X-FASC-AccessToken") String accessToken,
            @Body("bizContent") String bizContent
    );

    /**
     * 查询文档关键字坐标
     * 应用上传文件并得到fileId后，可根据此接口获取文档中的关键字坐标
     */
    @Post("/file/get-keyword-positions")
    FadadaResponse<List<KeywordPositionResult>> getKeywordPositions(
            @Header("X-FASC-App-Id") String appId,
            @Header("X-FASC-Sign-Type") String signType,
            @Header("X-FASC-Sign") String sign,
            @Header("X-FASC-Timestamp") String timestamp,
            @Header("X-FASC-Nonce") String nonce,
            @Header("X-FASC-AccessToken") String accessToken,
            @Body("bizContent") String bizContent
    );

    /**
     * 查询签署任务详情
     */
    @Post("/sign-task/app/get-detail")
    FadadaResponse<SignTaskDetailResult> getSignTaskDetail(
            @Header("X-FASC-App-Id") String appId,
            @Header("X-FASC-Sign-Type") String signType,
            @Header("X-FASC-Sign") String sign,
            @Header("X-FASC-Timestamp") String timestamp,
            @Header("X-FASC-Nonce") String nonce,
            @Header("X-FASC-AccessToken") String accessToken,
            @Body("bizContent") String bizContent
    );

}
