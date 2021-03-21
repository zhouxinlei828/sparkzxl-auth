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
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * description: 推动activiti流程
 *
 * @author charles.zhou
 * @date   2020-07-20 16:28:09
 */
@Component
@Slf4j
public class ProcessJumpProcessSolver extends AbstractProcessSolver {

    @Autowired
    private IProcessRuntimeService processRuntimeService;
    @Autowired
    private ActWorkApiService actWorkApiService;

    @Override
    @RedisLock(keyPrefix = "driver", waitTime = 0, leaseTime = 15000)
    public DriverResult slove(String businessId, DriveProcess driveProcess) {
        DriverResult driverResult = new DriverResult();
        try {
            String userId = driveProcess.getUserId();
            int actType = driveProcess.getActType();
            ProcessInstance processInstance = processRuntimeService.getProcessInstanceByBusinessId(businessId);
            if (ObjectUtils.isEmpty(processInstance)) {
                SparkZxlExceptionAssert.businessFail("流程实例为空，请检查参数是否正确");
            }
            String processDefinitionKey = processInstance.getProcessDefinitionKey();
            String processInstanceId = processInstance.getProcessInstanceId();
            DriverData driverData = DriverData.builder()
                    .userId(userId)
                    .processInstanceId(processInstanceId)
                    .processDefinitionKey(processDefinitionKey)
                    .businessId(businessId)
                    .comment(driveProcess.getComment())
                    .actType(actType)
                    .build();
            driverResult = actWorkApiService.jumpProcess(driverData);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            driverResult.setErrorMsg(e.getMessage());
            log.error("发生异常 Exception：{}", ExceptionUtil.getMessage(e));
        }
        return driverResult;
    }

    @Override
    public Integer[] supports() {
        return new Integer[]{WorkflowConstants.WorkflowAction.ROLLBACK, WorkflowConstants.WorkflowAction.JUMP};
    }

}
