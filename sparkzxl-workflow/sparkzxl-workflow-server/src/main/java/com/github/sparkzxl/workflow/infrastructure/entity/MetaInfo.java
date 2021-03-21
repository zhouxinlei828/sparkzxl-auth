package com.github.sparkzxl.workflow.infrastructure.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * description: 元数据
 *
 * @author charles.zhou
 * @date   2020-07-25 13:22:27
 */
@Data
@ApiModel(value = "元数据")
public class MetaInfo {

    private String name;

    private String description;

    private Integer revision;
}
