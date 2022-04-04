package com.github.sparkzxl.workflow.interfaces.controller.ext;

import com.github.sparkzxl.annotation.response.Response;
import com.github.sparkzxl.log.annotation.HttpRequestLog;
import com.github.sparkzxl.log.annotation.LogParam;
import com.github.sparkzxl.workflow.application.service.ext.IExtProcessTaskRuleService;
import com.github.sparkzxl.workflow.domain.model.dto.process.ProcessActionDTO;
import com.github.sparkzxl.workflow.domain.model.dto.process.TaskRuleSaveDTO;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessTaskRule;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * description:流程流向管理
 *
 * @author charles.zhou
 * @date 2020-07-21 15:44:59
 */
@RestController
@Response
@RequestMapping("/process/rule")
@Api(tags = "流程规则管理")
@RequiredArgsConstructor
public class ExtProcessTaskRuleController {

    private final IExtProcessTaskRuleService processTaskRuleService;

    @PostMapping("save")
    @ApiOperation("保存流程跳转规则")
    public boolean saveProcessTaskRule(@RequestBody @Validated TaskRuleSaveDTO taskRuleSaveDTO) {
        return processTaskRuleService.saveProcessTaskRule(taskRuleSaveDTO);
    }

    @GetMapping("get")
    @ApiOperation("查询流程跳转规则")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "procDefKey", value = "流程定义key", required = true),
            @ApiImplicitParam(name = "taskDefKey", value = "任务定义key", required = true)
    })
    @HttpRequestLog(value = "查询流程跳转规则")
    public List<ExtProcessTaskRule> getProcessTaskRule(@RequestParam("procDefKey") @LogParam(value = "procDefKey") String procDefKey,
                                                       @RequestParam("taskDefKey") @LogParam(value = "taskDefKey") String taskDefKey) {
        return processTaskRuleService.getProcessTaskRule(procDefKey, taskDefKey);
    }

    @GetMapping("action")
    @ApiOperation("查询流程动作类型")
    public List<ProcessActionDTO> getProcessAction() {
        return processTaskRuleService.getProcessAction();
    }

    @DeleteMapping("delete")
    @ApiOperation("删除流程跳转规则")
    public boolean deleteProcessTaskRule(@RequestParam("id") @ApiParam("主键") Long id) {
        return processTaskRuleService.removeById(id);
    }

}
