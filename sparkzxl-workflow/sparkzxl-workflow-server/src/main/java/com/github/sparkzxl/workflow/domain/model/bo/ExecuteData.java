package com.github.sparkzxl.workflow.domain.model.bo;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

/**
 * description: 驱动参数
 *
 * @author charles.zhou
 * @since 2020-12-04 20:46:15
 */
@Data
@Builder
public class ExecuteData {

    /**
     * 流程实例id
     */
    private String processInstanceId;

    /**
     * 流程定义key
     */
    private String processDefinitionKey;

    private String currentTaskId;

    private String taskDefinitionKey;

    /**
     * 流程名称
     */
    private String processName;
    /**
     * 业务主键
     */
    private String businessId;

    /**
     * 用户id
     */
    private String userId;

    private String nextTaskApproveUserId;

    /**
     * 审核意见
     */
    private String comment;
    /**
     * 流程动作类型
     */
    private int actType;
    /**
     * 流程变量
     */
    private Map<String, Object> variables;


}
