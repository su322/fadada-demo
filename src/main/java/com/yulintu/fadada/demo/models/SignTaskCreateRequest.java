package com.yulintu.fadada.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 创建签署任务请求参数
 */
@Data
public class SignTaskCreateRequest {
    /**
     * 该签署任务的发起方（扣费主体），需检查授权。长度最大64个字符。
     */
    @NotNull(message = "发起方不能为空")
    private OpenId initiator;

    /**
     * 发起方企业主体Id，不传默认为发起方initiator的主企业Id，适用于一个企业下有多个主体时，便于区分统计
     */
    private String initiatorEntityId;

    /**
     * 该签署任务的发起方成员，即该任务的创建者，可通过查询企业成员列表获取。如不传表示该任务由APPID创建。
     * 在企业主体发起任务时，客户可指定成员id，作为该任务的创建者，该成员可以在SaaS查看、删除、作废该任务等
     */
    private String initiatorMemberId;

    /**
     * 签署任务主题。长度最大200个字符。
     * 其他参与方在收到的通知和打开的页面上都可以醒目地看到该主题，并可作为各参与方管理和检索的关键标题
     */
    @NotBlank(message = "签署任务主题不能为空")
    private String signTaskSubject;

    /**
     * 签署文档类型，默认为contract：
     * contract：合同
     * document：单据
     * credit_auth：征信授权书
     * legal_letter：律师函
     * 注意：
     * 1、单据类型的签署文档只能有一个签署参与方，可添加多个抄送方
     * 2、个人征信授权书中个人类型的参与方只能有一个
     */
    private String signDocType;

    /**
     * 任务截止时间。到期后未完成的签署任务将会逾期作废，不传该参数时不会过期。格式为Unix标准时间戳（毫秒）
     */
    private Long expiresTime;

    /**
     * 合同到期日期，需要大于任务过期时间当天。表示该合同内各方约定的生效时间，用于签署完成后在法大大官网进行合同归档和履约提醒（付费功能）。格式为Unix标准时间戳（毫秒）
     * 如接口设置了initiatorMemberId，则会自动归档，没有设置则需要手动归档
     */
    private Long dueDate;

    /**
     * 是否自动提交签署任务，默认：false不自动提交
     * true：自动提交，即创建签署任务后就完成提交，签署流程开始运转
     * false：不自动提交，则需调用提交签署任务接口后签署任务状态才开始流转
     * 注意：如果设置为true，则必须设置相关文档、参与方等必要信息。
     */
    private Boolean autoStart = false;

    /**
     * 所有签署方签署完成后，签署任务是否自动结束：
     * false: 不自动结束
     * true: 自动结束
     * 默认为true。结束后的签署任务将不可进行任何变动，并将生成签署完成的签名/签章文件(如合同)。
     */
    private Boolean autoFinish = true;

    /**
     * 签署业务类型id，可通过【查询签署业务类型列表】获取，用于区分不同任务的业务类型，方便接入方对任务进行分类管理。
     * 注：如传该字段或模板中关联了业务类型，则模板归属方需与该任务发起方一致
     */
    private Long businessTypeId;

    /**
     * 该签署任务的业务编号。最大30个字符。注：
     * 1、如业务类型id未设置业务编号，则该值无效
     * 2、如业务类型id设置了根据系统规则生成业务编号，则该值无效
     * 3、仅业务类型id设置了业务编号，且业务编号为自定义时该值有效
     */
    private String businessCode;

    /**
     * 发起审批流程Id，可根据【查询审批流程列表】获取。注：
     * 1、传入initiatorMemberId时才会触发发起审批流程
     * 2、在1的前提下，如业务类型businessTypeId已经关联发起审批流程，则以关联的审批流程为准，忽略该值
     * 3、在1的前提下，未传业务类型businessTypeId或未关联发起审批流程时，该值有效
     */
    private String startApprovalFlowId;

    /**
     * 定稿审批流程Id，可根据【查询审批流程列表】获取。注：
     * 1、传入initiatorMemberId，且autoFillFinalize字段为false时，才会触发定稿审批流程
     * 2、在1的前提下，如业务类型businessTypeId已经关联定稿审批流程，则以关联的审批流程为准，忽略该值
     * 3、在1的前提下，未传业务类型businessTypeId或未关联定稿审批流程时，该值有效
     */
    private String finalizeApprovalFlowId;

    /**
     * 签署任务归属的发起方文件夹，设置后发起方可在SaaS端对应文件夹中查看和管理，可通过查询企业签署任务文件夹列表获取catalogId。
     */
    private String catalogId;

    /**
     * 是否自动定稿填写内容（有填写权限参与方时可设置），默认：true自动定稿
     * true：自动定稿，所有填写参与方在填写完成后，不允许再修改文档内容，会将填写内容合成到PDF文档中，签署任务自动流转到签署中状态，签署方可以进行签署
     * false：不自动定稿，所有填写参与方在填写完成后，签署任务状态为填写已完成，需调用定稿签署任务后才可签署
     */
    private Boolean autoFillFinalize = true;

    /**
     * 签署流程是否有序，默认false无序
     * true：有序，签署参与方按照设置顺序依次进行签署。如果要求法大大通知时，会按照顺序依次通知签署方
     * false：无序，签署参与方不分顺序都可进行签署。如果要求法大大通知时，会同时向所有签署方都发送通知
     */
    private Boolean signInOrder = false;

    /**
     * 签名是否要求使用FDA规范，默认false
     * true：要求使用FDA规范签名
     * false：不要求
     */
    private Boolean useFda = false;

    /**
     *
     * 签署任务使用的的文档格式，默认pdf
     * pdf：pdf格式文档，签署时适用国际加密标准
     * ofd：ofd格式文档，签署时适用国密加密标准
     */
    private String fileFormat;

    /**
     * 当签署文件类型fileFormat为OFD时，参数生效。
     * 控制当前OFD文件签署任务签署完成后，是否允许再追加OFD文件，默认为false
     * false：不允许，原OFD文件签署完成后，如再追加新的OFD签署文件，会被认为篡改原文，则原签署完成的签名会验签失败
     *
     * true：允许，原OFD文件签署完成后，如再追加新的OFD签署文件，则原签署完成的签名验签成功
     * 特别注意，追加后的签署任务中，请勿设置水印，否则会导致签名失效
     */
    private Boolean isAllowInsertFile = false;

    /**
     * 免验证签场景码（已审核通过），使用免验证签署时传入，长度最大32字符。场景码的申请可查看帮助文档-免验证签使用说明https://dev.fadada.com/api-help/NKARGFKH4U/MYDPOVUDMCP5T214
     */
    private String businessId;

    /**
     * 业务参考号，长度最大128个字符。该参数用于和签署任务建立关联，例如电商场景订单号。
     */
    private String transReferenceId;

    /**
     * 设置该签署任务的回调事件发送地址，设置该地址后，该任务的相关回调将会发送到该地址中，不会向集成应用中配置的回调地址发送。请确保该地址可以接收到回调信息。
     */
    private String callbackUrl;

    /**
     * 该任务签署完成后，是否给参与方提供文件副本，默认true
     * false：不提供签署文档副本，设置为false时，收件人仅保留签署记录，无法访问或下载文件（签署时会展示用户签署须知）
     * true：提供签署文档副本
     * 注：本地存储的任务不支持设置该值
     */
    private Boolean offerCopies = true;

    /**
     * 待签署的文档列表，文档数上限为50个，一个签署任务中可包含多份文档。任务中展示的顺序以该结构体传入的顺序为准。
     */
    private List<Doc> docs;

    /**
     * 附件列表，附件数上限为50个。
     */
    private List<Attach> attachs;

    /**
     * 参与方列表
     */
    private List<SignTaskActor> actors;

    /**
     * 水印信息，最多设置5条
     */
    private List<Watermark> watermarks;

    /**
     * 签署任务节点信息，如需要多个参与方进行或签，则传此参数。
     * 注：
     * 1、同一个节点中可添加多个参与方进行或签，其中一个签署完成则该节点签署完成
     * 2、同一个节点中的参与方，其签署权限、签署配置信息需一致才可添加
     * 3、需要添加进签署节点中的参与方，在actors结构体中，不可关联填写控件、签署控件
     * 4、同一个节点中的参与方需要填写或签署的控件，在该结构体内的fillFields和signFields中添加
     */
    private List<SignTaskNode> signTaskNodes;
}
