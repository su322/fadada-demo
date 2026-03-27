package com.yulintu.fadada.demo.models;

import lombok.Data;
import javax.validation.constraints.NotBlank;

/**
 * 查询签署任务详情请求
 */
@Data
public class SignTaskDetailRequest {
    /**
     * 签署任务ID
     */
    @NotBlank(message = "signTaskId 不能为空")
    private String signTaskId;
}
