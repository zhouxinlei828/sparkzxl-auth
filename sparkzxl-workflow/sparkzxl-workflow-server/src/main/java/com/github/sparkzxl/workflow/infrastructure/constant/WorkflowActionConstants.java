package com.github.sparkzxl.workflow.infrastructure.constant;

/**
 * description:流程任务动作类型
 *
 * @author zhouxinlei
 * @since 2022-03-06 10:43:58
 */
public class WorkflowActionConstants {

    /**
     * 启动
     */
    public static final int START = 0;
    /**
     * 提交
     */
    public static final int SUBMIT = 1;
    /**
     * 同意
     */
    public static final int AGREE = 2;
    /**
     * 跳转
     */
    public static final int JUMP = 3;

    /**
     * 流程结束
     */
    public static final int END = 4;
    /**
     * 流程挂起
     */
    public static final int SUSPEND = 5;
    /**
     * 驳回
     */
    public static final int REJECTED = -1;
    /**
     * 回退
     */
    public static final int ROLLBACK = -2;

}
