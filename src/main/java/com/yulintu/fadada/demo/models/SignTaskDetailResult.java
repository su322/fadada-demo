package com.yulintu.fadada.demo.models;

import lombok.Data;
import java.util.List;

/**
 * 签署任务详情响应
 */
@Data
public class SignTaskDetailResult {
    /**
     * 该签署任务的发起方。
     */
    private OpenId initiator;

    /**
     * 该签署任务的发起方主体Id。
     */
    private String initiatorEntityId;

    /**
     * 签署任务发起方企业成员id，即创建者成员id。
     */
    private String initiatorMemberId;

    /**
     * 签署任务发起方企业成员名称，即创建者名称。
     */
    private String initiatorMemberName;

    /**
     * 签署任务ID。
     */
    private String signTaskId;

    /**
     * 签署任务的存储类型名称。如为本次存储模板，返回企业设置的本地存储名称，如为法大大云端任务，返回“法大大公有云”
     */
    private String storageType;

    /**
     * 业务参考号，由应用基于自身业务上下文提供。长度最大128个字符。该参数用于应用和签署任务建立关联关系，方便业务流程和数据的关联，例如可以是电商场景的订单号。
     */
    private String transReferenceId;

    /**
     * 签署任务主题。长度最大100个字符。
     */
    private String signTaskSubject;

    /**
     * 签署文档类型：
     * contract：合同
     * document：单据
     */
    private String signDocType;

    /**
     * 签署任务来源，表示该任务是用户在法大大saas创建的或者通过接口创建的。
     * fdd：用户在法大大SaaS创建
     * api：用户通过api接口创建
     */
    private String signTaskSource;

    /**
     * 签署参与方使用的签章证书颁发机构，默认无要求，
     * CFCA：要求使用CFCA（中国金融认证中心）
     * EZCA：要求使用东方中讯CA
     */
    private String certCAOrg;

    /**
     * 签署任务使用的的文档格式，默认pdf
     * pdf：pdf格式文档，签署时适用国际加密标准
     * ofd：ofd格式文档，签署时适用国密加密标准
     */
    private String fileFormat;

    /**
     * 签署任务是否自动定稿
     */
    private Boolean autoFillFinalize;

    /**
     * 签署任务是否自动结束
     */
    private Boolean autoFinish;

    /**
     * 签署任务是否有序签署
     */
    private Boolean signInOrder;

    /**
     * 该签署任务发起审批的审批状态。
     * in-progress：审批中
     * approved：已通过
     * rejected：已驳回
     * cancel：已撤回
     * inValid：已作废
     */
    private String approvalStatus;

    /**
     * 如签署任务发起审批被驳回，审批方填写的驳回原因。
     */
    private String rejectNote;

    /**
     * 创建任务时指定的该签署任务所属的业务类型id
     */
    private Long businessTypeId;

    /**
     * 该签署任务所属的业务类型对应的名称
     */
    private String businessTypeName;

    /**
     * 该签署任务的业务编号。
     */
    private String businessCode;

    /**
     * 如使用模板创建，该签署任务使用的模板id。
     */
    private String templateId;

    /**
     * 签署任务状态，状态流转请查看签署任务状态流转说明：
     * task_created：任务创建中 (签署任务创建中，未提交)
     * finish_creation：已创建（任务完成创建并在审批中）
     * fill_progress：填写中（填写参与方进行填写）
     * fill_completed：填写已完成（填写的所有参与方已完成填写，但尚未定稿）
     * sign_progress：签署中 (签署参与方进行签署)
     * sign_completed：签署已完成 (签署所有参与方均已签署完成)
     * task_finished：任务已完成 (签署任务已成功结束)
     * task_terminated: 任务异常停止 (签署任务已经因为某种原因而停止运行，如因为某方拒填或拒签、撤销)。
     * expired：已逾期
     * abolishing：作废中
     * revoked：已作废
     */
    private String signTaskStatus;

    /**
     * 关联的作废签署任务ID，若任务发起过作废会返回。
     */
    private String abolishedSignTaskId;

    /**
     * 原签署任务ID，仅查询任务为作废签署任务时返回。
     */
    private String originalSignTaskId;

    /**
     * 签署任务是否被撤销：1-已撤销，0-未撤销
     */
    private Boolean cancelStatus;

    /**
     * 签署任务是否异常， 1-发生异常（该值为1时，terminationNote有效），0-无异常
     */
    private Boolean faultStatus;

    /**
     * 签署任务异常停止的原因。
     */
    private String terminationNote;

    /**
     * 签署任务作废的原因。
     */
    private String revokeNote;

    /**
     * 签署任务创建时间。
     */
    private String createTime;

    /**
     * 签署任务的发起时间。
     */
    private String startTime;

    /**
     * 签署任务完成时间(含异常停止)。格式为Unix标准时间戳（毫秒）
     */
    private String finishTime;

    /**
     * 签署任务的截止时间。返回【null】表示长期有效。
     */
    private String deadlineTime;

    /**
     * 合同到期日期，表示该合同内各方约定的生效时间，用于签署完成后在法大大官网进行合同归档和履约提醒（付费功能）。格式为Unix标准时间戳（毫秒）
     */
    private String dueDate;

    /**
     * 文档列表。
     */
    private List<Doc> docs;

    /**
     * 附件列表。
     */
    private List<Attach> attachs;

    /**
     * 参与方列表。
     */
    private List<ActorDetail> actors;

}
