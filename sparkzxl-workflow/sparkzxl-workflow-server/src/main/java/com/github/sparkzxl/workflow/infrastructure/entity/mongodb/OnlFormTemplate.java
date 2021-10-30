package com.github.sparkzxl.workflow.infrastructure.entity.mongodb;

import com.github.sparkzxl.mongodb.entity.Entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * <p>
 * 表单设计模板
 * </p>
 *
 * @author zhouxinlei
 * @since 2021-08-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Document("onl_form_template")
@ApiModel(value = "OnlFormTemplate对象", description = "表单设计模板")
public class OnlFormTemplate extends Entity<Long> {

    private static final long serialVersionUID = 6568671589913709742L;

    @ApiModelProperty(value = "模板code")
    @Field("template_code")
    private String templateCode;

    @ApiModelProperty(value = "模板名称")
    @Field("template_name")
    private String templateName;

    @ApiModelProperty(value = "模板json")
    @Field("template_json")
    private String templateJson;

}
