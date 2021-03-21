package com.github.sparkzxl.workflow.api;

import com.github.sparkzxl.workflow.dto.BusTaskInfo;
import com.github.sparkzxl.workflow.dto.ProcessHistory;
import com.github.sparkzxl.workflow.dto.ProcessHistoryParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * description: activiti驱动API接口
 *
 * @author charles.zhou
 * @date   2020-10-01 19:42:13
 */
public interface ProcessApi {

    /**
     * 查询业务任务数据
     *
     * @param businessId 业务主键
     * @param procDefKey 流程定义key
     * @return BusTaskInfo
     */
    @ApiOperation("查询业务任务数据")
    @RequestMapping(method = RequestMethod.GET, value = "/busTaskInfo")
    BusTaskInfo busTaskInfo(@RequestParam("businessId") String businessId,
                            @RequestParam("procDefKey") String procDefKey);

    /**
     * 查询业务任务数据
     *
     * @param businessIds 业务主键
     * @param procDefKey  流程定义key
     * @return List<BusTaskInfo>
     */
    @ApiOperation("查询业务批量任务数据")
    @RequestMapping(method = RequestMethod.GET, value = "/busTaskInfoList")
    List<BusTaskInfo> busTaskInfoList(@RequestParam("businessIds") List<String> businessIds,
                                      @RequestParam("procDefKey") String procDefKey);


    /**
     * 获取流程历史
     *
     * @param processHistoryParam 流程历史查询入参
     * @return List<ProcessHistory>
     */
    @ApiOperation("查询业务批量任务数据")
    @RequestMapping(method = RequestMethod.GET, value = "/historyList")
    List<ProcessHistory> processHistoryList(@SpringQueryMap ProcessHistoryParam processHistoryParam);
}
