package com.github.sparkzxl.workflow.interfaces.controller.ext;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.sparkzxl.web.annotation.Response;
import com.github.sparkzxl.log.annotation.HttpRequestLog;
import com.github.sparkzxl.workflow.application.service.ext.IExtProcessTaskDetailService;
import com.github.sparkzxl.workflow.domain.model.dto.process.ProcessTaskDetailDTO;
import com.github.sparkzxl.workflow.domain.model.dto.process.ProcessTaskDetailPageDTO;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessTaskDetail;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * description: 流程节点管理
 *
 * @author charles.zhou
 * @since 2020-07-21 14:53:25
 */
@RestController
@Response
@HttpRequestLog
@RequestMapping("/process/detail")
@Api(tags = "任务节点管理")
@RequiredArgsConstructor
public class ExtProcessTaskDetailController {

    private final IExtProcessTaskDetailService processTaskDetailService;

    @GetMapping("/list")
    @ApiOperation("查询任务节点信息")
    public List<ProcessTaskDetailDTO> getProcessTaskDetail(@ApiParam("模型id") @RequestParam("modelId") String modelId) {
        return processTaskDetailService.getProcessTaskDetail(modelId);
    }

    @GetMapping("/processes")
    @ApiOperation("分页查询任务节点列表")
    public Page<ExtProcessTaskDetail> getProcessTaskDetailList(ProcessTaskDetailPageDTO processTaskDetailPageDTO) {
        return processTaskDetailService.getProcessTaskDetailList(processTaskDetailPageDTO);
    }

}
