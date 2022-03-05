package com.github.sparkzxl.workflow.interfaces.controller.driver;


import com.github.pagehelper.PageInfo;
import com.github.sparkzxl.annotation.response.Response;
import com.github.sparkzxl.log.annotation.HttpRequestLog;
import com.github.sparkzxl.workflow.api.ProcessApi;
import com.github.sparkzxl.workflow.application.service.act.IProcessHistoryService;
import com.github.sparkzxl.workflow.application.service.driver.IProcessDriveService;
import com.github.sparkzxl.workflow.application.service.ext.IExtProcessStatusService;
import com.github.sparkzxl.workflow.domain.model.dto.act.InstancePageDTO;
import com.github.sparkzxl.workflow.domain.model.dto.process.ProcessNextTaskDTO;
import com.github.sparkzxl.workflow.domain.model.vo.InstanceOverview;
import com.github.sparkzxl.workflow.dto.BusTaskInfo;
import com.github.sparkzxl.workflow.dto.ProcessHistory;
import com.github.sparkzxl.workflow.dto.ProcessHistoryParam;
import com.github.sparkzxl.workflow.dto.UserNextTask;
import com.github.sparkzxl.workflow.infrastructure.entity.ProcessInstance;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * description: 流程实例管理
 *
 * @author charles.zhou
 * @date 2020-07-21 14:53:25
 */
@AllArgsConstructor
@RestController
@Response
@HttpRequestLog
@RequestMapping("/instance")
@Api(tags = "流程实例管理")
public class ActInstancesController implements ProcessApi {

    private final IProcessHistoryService processHistoryService;
    private final IExtProcessStatusService processTaskStatusService;
    private final IProcessDriveService processDriveService;

    @Override
    public BusTaskInfo busTaskInfo(String businessId, String procDefKey) {
        return processDriveService.busTaskInfo(businessId, procDefKey);
    }

    @Override
    public List<BusTaskInfo> busTaskInfoList(String processDefinitionKey, List<String> businessIds) {
        return processDriveService.busTaskInfoList(processDefinitionKey, businessIds);
    }

    @ApiOperation(value = "获取下一步任务详情")
    @PostMapping("nextUserTask")
    public UserNextTask getNextUserTask(@RequestBody @Validated ProcessNextTaskDTO processNextTaskDTO) {
        return processDriveService.getNextUserTask(processNextTaskDTO.getProcessInstanceId(), processNextTaskDTO.getActType());
    }

    @Override
    public List<ProcessHistory> processHistoryList(ProcessHistoryParam processHistoryParam) {
        return processHistoryService.processHistoryList(processHistoryParam);
    }

    @ApiOperation("分页查询流程列表")
    @GetMapping("/page")
    public PageInfo<ProcessInstance> getProcessInstanceList(InstancePageDTO instancePageDTO) {
        return processTaskStatusService.getProcessInstanceList(instancePageDTO);
    }

    @ApiOperation("流程统计总览")
    @GetMapping("/overview")
    public InstanceOverview instanceOverview() {
        return processTaskStatusService.instanceOverview();
    }

    @ApiOperation("获取流程图并显示")
    @GetMapping("/flowChart")
    public String getProcessImg(@ApiParam("流程实例id") @RequestParam("processInstanceId") String processInstanceId) {
        return processHistoryService.getProcessImage(processInstanceId);
    }

}
