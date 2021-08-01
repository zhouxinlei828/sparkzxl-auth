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
 * online表单字段
 * </p>
 *
 * @author zhouxinlei
 * @since 2021-08-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("onl_form_field")
@ApiModel(value = "OnlFormField对象", description = "online表单字段")
public class OnlFormField extends Entity<Long> {

    private static final long serialVersionUID = -5113098393198978050L;

    @ApiModelProperty(value = "表id")
    @TableField("form_table_id")
    private String formTableId;

    @ApiModelProperty(value = "字段名字")
    @TableField("db_field_name")
    private String dbFieldName;

    @ApiModelProperty(value = "字段备注")
    @TableField("db_field_txt")
    private String dbFieldTxt;

    @ApiModelProperty(value = "原字段名")
    @TableField("db_field_name_old")
    private String dbFieldNameOld;

    @ApiModelProperty(value = "是否主键 0否 1是")
    @TableField("db_is_key")
    private Boolean dbIsKey;

    @ApiModelProperty(value = "是否允许为空0否 1是")
    @TableField("allow_null")
    private Boolean allowNull;

    @ApiModelProperty(value = "数据库字段类型")
    @TableField("db_type")
    private String dbType;

    @ApiModelProperty(value = "数据库字段长度")
    @TableField("db_length")
    private Integer dbLength;

    @ApiModelProperty(value = "小数点")
    @TableField("db_point_length")
    private Integer dbPointLength;

    @ApiModelProperty(value = "表字段默认值")
    @TableField("db_default_val")
    private String dbDefaultVal;

    @ApiModelProperty(value = "字典code")
    @TableField("dict_field")
    private String dictField;

    @ApiModelProperty(value = "字典表")
    @TableField("dict_table")
    private String dictTable;

    @ApiModelProperty(value = "字典text")
    @TableField("dict_text")
    private String dictText;

    @ApiModelProperty(value = "表单控件类型")
    @TableField("field_show_type")
    private String fieldShowType;

    @ApiModelProperty(value = "跳转url")
    @TableField("field_href")
    private String fieldHref;

    @ApiModelProperty(value = "表单控件长度")
    @TableField("field_length")
    private Integer fieldLength;

    @ApiModelProperty(value = "表单字段校验规则")
    @TableField("field_valid_type")
    private String fieldValidType;

    @ApiModelProperty(value = "字段是否必填")
    @TableField("field_must_input")
    private String fieldMustInput;

    @ApiModelProperty(value = "扩展参数json")
    @TableField("field_extend_json")
    private String fieldExtendJson;

    @ApiModelProperty(value = "控件默认值，不同的表达式展示不同的结果。	1. 纯字符串直接赋给默认值；	2. #{普通变量}；	3. {{ 动态js表达式 }}；	4. ${填值规则编码}；	填值规则表达式只允许存在一个，且不能和其他规则混用。")
    @TableField("field_default_value")
    private String fieldDefaultValue;

    @ApiModelProperty(value = "是否查询条件0否 1是")
    @TableField("is_query")
    private Boolean isQuery;

    @ApiModelProperty(value = "表单是否显示0否 1是")
    @TableField("is_show_form")
    private Boolean isShowForm;

    @ApiModelProperty(value = "列表是否显示0否 1是")
    @TableField("is_show_list")
    private Boolean isShowList;

    @ApiModelProperty(value = "是否是只读（1是 0否）")
    @TableField("is_read_only")
    private Boolean isReadOnly;

    @ApiModelProperty(value = "查询模式")
    @TableField("query_mode")
    private String queryMode;

    @ApiModelProperty(value = "外键主表名")
    @TableField("main_table")
    private String mainTable;

    @ApiModelProperty(value = "外键主键字段")
    @TableField("main_field")
    private String mainField;

    @ApiModelProperty(value = "排序")
    @TableField("order_num")
    private Integer orderNum;

    @ApiModelProperty(value = "自定义值转换器")
    @TableField("converter")
    private String converter;

    @ApiModelProperty(value = "查询默认值")
    @TableField("query_def_val")
    private String queryDefVal;

    @ApiModelProperty(value = "查询配置字典text")
    @TableField("query_dict_text")
    private String queryDictText;

    @ApiModelProperty(value = "查询配置字典code")
    @TableField("query_dict_field")
    private String queryDictField;

    @ApiModelProperty(value = "查询配置字典table")
    @TableField("query_dict_table")
    private String queryDictTable;

    @ApiModelProperty(value = "查询显示控件")
    @TableField("query_show_type")
    private String queryShowType;

    @ApiModelProperty(value = "是否启用查询配置1是0否")
    @TableField("query_config_flag")
    private String queryConfigFlag;

    @ApiModelProperty(value = "查询字段校验类型")
    @TableField("query_valid_type")
    private String queryValidType;

    @ApiModelProperty(value = "查询字段是否必填1是0否")
    @TableField("query_must_input")
    private String queryMustInput;

    @ApiModelProperty(value = "是否支持排序1是0否")
    @TableField("sort_flag")
    private String sortFlag;

}
