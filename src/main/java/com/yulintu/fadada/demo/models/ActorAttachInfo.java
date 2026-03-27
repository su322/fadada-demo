package com.yulintu.fadada.demo.models;

import lombok.Data;

/**
 * 要求该参与方上传附件信息，每个参与方最多50条附件信息
 */
@Data
public class ActorAttachInfo {
    /**
     * 附件名，长度最大20个字符。
     */
    private String actorAttachName;

    /**
     * 是否必传，默认false
     */
    private Boolean required = false;
}
