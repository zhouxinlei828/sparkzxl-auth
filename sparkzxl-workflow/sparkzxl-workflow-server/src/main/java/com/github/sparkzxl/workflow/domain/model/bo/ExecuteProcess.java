package com.github.sparkzxl.workflow.domain.model.bo;

import com.google.common.collect.Maps;
import lombok.Data;

import java.util.Map;

/**
 * description: 流程驱动model
 *
 * @author charles.zhou
 */
@Data
public class ExecuteProcess {

    /**
     * 业务主键
     */
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

    private Map<String, Object> variables = Maps.newHashMap();

}
