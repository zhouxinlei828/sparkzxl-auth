package com.github.sparkzxl.system.admin.interfaces.client.result;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * description: 地区实体类
 *
 * @author zhouxinlei
 * @date 2021-10-14 16:29:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder(toBuilder = true)
public class Area implements Serializable {
    private static final Long serialVersionUID = -14216400471825395L;
    /**
     * 区域编码  街道没有独有的adCode，均继承父类（区县）的adCode
     */
    @JsonProperty(value = "adcode")
    private Long code;

    /**
     * 父级id
     */
    @JsonProperty(value = "parent_code")
    private Long parentCode;

    /**
     * 名称
     */
    @JsonProperty(value = "name")
    private String name;

    /**
     * 等级  国家 省 市 区/县
     */
    @JsonProperty(value = "level")
    private String level;


    /**
     * 经度，纬度
     */
    @JsonProperty(value = "center")
    private String center;

    /**
     * 子节点
     */
    @TableField(exist = false)
    private List<Area> districts;

    @TableField(exist = false)
    private List<Area> childrenList;
}
