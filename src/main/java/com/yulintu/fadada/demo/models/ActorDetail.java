package com.yulintu.fadada.demo.models;

import lombok.Data;
import java.util.List;

/**
 * 参与方详情
 */
@Data
public class ActorDetail {
    /**
     * 参与方基本信息。
     */
    private Actor actorInfo;

    /**
     * 参与方权限列表：
     * fill: 填写和确认内容；
     * sign: 确定签署
     * cc：抄送
     */
    private List<String> permissions;

    /**
     * 参与方是否是发起方
     */
    private Boolean isInitiator;

    /**
     * 签署权限参与方关联的签章控件列表。
     */
    private List<SignField> signFields;

    /**
     * 参与方阅读状态：
     * no_read: 未读
     * read: 已读。
     */
    private String readStatus;

    /**
     * 阅读时间。格式为Unix标准时间戳（毫秒）
     */
    private String readTime;

    /**
     * 参与方加入状态：
     * no_join: 未加入
     * joined: 已加入。
     */
    private String joinStatus;

    /**
     * 加入时间。格式为Unix标准时间戳（毫秒）
     */
    private String joinTime;

    /**
     * 参与方填写状态：
     * wait_fill: 待填写
     * filled: 已填写
     * fill_rejected: 已拒填 (拒绝了填写)。
     * 注意：只有填写权限的参与方返回此参数值。
     */
    private String fillStatus;

    /**
     * 最后的填写操作时间。格式为Unix标准时间戳（毫秒）
     */
    private String fillTime;

    /**
     * 参与方签署状态：
     * wait_sign: 待签署 (等待签署)
     * signed: 已签署 (已完成签署)
     * sign_rejected: 已拒签 (拒绝了签署)。
     * 注意：只有签署权限的参与方返回此参数值。
     */
    private String signStatus;

    /**
     * 该参与方拒填、拒签、或填写内容被驳回的原因。
     */
    private String actorNote;

    /**
     * 最后的签署操作时间。格式为Unix标准时间戳（毫秒）
     */
    private String signTime;

    /**
     * 参与方签署序号。当前为签署操作且有序签时有效。
     * 注意：只有签署权限的参与方返回此参数值。
     */
    private Integer signOrderNo;

    /**
     * 是否设置了阻塞该参与方：
     * blocked：阻塞中(参与方被阻塞)
     * unblocked：未阻塞(参与方未阻塞)。
     * 注意：只有签署权限的参与方返回此参数值。
     */
    private String blockStatus;

    /**
     * 参与方签署短链接。该链接由应用主动分发给对应参与方。
     * 注意： 需要参与方使用自己的法大大帐号进行登录访问
     */
    private String actorSignTaskUrl;

    /**
     * 参与方签署长链接。该链接由应用主动分发给对应参与方，可嵌入小程序或iframe
     * 注意： 需要参与方使用法大大帐号进行登录访问
     */
    private String actorSignTaskEmbedUrl;
}

