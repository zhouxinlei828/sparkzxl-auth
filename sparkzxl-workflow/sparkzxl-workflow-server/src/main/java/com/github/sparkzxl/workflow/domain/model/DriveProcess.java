package com.github.sparkzxl.workflow.domain.model;

import com.github.sparkzxl.redisson.annotation.RedisLockParam;
import lombok.Data;

/**
 * description: 流程驱动model
 *
 * @author charles.zhou
 * @date 2020-07-20 16:11:51
 */
@Data
public class DriveProcess {

    /**
     * 业务主键
     */
    @RedisLockParam(name = "businessId")
    protected String businessId;
    /**
     * 流程名称
     */
    String processName;
    /**
     * 流程实例id
     */
    private String processInstanceId;
    /**
     * 流程定义key
     */
    private String processDefinitionKey;
    /**
     * 流程动作类型 0:启动流程，1：提交审批，2：同意，3：跳转，-1：驳回
     */
    @RedisLockParam(name = "actType")
    private int actType;

    /**
     * 评论
     */
    private String comment;

    /**
     * 下一任务代理人
     */
    private String nextTaskApproveUserId;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 是否需要跳转
     */
    private boolean needJump;

}
