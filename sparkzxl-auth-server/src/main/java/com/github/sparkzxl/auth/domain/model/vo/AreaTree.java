package com.github.sparkzxl.auth.domain.model.vo;

import com.github.sparkzxl.core.tree.TreeNode;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * description: 地区node
 *
 * @author zhouxinlei
 * @since 2021-10-15 09:00:24
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AreaTree extends TreeNode<AreaTree, Long> {

    private static final long serialVersionUID = 1022516837087750793L;

    @ApiModelProperty(value = "行政单位类别 省 市 区/县 街道/乡镇")
    protected String level;

    @ApiModelProperty(value = "经度，纬度")
    private String center;

}
