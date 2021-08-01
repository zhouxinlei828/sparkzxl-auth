package com.github.sparkzxl.workflow.api;

import com.github.sparkzxl.workflow.dto.DriverProcessParam;
import com.github.sparkzxl.workflow.dto.DriverResult;
import com.github.sparkzxl.workflow.dto.ModifyProcessDTO;
import com.github.sparkzxl.workflow.dto.ProcessInstanceDeleteDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * description: activiti驱动API接口
 *
 * @author charles.zhou
 * @date 2020-10-01 19:42:13
 */
public interface ProcessDriveApi {

    /**
     * 驱动业务流程
     *
     * @param driverProcessParam 流程驱动入参
     * @return DriverResult
     */
    @ApiOperation("驱动业务流程")
    @RequestMapping(method = RequestMethod.POST, value = "/process")
    DriverResult driveProcess(@RequestBody @Validated DriverProcessParam driverProcessParam);

    /**
     * 流程挂起
     *
     * @param modifyProcessDTO 挂起流程入参
     * @return boolean
     */
    @ApiOperation("挂起流程")
    @RequestMapping(method = RequestMethod.POST, value = "/process/suspend")
    boolean suspendProcess(@RequestBody ModifyProcessDTO modifyProcessDTO);

    /**
     * 激活流程
     *
     * @param modifyProcessDTO 挂起流程入参
     * @return boolean
     */
    @ApiOperation("激活流程")
    @RequestMapping(method = RequestMethod.POST, value = "/process/activate")
    boolean activateProcessInstance(@RequestBody ModifyProcessDTO modifyProcessDTO);

    /**
     * 删除流程
     *
     * @param processInstanceDeleteDTO 删除流程实例入参
     * @return boolean
     */
    @ApiOperation("删除流程实例")
    @RequestMapping(method = RequestMethod.POST, value = "/process/delete")
    boolean deleteProcessInstance(@RequestBody ProcessInstanceDeleteDTO processInstanceDeleteDTO);
}
