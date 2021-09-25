package com.github.sparkzxl.workflow.interfaces.controller.driver;

import com.github.sparkzxl.annotation.result.ResponseResult;
import com.github.sparkzxl.log.annotation.HttpRequestLog;
import com.github.sparkzxl.workflow.api.ProcessDriveApi;
import com.github.sparkzxl.workflow.application.service.driver.IProcessDriveService;
import com.github.sparkzxl.workflow.dto.DriverProcessParam;
import com.github.sparkzxl.workflow.dto.DriverResult;
import com.github.sparkzxl.workflow.dto.ModifyProcessDTO;
import com.github.sparkzxl.workflow.dto.ProcessInstanceDeleteDTO;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: 流程驱动管理
 *
 * @author charles.zhou
 * @date 2020-07-17 16:29:54
 */
@AllArgsConstructor
@RestController
@RequestMapping("/drive")
@ResponseResult
@HttpRequestLog
@Api(tags = "流程驱动管理")
public class ActDriveController implements ProcessDriveApi {

    private final IProcessDriveService processDriveService;

    @Override
    public DriverResult driveProcess(DriverProcessParam driverProcessParam) {
        return processDriveService.driveProcess(driverProcessParam);
    }

    @Override
    public boolean suspendProcess(@RequestBody ModifyProcessDTO modifyProcessDTO) {
        return processDriveService.suspendProcess(modifyProcessDTO);
    }

    @Override
    public boolean activateProcessInstance(ModifyProcessDTO modifyProcessDTO) {
        return processDriveService.activateProcessInstance(modifyProcessDTO);
    }

    @Override
    public boolean deleteProcessInstance(ProcessInstanceDeleteDTO processInstanceDeleteDTO) {
        return processDriveService.deleteProcessInstanceBatch(processInstanceDeleteDTO);
    }
}
