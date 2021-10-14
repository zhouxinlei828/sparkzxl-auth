package com.github.sparkzxl.auth.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.github.sparkzxl.constant.EntityConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * description: 地区表
 *
 * @author charles.zhou
 * @date 2020-07-28 19:35:34
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_area")
@ApiModel(value = "Area对象", description = "地区表")
public class SysArea implements Serializable {

    private static final long serialVersionUID = 2594868912590581188L;

    @ApiModelProperty(value = "编码")
    @TableId(value = "code", type = IdType.INPUT)
    private Long code;

    @TableField("parent_code")
    protected Long parentCode;

    @ApiModelProperty(value = "行政单位名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "行政单位类别 省 市 区/县 街道/乡镇")
    @TableField(value = "level")
    protected String level;

    @ApiModelProperty(value = "城市编码")
    @TableField("city_code")
    private String cityCode;

    @ApiModelProperty(value = "经度，纬度")
    @TableField("center")
    private String center;

    @TableField("sort_number")
    protected Integer sortNumber;

    @TableField(value = EntityConstant.COLUMN_UPDATE_TIME, fill = FieldFill.INSERT_UPDATE)
    protected LocalDateTime updateTime;

    @TableField(value = EntityConstant.COLUMN_CREATE_TIME, fill = FieldFill.INSERT)
    protected LocalDateTime createTime;

    /**
     * 子节点
     */
    @TableField(exist = false)
    protected List<SysArea> children;


    public void initChildren() {
        if (this.getChildren() == null) {
            this.setChildren(new ArrayList<>());
        }

    }


    public static List<SysArea> buildTree(List<SysArea> areaList) {
        if (CollectionUtils.isEmpty(areaList)) {
            return areaList;
        }
        //记录自己是自己的父节点的id集合
        List<Serializable> selfIdEqSelfParent = new ArrayList<>();
        // 为每一个节点找到子节点集合
        for (SysArea parent : areaList) {
            Serializable id = parent.getCode();
            for (SysArea children : areaList) {
                if (parent != children) {
                    //parent != children 这个来判断自己的孩子不允许是自己，因为有时候，根节点的parent会被设置成为自己
                    if (id.equals(children.getParentCode())) {
                        parent.initChildren();
                        parent.getChildren().add(children);
                    }
                } else if (id.equals(parent.getParentCode())) {
                    selfIdEqSelfParent.add(id);
                }
            }
        }
        // 找出根节点集合
        List<SysArea> trees = new ArrayList<>();

        List<Serializable> allIds = areaList.stream().map(SysArea::getCode).collect(Collectors.toList());
        for (SysArea baseNode : areaList) {
            if (!allIds.contains(baseNode.getParentCode()) || selfIdEqSelfParent.contains(baseNode.getParentCode())) {
                trees.add(baseNode);
            }
        }
        return trees;
    }

}
