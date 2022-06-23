package com.github.sparkzxl.workflow.infrastructure.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * description: 事件监听类型举类
 *
 * @author charles.zhou
 * @since 2020-07-23 13:09:34
 */
@Getter
@AllArgsConstructor
public enum ListenerEventEnum {
    UPDATE,
    DELETE;
}
