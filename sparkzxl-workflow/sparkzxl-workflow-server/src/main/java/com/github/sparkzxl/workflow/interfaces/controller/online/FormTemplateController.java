package com.github.sparkzxl.workflow.interfaces.controller.online;

import com.alibaba.fastjson.JSONObject;
import com.github.sparkzxl.annotation.result.ResponseResult;
import com.github.sparkzxl.database.dto.DeleteDTO;
import com.github.sparkzxl.log.annotation.WebLog;
import com.github.sparkzxl.workflow.application.service.online.IOnlFormTemplateService;
import com.github.sparkzxl.workflow.infrastructure.entity.mongodb.OnlFormTemplate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * description: 表单模板管理
 *
 * @author zhouxinlei
 * @date 2021-08-29 10:50:21
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/form/template")
@ResponseResult
@WebLog
@Api(tags = "表单模板管理")
public class FormTemplateController {

    private final IOnlFormTemplateService formTemplateService;

    /**
     * 保存模板
     *
     * @param template 模板
     * @return boolean
     */
    @ApiOperation("保存表单模板")
    @PostMapping("/save")
    public boolean saveTemplate(@RequestBody OnlFormTemplate template) {
        return formTemplateService.saveTemplate(template);
    }

    /**
     * 更新模板
     *
     * @param template 模板
     * @return boolean
     */
    @ApiOperation("更新表单模板")
    @PutMapping("/update")
    public boolean updateTemplate(@RequestBody OnlFormTemplate template) {
        return formTemplateService.updateTemplate(template);
    }

    /**
     * 删除模板
     *
     * @param templateId 模板id
     * @return boolean
     */
    @ApiOperation("删除表单模板")
    @DeleteMapping("/delete")
    public boolean deleteTemplate(@RequestParam("templateId") Long templateId) {
        return formTemplateService.deleteTemplate(templateId);
    }

    /**
     * 删除模板
     *
     * @param deleteDTO 模板id列表
     * @return boolean
     */
    @ApiOperation("批量删除表单模板")
    @DeleteMapping("/delete/batch")
    public boolean deleteTemplateBatch(@RequestBody DeleteDTO<Long> deleteDTO) {
        return formTemplateService.deleteTemplate(deleteDTO.getIds());
    }

    /**
     * 查询表单模板
     *
     * @param templateId 模板id
     * @return OnlFormTemplate
     */
    @ApiOperation("查询表单模板")
    @GetMapping("get")
    public OnlFormTemplate getTemplate(@RequestParam("templateId") Long templateId) {
        return formTemplateService.getTemplate(templateId);
    }

    /**
     * 查询表单模板
     *
     * @param templateCode 模板code
     * @return OnlFormTemplate
     */
    @ApiOperation("查询表单模板JSON")
    @GetMapping("getJson")
    public JSONObject getTemplateJson(@RequestParam("templateCode") String templateCode) {
        return formTemplateService.getTemplateJson(templateCode);
    }
}
