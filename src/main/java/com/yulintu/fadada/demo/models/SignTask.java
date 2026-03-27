package com.yulintu.fadada.demo.models;

import lombok.Data;
import java.util.List;

/**
 * 签署任务主体信息
 */
@Data
public class SignTask {
    /**
     * 业务流水号，由调用方提供，长度最大32个字符。
     */
    private String businessId;

    /**
     * 任务标题，长度最大50个字符。
     */
    private String taskSubject;

    /**
     * 签署任务截止时间，格式：yyyy-MM-dd HH:mm:ss。
     * 过期后，任务将自动关闭，未签署的用户将无法签署。
     */
    private String taskExpireTime;

    /**
     * 签署顺序，默认为 false：无序。
     * true：有序，按照参与方的 orderNo 顺序流转进行签署。
     */
    private Boolean signInOrder = false;

    /**
     * 任务备注。
     */
    private String remark;

    // 以下为查询签署任务列表返回的信息字段
    /**
     * 签署任务id。
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
     * 签署任务来源，表示该任务是用户在法大大saas创建的或者通过接口创建的。
     * fdd：用户在法大大SaaS创建
     * api：用户通过api接口创建
     */
    private String signTaskSource;

    /**
     * 签署任务主题，长度最大100个字符。
     */
    private String signTaskSubject;

    /**
     * 若该签署任务关联了发起审批流，当前的审批状态。
     * in_progress：审批中
     * approved：已通过
     * rejected：已驳回
     * cancel：已撤回
     * inValid：已作废
     */
    private String approvalStatus;

    /**
     * 如审批被驳回，审批方填写的驳回原因。
     */
    private String rejectNote;

    /**
     * 该签署任务在SaaS的文件夹id。
     */
    private String catalogId;

    /**
     * 该签署任务在SaaS的文件夹名称。
     */
    private String catalogName;

    /**
     * 该签署任务所属的业务类型id。
     */
    private Long businessTypeId;

    /**
     * 该签署任务所属的业务类型名称。
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
     * 签署任务状态，状态流转请查看签署任务状态流转说明：https://dev.fadada.com/api-help/ACJJHJQUCG/QBHKD80O7Y4QAHA3
     * task_created: 任务创建中 (签署任务创建中，未提交)
     * finish_creation：已创建（任务完成创建并在审批中）
     * fill_progress: 填写进行中 (签署任务正在进行协同填写流程阶段，必填控件尚未填完)
     * fill_completed: 填写已完成 (签署任务文档中所有的必填控件均已填写，但文档尚未定稿)
     * sign_progress: 签署进行中 (签署任务正在进行签署流程阶段)
     * sign_completed: 签署已完成 (签署任务所有参与方均已签署完成)
     * task_finished: 任务已结束 (签署任务已成功结束)
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
     * 签署任务异常停止的原因。
     */
    private String terminationNote;

    /**
     * 该签署任务的发起方名称，如果是个人即姓名，如果是企业即企业全称。
     */
    private String initiatorName;

    /**
     * 签署任务发起方企业成员id，即创建者成员id。
     */
    private String initiatorMemberId;

    /**
     * 签署任务创建时间。格式为Unix标准时间戳（毫秒）
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
     * 任务中参与方信息 actorName actorId
     */
    private List<Actor> actorResults;
}

