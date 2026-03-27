package com.yulintu.fadada.demo.models;

import java.util.List;

import lombok.Data;

/**
 * 签署任务参与方对象，包含基本信息、权限数组、主体标识信息、企业成员列表、主体匹配信息等。
 */
@Data
public class Actor {
    /**
     * 参与方标识。在同一个签署任务中，参与方标识唯一，不允许重复。长度最大32个字符。例如：
     * - 常用的简单标识：甲方、乙方、丙方 ...
     * - 金融信贷场景：借款人、贷款人 ...
     * - 供应链场景：核心企业、供应商 ...
     * - 劳动合同场景：用人单位、劳动者 ...
     */
    private String actorId;

    /**
     * 参与方主体类型：
     * corp: 企业
     * person: 个人
     */
    private String actorType;

    /**
     * 参与方具体名称。长度最大128个字符。
     * 注意：
     * 1）actorName与actorId是针对同一个参与方的不同描述
     */
    private String actorName;

    /**
     * 参与方权限
     * fill：填写
     * sign：签署
     * cc：抄送
     * receiver：仅确认
     * deliver：确认送达
     * operator_sign：仅经办人签字
     * 注：sign、operator_sign、cc 不可同时传入
     */
    private List<String> permissions;

    /**
     * 参与方主体在应用上的OpenId，用于参与方主体身份识别。长度最大64个字符。
     * 1）非应用上用户，无OpenId场景，该参数不用传，用户可通过法大大外部签署链接进行签署
     * 2）应用上的用户，用户需要通过获取企业授权链接或获取个人授权链接拿到openCorpId/openUserId
     */
    private String actorOpenId;

    /**
     * 参与方主体的法大大号，用于参与方主体身份识别，长度最大20个字符。
     * actorType为corp：则为企业法大大号。
     * actorType为person：则为个人法大大号。
     * 注意：1、若同时指定actorOpenId和actorFDDId参与，需要同时验证主体身份一致性。如不一致，将会校验报错。2、该字段不支持指定成员企业，如需指定成员企业，请指定actorEntityId
     */
    private String actorFDDId;

    /**
     * 参与方企业主体Id，可通过查询企业主体列表获取。在指定actorOpenId或actorFDDId时可进一步指定主体Id，表示由企业帐号下的具体主体参与签署，不传默认为actorOpenId或actorFDDId对应的主企业Id。指定该字段后，该参与方仅可使用该主体加入任务，并使用该主体的印章进行签署。
     */
    private String actorEntityId;

    /**
     * 参与方企业成员列表，必须指定actorOpenId或actorFDDId，否则接口会进行报错拦截，且成员必须是已激活状态
     * 如：创建任务时能提前获取参与方用印员成员ID，可以提前指定该企业成员做为企业的经办人。
     */
    private List<ActorCorpMember> actorCorpMembers;

    /**
     * 参与方身份名称（个人姓名或企业全称），最大100个字符。设置后在访问签署任务时会校验身份，一致才会允许访问。
     * 注意：如已传actorOpenId或actorFDDId，该字段将会被忽略。
     * 如需签署人与指定信息一致，强烈建议传此参数
     */
    private String identNameForMatch;

    /**
     * 个人参与方证件类型，如传certNoForMatch则默认为身份证，如不传certNoForMatch则由用户在页面中选择
     * 如已传actorOpenId或actorFDDId，该字段将会被忽略。
     * id_card: 身份证
     * hk_mac_rp：港澳居民居住证
     * taiwan_rp：台湾居民居住证
     * foreign_prc：外国人永久居留身份证
     * passport: 护照
     * hk_macao: 港澳居民来往内地通行证
     * taiwan: 台湾居民来往大陆通行证
     * hk_macao_foreigner：港澳居民来往内地通行证(非中国籍)
     */
    private String certType;

    /**
     * 参与方证件号码（个人证件号或企业统信码），最大32个字符。设置后在访问签署任务时会校验身份，一致才会允许访问。
     * 注意：如已传actorOpenId或actorFDDId，该字段将会被忽略。
     * 如需签署人与指定信息一致，强烈建议传此参数
     */
    private String certNoForMatch;

    /**
     * 参与方的法大大帐号，为手机号或邮箱，长度最大60个字符。仅对个人参与方有效。如指定了该参数，则只有该帐号可以加入签署任务进行填写签署操作。
     * 注意：如已传actorOpenId或actorFDDId，非快捷签场景该字段将会被忽略；快捷签场景（即freeLogin字段设置为true时）同时传入会校验actorOpenId或actorFDDId 与 accountName是否一致
     */
    private String accountName;

    /**
     * 是否允许接口传入的accountName不作为指定帐号，配置为true时，即使传accountName或notifyAddress也走二要素快捷签，默认为false
     * false:指定accountName为加入帐号
     * true:不指定
     */
    private Boolean accountEditable;

    /**
     * 应用系统中唯一确定用户身份的标识，使用场景：签署过程中需要同时进行个人授权或免验证签授权时使用，其他场景传入不生效，授权后会回调通知个人授权事件和个人签名授权免验证签事件
     * 注意 ：个人授权和免验证签授权时，该字段和actorOpenId字段二选一填入
     */
    private String clientUserId;

    /**
     * 个人用户授权范围：
     * 【帐号】
     * ident_info： 授权允许获取个人身份信息
     * 【签名】
     * seal_info： 授权允许获取个人用户的签名资源
     * 【签署任务】
     * signtask_init： 授权允许代表个人发起签署
     * signtask_info： 授权允许获取个人用户的签署任务
     * signtask_file： 授权允许获取个人用户的签署文件
     * file_storage： 授权签署文件存储到应用的企业服务器，仅针对应用开启本地存储时生效
     */
    private List<String> authScopes;

    /**
     * 是否由法大大发送通知，默认true，设置为true时，可在notifyType中指定发送哪些通知，默认仅对抄送方发送抄送通知。
     */
    private Boolean sendNotification;

    /**
     * 由法大大发送的通知类型。
     * start：发送待填待签通知
     * finish：发送签署完成通知（如当前参与方是最后一个签署方，则不会触发）
     * cc：抄送方通知，需指定通知地址
     */
    private List<String> notifyType;

    /**
     * 通知地址，手机或邮箱，长度最大64个字符。
     * 注：如个人参与方已传actorOpenId、actorFDDId或accountName，该字段会被忽略
     */
    private String notifyAddress;

    /**
     * 是否发送站内信通知该参与方，默认为true
     * true：发送站内信通知
     * false：不发送站内信通知
     */
    private Boolean sendInSiteMessage;
}
