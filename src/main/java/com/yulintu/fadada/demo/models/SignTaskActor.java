package com.yulintu.fadada.demo.models;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 签署任务参与方信息
 */
@Data
public class SignTaskActor {
    /**
     * 参与方基本信息。支持抄送类型参与方
     */
    @NotNull(message = "actor 不能为空")
    private Actor actor;

    /**
     * 设置参与方的填写控件（填写权限的参与方可设置），即为填写人设置在文档某个位置填写什么内容
     */
    private List<FillField> fillFields;

    /**
     * 设置参与方的签章控件（签署权限的参与方可设置），设置后签署人只能在控件位置盖章，不设置可在文档任意位置加盖。
     */
    private List<SignField> signFields;

    /**
     * 签署配置信息
     */
    private SignConfigInfo signConfigInfo;
}
