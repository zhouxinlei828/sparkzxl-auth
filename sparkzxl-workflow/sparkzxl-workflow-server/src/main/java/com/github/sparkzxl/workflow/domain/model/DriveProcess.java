package com.github.sparkzxl.workflow.domain.model;

import lombok.Data;

/**
 * description: 流程驱动model
 *
 * @author charles.zhou
 * @date   2020-07-20 16:11:51
 */
@Data
public class DriveProcess {

    /**
     * 流程定义key
     */
    private String processDefinitionKey;

    /**
     * 业务主键
     */
    protected String businessId;

    /**
     * 流程动作类型
     */
    private int actType;

    /**
     * 评论
     */
    private String comment;

    /**
     * 申请人id
     */
    private String applyUserId;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 是否需要跳转
     */
    private boolean needJump;

}
