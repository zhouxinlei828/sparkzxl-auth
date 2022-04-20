package ${customFileConfig.voConfig.packageName};

<#list table.importPackages as pkg>
    <#if pkg != "com.baomidou.mybatisplus.annotation.IdType"
    && pkg != "com.baomidou.mybatisplus.annotation.TableField"
    && pkg != "com.baomidou.mybatisplus.annotation.TableId"
    && pkg != "com.baomidou.mybatisplus.annotation.TableLogic"
    && pkg != "com.baomidou.mybatisplus.annotation.TableName"
    && pkg != "com.baomidou.mybatisplus.annotation.FieldFill"
    >
import ${pkg};
    </#if>
</#list>
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
<#if swagger>
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
</#if>
<#if entityLombokModel>
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
    <#if chainModel>
import lombok.experimental.Accessors;
    </#if>
</#if>

/**
 * <p>
 * ${table.comment!}VO对象
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if entityLombokModel>
@Data
@NoArgsConstructor
@AllArgsConstructor
<#if chainModel>
@Accessors(chain = true)
</#if>
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
</#if>
<#if swagger>
@ApiModel(value = "${entity}VO", description = "${table.comment!?replace("\r\n"," ")?replace("\r"," ")?replace("\n"," ")}VO对象")
</#if>
<#if superEntityClass??>
public class ${entity}VO extends ${superEntityClass}<#if activeRecord><${entity}></#if> {
<#elseif activeRecord>
public class ${entity}VO extends Model<${entity}> {
<#elseif entitySerialVersionUID>
public class ${entity}VO implements Serializable {
<#else>
public class ${entity}VO {
</#if>

<#if entitySerialVersionUID>

    private static final long serialVersionUID = 1L;
</#if>
<#-- ----------  BEGIN 字段循环遍历  ---------->
<#list table.fields as field>
    <#if field.propertyName !="isDelete">
    <#if field.keyFlag>
        <#assign keyPropertyName="${field.propertyName}"/>
    </#if>
    <#if field.comment!?length gt 0>
        <#if swagger && (field.propertyType == "Integer" || field.propertyType == "Long")>
    @ApiModelProperty(value = "${field.comment}", example = "1")
        <#elseif swagger && field.propertyType == "BigDecimal" >
    @ApiModelProperty(value = "${field.comment}", example = "1.00")
        <#elseif swagger>
    @ApiModelProperty(value = "${field.comment}")
        <#else>
    /**
     * ${field.comment}
     */
        </#if>
    </#if>
    <#-- 判断如果是时间字段自动格式化 -->
    <#if field.propertyType == "LocalDateTime">
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    </#if>
    <#if field.propertyType == "LocalDate">
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    </#if>
    private ${field.propertyType} ${field.propertyName};

    </#if>
</#list>
<#------------  END 字段循环遍历  ---------->

<#if !entityLombokModel>
    <#list table.fields as field>
        <#if field.propertyType == "boolean">
            <#assign getprefix="is"/>
        <#else>
            <#assign getprefix="get"/>
        </#if>
    public ${field.propertyType} ${getprefix}${field.capitalName}() {
        return ${field.propertyName};
    }

    <#if chainModel>
    public ${entity} set${field.capitalName}(${field.propertyType} ${field.propertyName}) {
    <#else>
    public void set${field.capitalName}(${field.propertyType} ${field.propertyName}) {
    </#if>
        this.${field.propertyName} = ${field.propertyName};
        <#if chainModel>
        return this;
        </#if>
    }
    </#list>
</#if>

<#if entityColumnConstant>
    <#list table.fields as field>
    public static final String ${field.name?upper_case} = "${field.name}";

    </#list>
</#if>
}
