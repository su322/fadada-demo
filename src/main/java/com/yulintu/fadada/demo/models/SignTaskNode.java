package com.yulintu.fadada.demo.models;

import lombok.Data;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * 签署任务节点信息，如需要多个参与方进行或签，则传此参数。
 * 注：
 * 1、同一个节点中可添加多个参与方进行或签，其中一个签署完成则该节点签署完成
 * 2、同一个节点中的参与方，其签署权限、签署配置信息需一致才可添加
 * 3、需要添加进签署节点中的参与方，在actors结构体中，不可关联填写控件、签署控件
 * 4、同一个节点中的参与方需要填写或签署的控件，在该结构体内的fillFields和signFields中添加
 */
@Data
public class SignTaskNode {
    /**
     * 签署节点名称
     */
    @NotBlank(message = "signTaskNodeName 不能为空")
    private String signTaskNodeName;

    /**
     * 任务节点顺序，如果任务是顺序签，则该节点下的参与方签署顺序需要一致
     */
    private Integer signTaskNodeSort;

    /**
     * 节点权限：
     * fill：仅填写，如传该值，则该节点下的参与方权限需都是fill
     * sign：填写和签署，如传该值，则该节点下的参与方权限需都是sign或fill+sign
     */
    @NotBlank(message = "signTaskNodeRole 不能为空")
    private String signTaskNodeRole;

    /**
     * 该节点下的参与方列表 必传actorId
     */
    @NotEmpty(message = "actors 不能为空")
    private List<Actor> actors;

    /**
     * 该节点下的填写控件，该节点下任意一个参与方可填写
     */
    private List<FillField> fillFields;

    /**
     * 该节点下的签署控件，该节点下任意参与方可签署
     */
    private List<SignField> signFields;
}
