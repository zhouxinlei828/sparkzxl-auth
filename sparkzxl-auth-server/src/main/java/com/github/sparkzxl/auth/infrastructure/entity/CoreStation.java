package com.github.sparkzxl.auth.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.github.sparkzxl.annotation.echo.EchoField;
import com.github.sparkzxl.entity.data.Entity;
import com.github.sparkzxl.entity.data.RemoteData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

import static com.github.sparkzxl.auth.infrastructure.constant.EchoConstant.STATION_ID_CLASS;

/**
 * description: 岗位
 *
 * @author charles.zhou
 * @date 2020-06-07 13:23:52
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("core_station")
@ApiModel(value = "CCoreStationDO对象", description = "岗位")
public class CoreStation implements Serializable {

    private static final long serialVersionUID = -4924681990812046498L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "组织ID")
    @TableField("org_id")
    @EchoField(api = STATION_ID_CLASS, beanClass = CoreStation.class)
    private RemoteData<Long, CoreOrg> org;

    @ApiModelProperty(value = "状态")
    @TableField("status")
    private Boolean status;

    @ApiModelProperty(value = "描述")
    @TableField("describe_")
    private String describe;

    @TableField(value = "create_user", fill = FieldFill.INSERT)
    protected Long createUser;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    protected LocalDateTime createTime;

    @TableField(value = "update_user", fill = FieldFill.INSERT_UPDATE)
    protected Long updateUser;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    protected LocalDateTime updateTime;
}
