package com.github.sparkzxl.auth.interfaces.dto.org;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.Map;

/**
 * description: 组织查询对象
 *
 * @author charles.zhou
 * @date   2020-07-28 10:21:46
 */
@Data
@ApiModel("组织查询对象")
public class OrgQueryDTO {

    @ApiModelProperty(value = "名称")
    @Length(max = 255, message = "名称长度不能超过255")
    private String label;

    @ApiModelProperty(value = "组织属性")
    private Map<String, Object> attribute;

}
