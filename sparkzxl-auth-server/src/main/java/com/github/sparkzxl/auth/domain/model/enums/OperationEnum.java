package com.github.sparkzxl.auth.domain.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import com.github.sparkzxl.constant.enums.Enumerator;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * description：curd操作
 *
 * @author charles.zhou
 * @since 2020/6/7 3:28 下午
 */
@Getter
@AllArgsConstructor
public enum OperationEnum implements Enumerator {

    /**
     * 性别枚举
     */
    SAVE(1, "保存"),
    UPDATE(2, "更新"),
    DELETE(0, "删除");

    @EnumValue
    @JsonValue
    final Integer code;

    final String desc;

    public static String getValue(int code) {
        for (OperationEnum ele : values()) {
            if (ele.getCode() == code) {
                return ele.getDesc();
            }
        }
        return null;
    }

    public static OperationEnum getEnum(int code) {
        for (OperationEnum ele : values()) {
            if (ele.getCode() == code) {
                return ele;
            }
        }
        return null;
    }

    public static OperationEnum getEnum(String desc) {
        for (OperationEnum ele : values()) {
            if (ele.getDesc().equals(desc)) {
                return ele;
            }
        }
        return null;
    }

}
