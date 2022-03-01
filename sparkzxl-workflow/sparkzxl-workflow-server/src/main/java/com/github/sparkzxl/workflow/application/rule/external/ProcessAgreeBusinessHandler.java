package com.github.sparkzxl.workflow.application.rule.external;

import com.github.sparkzxl.patterns.annonation.BusinessStrategy;
import com.github.sparkzxl.patterns.strategy.BusinessHandler;
import com.github.sparkzxl.redisson.annotation.RedisLock;
import com.github.sparkzxl.workflow.domain.model.bo.DriveProcess;
import com.github.sparkzxl.workflow.domain.service.act.ActWorkApiService;
import com.github.sparkzxl.workflow.dto.DriverResult;
import com.github.sparkzxl.workflow.infrastructure.constant.WorkflowConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * description: 流程跳转业务处理
 *
 * @author charles.zhou
 * @date 2020-07-20 16:28:09
 */
@Slf4j
@BusinessStrategy(type = WorkflowConstants.BusinessTaskStrategy.BUSINESS_TASK_DRIVER, source = WorkflowConstants.BusinessTaskStrategy.AGREE)
public class ProcessAgreeBusinessHandler implements BusinessHandler<DriverResult, DriveProcess> {

    private ActWorkApiService actWorkApiService;

    @Autowired
    public void setActWorkApiService(ActWorkApiService actWorkApiService) {
        this.actWorkApiService = actWorkApiService;
    }

    @Override
    @RedisLock(prefix = "act_driver")
    public DriverResult execute(DriveProcess driveProcess) {
        log.info("流程同意业务处理：actType:[{}],businessId:[{}]", driveProcess.getActType(), driveProcess.getBusinessId());
        return actWorkApiService.submitProcess(driveProcess);
    }


}
