package com.yulintu.fadada.demo.models;

import lombok.Data;

import java.util.List;

/**
 * 查询条件。若多个条件都传值，条件为并且关系。
 */
@Data
public class ListFilter {
    /**
     * 签署任务Id，长度最大20。
     */
    private String signTaskId;

    /**
     * 签署任务名称，如果传了该参数，会根据名称模糊匹配查询，长度最大100个字符。
     */
    private String signTaskSubject;

    /**
     * 参与方名称/手机号/证件号，支持模糊搜索，长度最大100
     */
    private String actorInfo;

    /**
     * 签署任务状态，支持传入多个状态：
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
    private List<String> signTaskStatus;

    /**
     * 筛选任务发起时间的开始时间，格式为Unix标准时间戳（毫秒），与startTimeTo必须同时存在
     */
    private String startTimeFrom;

    /**
     * 筛选任务发起时间的结束时间，格式为Unix标准时间戳（毫秒），与startTimeFrom必须同时存在
     */
    private String startTimeTo;

    /**
     * 筛选任务结束时间的开始时间，格式为Unix标准时间戳（毫秒），与finishTimeTo必须同时存在
     */
    private String finishTimeFrom;

    /**
     * 筛选任务结束时间的结束时间，格式为Unix标准时间戳（毫秒），与finishTimeFrom必须同时存在
     */
    private String finishTimeTo;

    /**
     * 筛选任务到期时间的开始时间，格式为Unix标准时间戳（毫秒），与expiresTimeTo必须同时存在
     */
    private String expiresTimeFrom;

    /**
     * 筛选任务到期时间的结束时间，格式为Unix标准时间戳（毫秒），与expiresTimeFrom必须同时存在
     */
    private String expiresTimeTo;

    /**
     * 签署业务类型id，可通过【查询签署业务类型列表】获取，用于区分不同任务的业务类型，方便接入方对任务进行分类管理
     */
    private String businessTypeId;

    /**
     * 签署任务的业务编号，支持模糊查询，长度最大30
     */
    private String businessCode;
}
