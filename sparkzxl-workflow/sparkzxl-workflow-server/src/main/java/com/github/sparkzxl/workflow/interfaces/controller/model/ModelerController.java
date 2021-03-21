package com.github.sparkzxl.workflow.interfaces.controller.model;

import com.github.pagehelper.PageInfo;
import com.github.sparkzxl.core.annotation.ResponseResult;
import com.github.sparkzxl.database.dto.DeleteDTO;
import com.github.sparkzxl.log.annotation.WebLog;
import com.github.sparkzxl.workflow.application.service.act.IActReModelService;
import com.github.sparkzxl.workflow.application.service.model.IModelerService;
import com.github.sparkzxl.workflow.infrastructure.entity.ActReModel;
import com.github.sparkzxl.workflow.interfaces.dto.act.ModelPageDTO;
import com.github.sparkzxl.workflow.interfaces.dto.model.ModelSaveDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * description:流程控制器
 *
 * @author charles.zhou
 * @date   2020-07-17 14:46:24
 */
@AllArgsConstructor
@RestController
@RequestMapping("/modeler")
@ResponseResult
@WebLog
@Slf4j
@Api(tags = "流程模型管理")
public class ModelerController {

    private final IModelerService modelerService;
    private final IActReModelService actReModelService;

    @ApiOperation("查询流程模型列表")
    @GetMapping("/page")
    @ResponseResult
    public PageInfo<ActReModel> modelList(ModelPageDTO modelPageDTO) {
        return actReModelService.actReModelList(modelPageDTO);
    }

    @ApiOperation("创建模型")
    @PostMapping("/save")
    public String create(@RequestBody @Valid ModelSaveDTO modelSaveDTO) {
        return modelerService.createModel(modelSaveDTO.getName(), modelSaveDTO.getKey());
    }

    @ApiOperation("流程发布")
    @PatchMapping("/publish")
    public boolean publishProcess(@ApiParam("模型ID") @RequestParam("modelId") String modelId) {
        return modelerService.publishProcess(modelId);
    }

    @ApiOperation("流程发布撤销")
    @DeleteMapping("/backout")
    public boolean revokePublish(@ApiParam("模型ID") @RequestParam("modelId") String modelId) {
        return modelerService.revokePublish(modelId);
    }

    @ApiOperation("删除流程")
    @DeleteMapping("/delete")
    public boolean deleteModel(@RequestBody DeleteDTO<String> deleteDTO) {
        return modelerService.deleteModels(deleteDTO.getIds());
    }

}
