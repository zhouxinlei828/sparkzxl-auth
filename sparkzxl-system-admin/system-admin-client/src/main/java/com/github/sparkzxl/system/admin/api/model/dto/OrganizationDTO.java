package com.github.sparkzxl.system.admin.api.model.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * <p>
 * 组织DTO对象
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "OrganizationDTO", description = "组织DTO对象")
public class OrganizationDTO implements Serializable {


    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "ID", example = "1")
    private Long id;

    @ApiModelProperty(value = "名称")
    private String label;

    @ApiModelProperty(value = "简称")
    private String abbreviation;

    @ApiModelProperty(value = "父ID", example = "1")
    private Long parentId;

    @ApiModelProperty(value = "树结构")
    private String treePath;

    @ApiModelProperty(value = "排序", example = "1")
    private Integer sortNumber;

    @ApiModelProperty(value = "状态 0禁用,1启用")
    private Boolean status;

    @ApiModelProperty(value = "描述")
    private String describe;

    @ApiModelProperty(value = "更新人id", example = "1")
    private Long modifyUser;

    @ApiModelProperty(value = "更新时间")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime modifyTime;




}
