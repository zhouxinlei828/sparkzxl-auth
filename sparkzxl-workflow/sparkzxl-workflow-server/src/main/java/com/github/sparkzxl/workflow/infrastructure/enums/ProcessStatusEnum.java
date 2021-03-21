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
public enum ProcessStatusEnum {

    /**
     * 流程状态
     */
    RUN_TIME(1, "运行中"),
    ROLLBACK(-1, "驳回"),
    END(-2,"结束");

    @EnumValue
    @JsonValue
    private final int code;

    private final String desc;

    public static String getValue(int code) {
        for (ProcessStatusEnum ele : values()) {
            if (ele.getCode() == code) {
                return ele.getDesc();
            }
        }
        return null;
    }

    public static int getCode(String desc) {
        for (ProcessStatusEnum ele : values()) {
            if (ele.getDesc().equals(desc)) {
                return ele.getCode();
            }
        }
        return 0;
    }

    public static ProcessStatusEnum getEnum(int code) {
        for (ProcessStatusEnum ele : values()) {
            if (ele.getCode() == code) {
                return ele;
            }
        }
        return null;
    }

    public static ProcessStatusEnum getEnum(String desc) {
        for (ProcessStatusEnum ele : values()) {
            if (ele.getDesc().equals(desc)) {
                return ele;
            }
        }
        return null;
    }
}
