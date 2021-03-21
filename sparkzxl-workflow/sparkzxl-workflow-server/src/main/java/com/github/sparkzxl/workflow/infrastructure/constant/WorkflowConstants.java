package com.github.sparkzxl.workflow.infrastructure.constant;

import java.awt.*;

/**
 * description: 流程常量
 *
 * @author charles.zhou
 * @date   2020-07-23 13:25:17
 */
public final class WorkflowConstants {

    /**
     * 流程图颜色定义
     */
    public static final Color COLOR_NORMAL = new Color(0, 205, 0);
    public static final Color COLOR_CURRENT = new Color(255, 0, 0);

    /**
     * 生成流程图时的边距(像素)
     */
    public static final int PROCESS_PADDING = 5;


    /**
     * 流程任务动作类型
     */
    public static class WorkflowAction {
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
         * 流程挂起
         */
        public static final int SUSPEND = 3;

        /**
         * 流程结束
         */
        public static final int END = 4;
        /**
         * 驳回
         */
        public static final int ROLLBACK = -1;
    }

    public static class ActType{

        public static final String START_EVENT = "startEvent";

        public static final String END_EVENT = "endEvent";
    }


}
