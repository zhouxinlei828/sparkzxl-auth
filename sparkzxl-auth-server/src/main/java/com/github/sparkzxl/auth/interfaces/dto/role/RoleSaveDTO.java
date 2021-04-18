package com.github.sparkzxl.auth.interfaces.dto.role;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Map;

/**
 * description：
 *
 * @author charles.zhou
 * @date 2020/6/16 0016
 */
@Data
@ApiModel("角色保存对象")
public class RoleSaveDTO {

    @ApiModelProperty(value = "名称")
    @NotEmpty(message = "名称不能为空")
    private String name;

    @ApiModelProperty(value = "编码")
    @NotEmpty(message = "编码不能为空")
    private String code;

    @ApiModelProperty(value = "描述")
    private String describe;

    @ApiModelProperty(value = "状态")
    private Boolean status;

    @ApiModelProperty(value = "角色属性")
    private Map<String, Object> attribute;

}
