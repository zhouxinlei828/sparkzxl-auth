package com.github.sparkzxl.auth.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.sparkzxl.database.echo.annonation.EchoField;
import com.github.sparkzxl.database.entity.Entity;
import com.github.sparkzxl.database.entity.RemoteData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import static com.github.sparkzxl.auth.infrastructure.constant.EchoConstants.*;
import static com.github.sparkzxl.auth.infrastructure.constant.EchoConstants.FIND_NAME_BY_IDS;

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
public class CoreStation extends Entity<Long> {

    private static final long serialVersionUID = -4924681990812046498L;

    @ApiModelProperty(value = "名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "组织ID")
    @TableField("org_id")
    @EchoField(api = STATION_ID_CLASS, method = FIND_NAME_BY_IDS, beanClass = CoreStation.class)
    private RemoteData<Long, CoreOrg> org;

    @ApiModelProperty(value = "状态")
    @TableField("status")
    private Boolean status;

    @ApiModelProperty(value = "描述")
    @TableField("describe_")
    private String describe;

    @ApiModelProperty(value = "租户池code")
    @TableField("tenant_code")
    private String tenantId;
}
