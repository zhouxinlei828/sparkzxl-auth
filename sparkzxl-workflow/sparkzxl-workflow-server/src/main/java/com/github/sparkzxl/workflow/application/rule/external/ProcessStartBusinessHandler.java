package com.github.sparkzxl.workflow.application.rule.external;

import cn.hutool.core.exceptions.ExceptionUtil;
import com.github.sparkzxl.core.support.SparkZxlExceptionAssert;
import com.github.sparkzxl.patterns.annonation.BusinessStrategy;
import com.github.sparkzxl.patterns.strategy.BusinessHandler;
import com.github.sparkzxl.redisson.annotation.RedisLock;
import com.github.sparkzxl.workflow.application.service.act.IProcessRuntimeService;
import com.github.sparkzxl.workflow.domain.model.DriveProcess;
import com.github.sparkzxl.workflow.domain.model.DriverData;
import com.github.sparkzxl.workflow.domain.service.act.ActWorkApiService;
import com.github.sparkzxl.workflow.dto.DriverResult;
import com.github.sparkzxl.workflow.infrastructure.constant.WorkflowConstants;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.IdentityService;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Map;

/**
 * description: 流程启动业务处理
 *
 * @author charles.zhou
 * @date 2020-07-20 16:28:09
 */
@Slf4j
@BusinessStrategy(type = WorkflowConstants.BusinessTaskStrategy.BUSINESS_TASK_DRIVER, source = WorkflowConstants.BusinessTaskStrategy.START)
public class ProcessStartBusinessHandler implements BusinessHandler<DriverResult, DriveProcess> {


    private IdentityService identityService;
    private IProcessRuntimeService processRuntimeService;
    private ActWorkApiService actWorkApiService;

    @Autowired
    public void setIdentityService(IdentityService identityService) {
        this.identityService = identityService;
    }

    @Autowired
    public void setProcessRuntimeService(IProcessRuntimeService processRuntimeService) {
        this.processRuntimeService = processRuntimeService;
    }

    @Autowired
    public void setActWorkApiService(ActWorkApiService actWorkApiService) {
        this.actWorkApiService = actWorkApiService;
    }

    @Override
    @RedisLock(expression = "#p0.businessId", keyPrefix = "act_driver")
    public DriverResult businessHandler(DriveProcess driveProcess) {
        log.info("流程启动业务处理：actType:[{}],businessId:[{}]", driveProcess.getActType(), driveProcess.getBusinessId());
        DriverResult driverResult = new DriverResult();
        String businessId = driveProcess.getBusinessId();
        try {
            String userId = driveProcess.getUserId();
            //查询是否存在已有流程，如果有，则不能进行启动工作流操作
            ProcessInstance originalProcessInstance = processRuntimeService.getProcessInstanceByBusinessId(businessId);
            if (ObjectUtils.isNotEmpty(originalProcessInstance)) {
                SparkZxlExceptionAssert.businessFail("流程已存在，请勿重复启动");
            }
            Map<String, Object> variables = Maps.newHashMap();
            variables.put("assignee", driveProcess.getApplyUserId());
            variables.put("actType", driveProcess.getActType());
            identityService.setAuthenticatedUserId(String.valueOf(userId));
            ProcessInstance processInstance = processRuntimeService.startProcessInstanceByKey(driveProcess.getProcessDefinitionKey(),
                    businessId,
                    variables);
            String processInstanceId = processInstance.getProcessInstanceId();
            log.info("启动activiti流程------++++++ProcessInstanceId：{}------++++++", processInstanceId);
            String comment = driveProcess.getComment();
            if (StringUtils.isEmpty(comment)) {
                comment = "开始节点跳过";
            }
            boolean needJump = driveProcess.isNeedJump();
            if (needJump) {
                DriverData driverData = DriverData.builder()
                        .userId(userId)
                        .processInstanceId(processInstanceId)
                        .processDefinitionKey(processInstance.getProcessDefinitionKey())
                        .businessId(businessId)
                        .comment(comment)
                        .actType(WorkflowConstants.WorkflowAction.JUMP)
                        .build();
                driverResult = actWorkApiService.jumpProcess(driverData);
            } else {
                variables.put("actType", WorkflowConstants.WorkflowAction.SUBMIT);
                DriverData driverData = DriverData.builder()
                        .userId(userId)
                        .processInstanceId(processInstanceId)
                        .businessId(businessId)
                        .processDefinitionKey(processInstance.getProcessDefinitionKey())
                        .actType(WorkflowConstants.WorkflowAction.SUBMIT)
                        .comment(comment)
                        .variables(variables)
                        .build();
                driverResult = actWorkApiService.promoteProcess(driverData);
            }
        } catch (Exception e) {
            e.printStackTrace();
            driverResult.setErrorMsg(e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.error("发生异常 Exception：{}", ExceptionUtil.getMessage(e));
        }
        return driverResult;
    }

}
