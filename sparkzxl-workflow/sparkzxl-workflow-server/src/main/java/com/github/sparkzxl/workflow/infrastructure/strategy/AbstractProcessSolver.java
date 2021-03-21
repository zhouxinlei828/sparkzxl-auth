package com.github.sparkzxl.workflow.infrastructure.strategy;

import com.github.sparkzxl.workflow.domain.model.DriveProcess;
import com.github.sparkzxl.workflow.dto.DriverResult;

/**
 * description: 抽象业务处理器
 *
 * @author charles.zhou
 * @date   2020-07-20 16:09:28
 */
public abstract class AbstractProcessSolver {
    /**
     * 流程业务处理
     *
     * @param driveProcess 驱动model
     * @return DriverResult
     */
    public abstract DriverResult slove(String businessId, DriveProcess driveProcess);

    /**
     * 流程类型支持
     *
     * @return Integer[]
     */
    public abstract Integer[] supports();
}
