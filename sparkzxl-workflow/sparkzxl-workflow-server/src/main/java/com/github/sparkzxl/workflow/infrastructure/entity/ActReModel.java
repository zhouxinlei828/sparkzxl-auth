package com.github.sparkzxl.workflow.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * description: 模型对象
 *
 * @author charles.zhou
 * @date   2020-07-25 11:12:50
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ACT_RE_MODEL")
@ApiModel(value = "ActReModel对象", description = "模型对象")
public class ActReModel implements Serializable {

    private static final long serialVersionUID = -4878256322226100755L;

    @TableId(value = "ID_", type = IdType.INPUT)
    private String id;

    @TableField("REV_")
    private Integer rev;

    @TableField("NAME_")
    private String name;

    @TableField("KEY_")
    private String key;

    @TableField("CATEGORY_")
    private String category;

    @TableField("CREATE_TIME_")
    private LocalDateTime createTime;

    @TableField("LAST_UPDATE_TIME_")
    private LocalDateTime lastUpdateTime;

    @TableField("VERSION_")
    private Integer version;

    @TableField("META_INFO_")
    private String metaInfo;

    @TableField("DEPLOYMENT_ID_")
    private String deploymentId;

    @TableField("EDITOR_SOURCE_VALUE_ID_")
    private String editorSourceValueId;

    @TableField("EDITOR_SOURCE_EXTRA_VALUE_ID_")
    private String editorSourceExtraValueId;

    @TableField("TENANT_ID_")
    private String tenantId;

    @TableField(exist = false)
    private boolean status;

    @TableField(exist = false)
    private String deployed;

    @TableField(exist = false)
    private String description;

}
