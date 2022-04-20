package com.github.sparkzxl.system.admin.interfaces.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import com.github.sparkzxl.annotation.response.Response;

import org.springframework.validation.annotation.Validated;
import io.swagger.annotations.Api;
import com.github.sparkzxl.system.admin.api.model.vo.OperateLogVO;
import com.github.sparkzxl.system.admin.api.model.dto.OperateLogDTO;

import com.github.sparkzxl.system.admin.application.service.IOperateLogService;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 系统日志 前端控制器
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Slf4j
@Response
@RestController
@RequestMapping("/operate-log")
@Api(tags = {"系统日志管理"})
@RequiredArgsConstructor
public class OperateLogController {

    private final IOperateLogService operateLogService;

    /**
     * 系统日志分页查询
     *
     * @param current: 当前页
     * @param size: 分页显示数量
     * @param operateLogDTO: 系统日志DTO分页查询对象
     * @return Page<OperateLog>
     */
    @ApiOperation(value = "系统日志分页查询", httpMethod = "POST", response = Page.class)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "current", value = "当前页", dataType = "int", example = "1"),
        @ApiImplicitParam(name = "size", value = "分页显示数量", dataType = "int", example = "10"),
    })
    @PostMapping("/page")
    public Page<OperateLogVO> operateLogPage(@RequestParam(value="current") Integer current,@RequestParam(value="size") Integer size,
                                                    @RequestBody OperateLogDTO operateLogDTO) {
        return operateLogService.page(new Page<>(current, size), operateLogDTO);
    }


    /**
     * 系统日志列表查询
     *
     * @param operateLogDTO: 系统日志DTO列表查询对象
     * @return List<OperateLogVO>
     */
    @ApiOperation(value = "系统日志列表查询", httpMethod = "POST", response = OperateLogVO.class)
    @PostMapping("/list")
    public List<OperateLogVO> operateLogList(@RequestBody OperateLogDTO operateLogDTO) {
        return operateLogService.list(operateLogDTO);
    }

    /**
     * 系统日志详情查询
     *
     * @param id id
     * @return OperateLogVO
     */
    @ApiOperation(value = "系统日志详情查询", httpMethod = "GET", response = OperateLogVO.class)
    @GetMapping("/getById")
    public OperateLogVO getOperateLogById(@RequestParam(value="id") Long id) {
        return operateLogService.getById(id);
    }

    /**
     * 系统日志新增
     *
     * @param operateLogDTO: 系统日志新增DTO
     * @return boolean
     */
    @ApiOperation(value = "系统日志新增", httpMethod = "POST", response = Boolean.class)
    @PostMapping("/save")
    public boolean saveOperateLog(@Validated @RequestBody OperateLogDTO operateLogDTO) {
        return operateLogService.save(operateLogDTO);
    }


    /**
     * 系统日志修改
     *
     * @param operateLogDTO: 系统日志修改DTO
     * @return boolean
     */
    @ApiOperation(value = "系统日志修改", httpMethod = "POST", response = Boolean.class)
    @PostMapping("/update")
    public boolean updateOperateLog(@Validated @RequestBody OperateLogDTO operateLogDTO) {
        return operateLogService.updateById(operateLogDTO);
    }


    /**
     * 系统日志删除
     *
     * @param id id
     * @return Boolean
     */
    @ApiOperation(value = "系统日志删除", httpMethod = "DELETE", response = Boolean.class)
    @DeleteMapping("/delete")
    public Boolean deleteById(@RequestParam(value="id") Long id) {
        return operateLogService.deleteById(id);
    }

    /**
     * Excel导入
     * @param multipartFile: 文件
     * @return Integer
     */
    @ApiOperation(value = "Excel导入", httpMethod = "POST", response = Integer.class)
    @PostMapping("/import")
    public Integer importData(@RequestParam("file") MultipartFile multipartFile) {
        return operateLogService.importExcel(multipartFile);
    }

    /**
     * Excel导出
     * @param operateLogDTO 系统日志导出DTO
     */
    @ApiOperation(value = "Excel导出", httpMethod = "POST", response = Integer.class)
    @RequestMapping(value = "/export", method = RequestMethod.POST, produces = "application/octet-stream")
    public void exportData(@RequestBody OperateLogDTO operateLogDTO, HttpServletResponse response) {
        operateLogService.exportData(operateLogDTO,response);
    }

}
