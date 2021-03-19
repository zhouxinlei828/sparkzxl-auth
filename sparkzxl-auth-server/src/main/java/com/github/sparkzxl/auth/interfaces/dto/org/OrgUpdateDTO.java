package com.github.sparkzxl.auth.interfaces.dto.org;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * description: 组织保存实体类
 *
 * @author charles.zhou
 * @date   2020-07-28 10:21:46
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel("组织更新对象")
public class OrgUpdateDTO {


    @ApiModelProperty(value = "主键")
    @NotNull(message = "id不能为空")
    private Long id;

    @ApiModelProperty(value = "名称")
    @Length(max = 255, message = "名称长度不能超过255")
    private String label;
    /**
     * 简称
     */
    @ApiModelProperty(value = "简称")
    @Length(max = 255, message = "简称长度不能超过255")
    private String abbreviation;
    /**
     * 父ID
     */
    @ApiModelProperty(value = "父ID")
    private Long parentId;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer sortValue;
    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    private Boolean status;
    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    @Length(max = 255, message = "描述长度不能超过255")
    private String describe;


}
