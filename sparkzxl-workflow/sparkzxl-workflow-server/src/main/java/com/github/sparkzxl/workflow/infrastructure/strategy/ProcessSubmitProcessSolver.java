package com.github.sparkzxl.workflow.infrastructure.strategy;

import cn.hutool.core.exceptions.ExceptionUtil;
import com.github.sparkzxl.core.support.SparkZxlExceptionAssert;
import com.github.sparkzxl.redisson.annotation.RedisLock;
import com.github.sparkzxl.workflow.application.service.act.IProcessRuntimeService;
import com.github.sparkzxl.workflow.domain.model.DriveProcess;
import com.github.sparkzxl.workflow.domain.model.DriverData;
import com.github.sparkzxl.workflow.domain.service.act.ActWorkApiService;
import com.github.sparkzxl.workflow.dto.DriverResult;
import com.github.sparkzxl.workflow.infrastructure.constant.WorkflowConstants;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Map;

/**
 * description: 推动activiti流程
 *
 * @author charles.zhou
 * @date   2020-07-20 16:28:09
 */
@Component
@Slf4j
public class ProcessSubmitProcessSolver extends AbstractProcessSolver {

    @Autowired
    private IProcessRuntimeService processRuntimeService;
    @Autowired
    private ActWorkApiService actWorkApiService;

    @Override
    @RedisLock(keyPrefix = "driver", waitTime = 0, leaseTime = 15000)
    public DriverResult slove(String businessId, DriveProcess driveProcess) {
        DriverResult driverResult = new DriverResult();
        try {
            String applyUserId = driveProcess.getApplyUserId();
            String userId = driveProcess.getUserId();
            Map<String, Object> variables = Maps.newHashMap();
            if (StringUtils.isNotEmpty(applyUserId)) {
                variables.put("assignee", applyUserId);
            }
            variables.put("actType", driveProcess.getActType());
            ProcessInstance processInstance = processRuntimeService.getProcessInstanceByBusinessId(businessId);
            if (ObjectUtils.isEmpty(processInstance)) {
                SparkZxlExceptionAssert.businessFail("流程实例为空，请检查参数是否正确");
            }
            DriverData driverData = DriverData.builder()
                    .userId(userId)
                    .processInstanceId(processInstance.getProcessInstanceId())
                    .businessId(businessId)
                    .processDefinitionKey(processInstance.getProcessDefinitionKey())
                    .actType(driveProcess.getActType())
                    .comment(driveProcess.getComment())
                    .variables(variables)
                    .build();
            driverResult = actWorkApiService.promoteProcess(driverData);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.error("发生异常 Exception：{}", ExceptionUtil.getMessage(e));
            driverResult.setErrorMsg(e.getMessage());
        }
        return driverResult;
    }

    @Override
    public Integer[] supports() {
        return new Integer[]{WorkflowConstants.WorkflowAction.SUBMIT,
                WorkflowConstants.WorkflowAction.AGREE,
                WorkflowConstants.WorkflowAction.END};
    }
}
