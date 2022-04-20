package com.github.sparkzxl.auth.domain.model.aggregates;

import com.github.sparkzxl.auth.domain.model.enums.OperationEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * description: 资源触发事件源
 *
 * @author charles.zhou
 * @date 2021-03-08 14:17:10
 */
@Data
@AllArgsConstructor
public class ResourceSource {

    /**
     * curd操作
     */
    private OperationEnum operation;

    /**
     * 新值
     */
    private String newVal;

    /**
     * 旧值
     */
    private String oldVal;

    /**
     * 租户信息code
     */
    private String tenantId;

}
