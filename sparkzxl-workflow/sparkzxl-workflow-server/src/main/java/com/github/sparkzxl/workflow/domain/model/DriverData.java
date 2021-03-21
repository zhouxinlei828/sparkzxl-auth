package com.github.sparkzxl.workflow.domain.model;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

/**
 * description: 驱动参数
 *
 * @author charles.zhou
 * @date   2020-12-04 20:46:15
 */
@Data
@Builder
public class DriverData {

    /**
     * 流程实例id
     */
    String processInstanceId;

    /**
     * 流程定义key
     */
    String processDefinitionKey;

    /**
     * 流程动作类型
     */
    private int actType;

    /**
     * 流程变量
     */
    private Map<String, Object> variables;

    /**
     * 业务主键
     */
    String businessId;

    /**
     * 用户id
     */
    String userId;

    /**
     * 审核意见
     */
    String comment;

}
