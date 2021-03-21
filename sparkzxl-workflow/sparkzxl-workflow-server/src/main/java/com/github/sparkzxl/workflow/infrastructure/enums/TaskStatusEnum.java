package com.github.sparkzxl.workflow.infrastructure.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * description: 流程状态枚举类
 *
 * @author charles.zhou
 * @date   2020-07-23 13:09:34
 */
@Getter
@AllArgsConstructor
public enum TaskStatusEnum {

    /**
     * 任务状态
     */
    START(0, "开始"),
    SUBMIT(1, "提交"),
    AGREE(2, "同意"),
    IN_HAND(3, "待处理"),
    END(4, "完成"),
    ROLLBACK(-1, "驳回");

    @EnumValue
    @JsonValue
    private final int code;

    private final String desc;

    public static String getValue(int code) {
        for (TaskStatusEnum ele : values()) {
            if (ele.getCode() == code) {
                return ele.getDesc();
            }
        }
        return null;
    }
}
