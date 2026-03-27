package com.yulintu.fadada.demo.models;

import lombok.Data;

/**
 * 签署任务列表查询参数
 */
@Data
public class SignTaskListRequest {
    /**
     * 签署任务发起方或参与方主体，需检查授权。长度最大64个字符。
     */
    private OpenId ownerId;

    /**
     * 主体参与签署协作类型，如不传，则查询主体所有的签署任务：
     * initiator: 发起方
     * actor: 参与方(填写、签署)。
     */
    private String ownerRole;

    /**
     * 在指定的ownerId企业下由指定的memberId参与的任务中，待处理的任务，或待他方处理的任务，默认不筛选
     * owner：待ownerId对应的用户处理的签署任务
     * other：待他方处理的签署任务
     * 注：该参数和ownerRole不能同时存在
     */
    private String pendingRole;

    /**
     * 如为企业主体，则查询由该成员创建的任务。
     * 如传了pendingRole，则查询该企业下由该成员参与的待处理任务
     */
    private String memberId;

    /**
     * 指定查询某个签署文件夹内的任务，catalogId可通过【查询企业签署任务文件夹列表】接口获取
     */
    private String catalogId;

    /**
     * 查询条件。若多个条件都传值，条件为并且关系。
     */
    private ListFilter listFilter;

    /**
     * 查询结果分页返回，此处指定第几页，如果不传默从第一页返回。页码从1开始，即首页为1。
     */
    private Integer listPageNo;

    /**
     * 指定每页多少条数据，如果不传默认为100，单页最大100。
     */
    private Integer listPageSize;
}
