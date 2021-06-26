package com.github.sparkzxl.auth.infrastructure.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import com.github.sparkzxl.constant.enums.Enumerator;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * description：
 *
 * @author charles.zhou
 * @date 2020/6/7 3:28 下午
 */
@Getter
@AllArgsConstructor
public enum SexEnum implements Enumerator {

    /**
     * 性别枚举
     */
    MAN(1, "男"),
    WOMAN(2, "女"),
    NONE(0, "未知");

    @EnumValue
    @JsonValue
    final Integer code;

    final String desc;

    public static String getValue(int code) {
        for (SexEnum ele : values()) {
            if (ele.getCode() == code) {
                return ele.getDesc();
            }
        }
        return null;
    }

    public static SexEnum getEnum(int code) {
        for (SexEnum ele : values()) {
            if (ele.getCode() == code) {
                return ele;
            }
        }
        return null;
    }

    public static SexEnum getEnum(String desc) {
        for (SexEnum ele : values()) {
            if (ele.getDesc().equals(desc)) {
                return ele;
            }
        }
        return null;
    }

}
