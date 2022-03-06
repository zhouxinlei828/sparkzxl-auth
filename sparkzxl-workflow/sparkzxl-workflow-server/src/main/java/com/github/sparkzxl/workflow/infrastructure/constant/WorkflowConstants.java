package com.github.sparkzxl.workflow.infrastructure.constant;

import java.awt.*;

/**
 * description: 流程常量
 *
 * @author charles.zhou
 * @date 2020-07-23 13:25:17
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

    public static class ActType {

        public static final String START_EVENT = "startEvent";

        public static final String END_EVENT = "endEvent";
    }
}
