package com.github.sparkzxl.workflow.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.sparkzxl.entity.data.Entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * online表单table
 * </p>
 *
 * @author zhouxinlei
 * @since 2021-08-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("onl_form_table")
@ApiModel(value = "OnlFormTable对象", description = "online表单table")
public class OnlFormTable extends Entity<Long> {

    private static final long serialVersionUID = -3013076855730661038L;

    @ApiModelProperty(value = "表名")
    @TableField("table_name")
    private String tableName;

    @ApiModelProperty(value = "表类型: 0单表、1主表、2附表")
    @TableField("table_type")
    private Integer tableType;

    @ApiModelProperty(value = "表版本")
    @TableField("table_version")
    private Integer tableVersion;

    @ApiModelProperty(value = "表说明")
    @TableField("table_txt")
    private String tableTxt;

    @ApiModelProperty(value = "是否带checkbox")
    @TableField("is_checkbox")
    private String isCheckbox;

    @ApiModelProperty(value = "同步数据库状态")
    @TableField("db_sync")
    private String dbSync;

    @ApiModelProperty(value = "是否分页")
    @TableField("is_page")
    private String isPage;

    @ApiModelProperty(value = "是否是树")
    @TableField("is_tree")
    private String isTree;

    @ApiModelProperty(value = "主键生成序列")
    @TableField("id_sequence")
    private String idSequence;

    @ApiModelProperty(value = "主键类型")
    @TableField("id_type")
    private String idType;

    @ApiModelProperty(value = "查询模式")
    @TableField("query_mode")
    private String queryMode;

    @ApiModelProperty(value = "映射关系 0一对多  1一对一")
    @TableField("relation_type")
    private Integer relationType;

    @ApiModelProperty(value = "子表")
    @TableField("sub_table_str")
    private String subTableStr;

    @ApiModelProperty(value = "附表排序序号")
    @TableField("tab_order_num")
    private Integer tabOrderNum;

    @ApiModelProperty(value = "树形表单父id")
    @TableField("tree_parent_id_field")
    private String treeParentIdField;

    @ApiModelProperty(value = "树表主键字段")
    @TableField("tree_id_field")
    private String treeIdField;

    @ApiModelProperty(value = "树开表单列字段")
    @TableField("tree_field_name")
    private String treeFieldName;

    @ApiModelProperty(value = "pc表单模板")
    @TableField("form_template")
    private String formTemplate;

    @ApiModelProperty(value = "表单模板样式(移动端)")
    @TableField("form_template_mobile")
    private String formTemplateMobile;

    @ApiModelProperty(value = "是否有横向滚动条")
    @TableField("scroll")
    private Integer scroll;

    @ApiModelProperty(value = "主题模板")
    @TableField("theme_template")
    private String themeTemplate;

    @ApiModelProperty(value = "是否用设计器表单")
    @TableField("is_des_form")
    private String isDesForm;

    @ApiModelProperty(value = "设计器表单编码")
    @TableField("form_des_code")
    private String formDesCode;

}
