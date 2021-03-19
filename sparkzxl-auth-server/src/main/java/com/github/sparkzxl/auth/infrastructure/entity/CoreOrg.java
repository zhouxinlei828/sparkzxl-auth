package com.github.sparkzxl.auth.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.sparkzxl.database.entity.TreeEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * description: 组织
 *
 * @author charles.zhou
 * @date 2020-06-07 13:24:05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("core_org")
@ApiModel(value = "CCoreOrgDO对象", description = "组织")
public class CoreOrg extends TreeEntity<CoreOrg, Long> {

    private static final long serialVersionUID = -7652204940090864043L;

    @ApiModelProperty(value = "简称")
    @TableField("abbreviation")
    private String abbreviation;

    @ApiModelProperty(value = "树结构")
    @TableField("tree_path")
    private String treePath;

    @ApiModelProperty(value = "状态")
    @TableField("status")
    private Boolean status;

    @ApiModelProperty(value = "描述")
    @TableField("describe_")
    private String describe;

    @ApiModelProperty(value = "领域池code")
    @TableField("tenant_code")
    private String tenantCode;

}
