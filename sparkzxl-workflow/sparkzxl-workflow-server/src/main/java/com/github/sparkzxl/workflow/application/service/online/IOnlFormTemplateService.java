package com.github.sparkzxl.workflow.application.service.online;

import com.github.sparkzxl.workflow.infrastructure.entity.mongodb.OnlFormTemplate;

import java.io.Serializable;
import java.util.List;

/**
 * description: 表单设计模板 服务类
 *
 * @author zhouxinlei
 * @date 2021-08-29 10:23:58
 */
public interface IOnlFormTemplateService {

    /**
     * 保存模板
     *
     * @param template 模板
     * @return boolean
     */
    boolean saveTemplate(OnlFormTemplate template);

    /**
     * 更新模板
     *
     * @param template 模板
     * @return boolean
     */
    boolean updateTemplate(OnlFormTemplate template);

    /**
     * 删除模板
     *
     * @param templateId 模板id
     * @return boolean
     */
    boolean deleteTemplate(Long templateId);

    /**
     * 删除模板
     *
     * @param templateIds 模板id列表
     * @return boolean
     */
    boolean deleteTemplate(List<Long> templateIds);

    /**
     * 查询表单模板
     *
     * @param templateId 模板id
     * @return OnlFormTemplate
     */
    OnlFormTemplate getTemplate(Long templateId);

}
