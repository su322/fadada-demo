package com.yulintu.fadada.demo.models;

import lombok.Data;
import java.util.List;

/**
 * 签署配置信息
 */
@Data
public class SignConfigInfo {
    /**
     * 签署序号。signInOrder 字段为 true 有序时，该字段必传，按从小到大顺序排列。
     */
    private Integer orderNo;

    /**
     * 参与方年龄要求，默认无要求
     * no_requirement：无特殊要求
     * above_eighteen：要求签字人 18 岁以上
     * above_sixteen：要求签字人 16 岁以上
     */
    private String ageRequirement;

    /**
     * 指定该参与方签署的印章或签名 Id，仅在参与方未关联任何签署控件时有效。
     */
    private Long freeDragSealId;

    /**
     * 是否要求该参与方在每份待签文档均盖章，仅在参与方未关联任何签署控件时有效，默认false
     * false：不要求
     * true：要求
     */
    private Boolean signAllDoc;

    /**
     * 是否阻塞参与方签署流程。默认为false
     * true： 阻塞，阻塞后暂不向该参与方发送通知和提醒，签署任务也暂停向下流转，需调用解阻签署任务接口将该签署任务解阻，解阻后会触发通知提醒
     * false：不阻塞，正常流转签署
     */
    private Boolean blockHere;

    /**
     * 要求该参与方免验证签，设置后轮到签署时法大大将会自动为该参与方盖章完成签署。默认为false
     * true：是，免验证签署，businessId字段必传，会校验是否已授权，未授权会转为手动签署
     * false： 否，手动签署
     * 免验证签的使用可查看免验证签使用说明https://dev.fadada.com/api-help/NKARGFKH4U/MYDPOVUDMCP5T214
     */
    private Boolean requestVerifyFree;

    /**
     * 签署时进行免验证签授权设置开关（仅针对参与方是【个人】时生效），默认false
     * true： 开启，businessId字段必传
     * false ：关闭
     */
    private Boolean authorizeFreeSign;

    /**
     * 签署意愿确认方式，默认除互动视频签外都支持
     * pw: 签署密码
     * sms: 短信验证
     * face: 刷脸验证（如在小程序中刷脸，请参考小程序集成说明）
     * audio_video：互动视频签（需订购用量）
     */
    private List<String> verifyMethods;

    /**
     * 该参与方的音视频双录文字内容信息，当意愿验证方式为audio_video时才生效，同一个参与方最多设置5条播报内容，5条播报内容合计至少50个字符。
     * 每条内容可包含【播报内容】、【回答】、【是否验证答案】
     */
    private List<AudioVideoInfo> audioVideoInfos;

    /**
     * 企业签署要求经办人签名，默认为false
     * true：要求
     * false：不要求
     */
    private Boolean requestMemberSign;

    /**
     * 个人或企业经办人签名方式，默认为unlimited
     * unlimited: 不限制 (可用系统支持的方式，不包括AI手绘签名)
     * standard: 标准签名 (系统创建的标准签名)
     * hand_write: 手绘签名
     * ai_hand_write: 使用AI手绘签名，手写字迹会通过AI轨迹识别。
     */
    private String signerSignMethod;

    /**
     * 允许企业参与方任意成员通过链接打开签署任务，默认为 true
     * true：允许，任意成员都可以打开
     * false：不允许，只能指定成员才可以打开，参与方actorCorpMembers对象必须设置
     */
    private Boolean joinByLink;

    /**
     * 是否要求该参与方将所有文档（不包含附件）阅读至末页才可签署。默认为false。
     * true：要求，需将所有文档阅读至末页才可签署
     * false：不要求
     */
    private Boolean readingToEnd;

    /**
     * 参与方签署前的最少阅读时间，单位秒，范围 3-300
     */
    private String readingTime;

    /**
     * 是否需要快捷登录签署，快捷登录即打开签署链接后会跳过登录环节进入签署页面，设置后的业务流程效果请见帮助文档-个人快捷签使用说明。默认为false
     * true：跳过登录页，打开链接进入签署页面
     * false：登录后才可进入签署页面
     * 注：
     * （1）该字段仅针对【个人参与方】生效
     * （2）支持除【护照】外的个人实名认证证件类型
     * （3）意愿验证方式仅支持【短信验证、人脸识别】
     * （4）如对抄送方设置该参数为true，可实现抄送方免登查看。
     * 集成场景若想实现用户快捷签署，字段请按照说明传参
     * 有手机号时，freeLogin字段设置为true，identifiedView字段设置为false，accountName字段传入手机号
     */
    private Boolean freeLogin;

    /**
     * 要求参与方必须实名才能查看签署任务（仅针对个人参与方，企业参与方传参不生效），默认true。
     * true：要求实名后才可查看
     * false：不要求，可以先查看后实名
     */
    private Boolean identifiedView;

    /**
     * 参与方在签署页面是否可以调整印章大小，仅在未指定参与方签署控件位置时有效，默认为false。
     * true：可以调整
     * false：不可以调整
     */
    private Boolean resizeSeal;

    /**
     * 该参与方进行多因素验证的方式，默认为用户自行选择
     * mobile_face：实名手机号验证和人脸识别验证
     * bank_face：个人银行卡验证和人脸识别验证
     * 注：仅signDocType为credit_auth，且参与方为个人、任务为二要素签署时该参数有效
     */
    private String multiFactor;

    /**
     * 要求该参与方上传附件信息，每个参与方最多 50 条附件信息
     */
    private List<ActorAttachInfo> actorAttachInfos;
}
