package com.github.sparkzxl.workflow.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * description: 驱动结果
 *
 * @author charles.zhou
 * @date   2020-10-01 19:43:49
 */
@Data
@ApiModel("业务驱动结果")
public class DriverResult {

    @ApiModelProperty("流程是否结束")
    private boolean processIsEnd;

    @ApiModelProperty("操作是否成功")
    private boolean operateSuccess;

    @ApiModelProperty("异常信息")
    private String errorMsg;

}
