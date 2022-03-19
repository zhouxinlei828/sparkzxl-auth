package com.github.sparkzxl.workflow.application.service.driver;

import com.github.sparkzxl.workflow.dto.BusTaskInfo;

import java.util.List;

/**
 * description: 业务任务查询
 *
 * @author zhouxinlei
 * @since 2022-03-06 16:29:04
 */
public interface IBusTaskService {

    /**
     * 查询业务任务数据
     *
     * @param businessId           业务主键
     * @param processDefinitionKey 流程定义key
     * @return BusTaskInfo
     */
    BusTaskInfo busTaskInfo(String businessId, String processDefinitionKey);

    /**
     * 查询业务任务批量数据
     *
     * @param processDefinitionKey 流程定义key
     * @param businessIds          业务主键
     * @return List<BusTaskInfo>
     */
    List<BusTaskInfo> busTaskInfoList(String processDefinitionKey, List<String> businessIds);

}
