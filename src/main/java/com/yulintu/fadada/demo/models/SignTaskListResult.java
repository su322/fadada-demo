package com.yulintu.fadada.demo.models;

import lombok.Data;
import java.util.List;

/**
 * 签署任务列表查询响应
 */
@Data
public class SignTaskListResult {
    /**
     * 签署任务列表，数组类型。
     */
    private List<SignTask> signTasks;

    /**
     * 列表当前分页，当前第几页。页码从1开始，即首页为1。
     */
    private Integer listPageNo;

    /**
     * 当前返回页中的签署任务数量，即数组大小。
     */
    private Integer countInPage;

    /**
     * 列表总分页数
     */
    private Integer listPageCount;

    /**
     * 查询到的签署任务总数
     */
    private Integer totalCount;
}
