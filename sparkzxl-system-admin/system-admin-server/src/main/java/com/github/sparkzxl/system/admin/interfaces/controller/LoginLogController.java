package com.github.sparkzxl.system.admin.interfaces.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import com.github.sparkzxl.web.annotation.Response;

import org.springframework.validation.annotation.Validated;
import io.swagger.annotations.Api;
import com.github.sparkzxl.system.admin.api.model.vo.LoginLogVO;
import com.github.sparkzxl.system.admin.api.model.dto.LoginLogDTO;

import com.github.sparkzxl.system.admin.application.service.ILoginLogService;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 登录日志 前端控制器
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Slf4j
@Response
@RestController
@RequestMapping("/login-log")
@Api(tags = {"登录日志管理"})
@RequiredArgsConstructor
public class LoginLogController {

    private final ILoginLogService loginLogService;

    /**
     * 登录日志分页查询
     *
     * @param current: 当前页
     * @param size: 分页显示数量
     * @param loginLogDTO: 登录日志DTO分页查询对象
     * @return Page<LoginLog>
     */
    @ApiOperation(value = "登录日志分页查询", httpMethod = "POST", response = Page.class)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "current", value = "当前页", dataType = "int", example = "1"),
        @ApiImplicitParam(name = "size", value = "分页显示数量", dataType = "int", example = "10"),
    })
    @PostMapping("/page")
    public Page<LoginLogVO> loginLogPage(@RequestParam(value="current") Integer current,@RequestParam(value="size") Integer size,
                                                    @RequestBody LoginLogDTO loginLogDTO) {
        return loginLogService.page(new Page<>(current, size), loginLogDTO);
    }


    /**
     * 登录日志列表查询
     *
     * @param loginLogDTO: 登录日志DTO列表查询对象
     * @return List<LoginLogVO>
     */
    @ApiOperation(value = "登录日志列表查询", httpMethod = "POST", response = LoginLogVO.class)
    @PostMapping("/list")
    public List<LoginLogVO> loginLogList(@RequestBody LoginLogDTO loginLogDTO) {
        return loginLogService.list(loginLogDTO);
    }

    /**
     * 登录日志详情查询
     *
     * @param id id
     * @return LoginLogVO
     */
    @ApiOperation(value = "登录日志详情查询", httpMethod = "GET", response = LoginLogVO.class)
    @GetMapping("/getById")
    public LoginLogVO getLoginLogById(@RequestParam(value="id") Long id) {
        return loginLogService.getById(id);
    }

    /**
     * 登录日志新增
     *
     * @param loginLogDTO: 登录日志新增DTO
     * @return boolean
     */
    @ApiOperation(value = "登录日志新增", httpMethod = "POST", response = Boolean.class)
    @PostMapping("/save")
    public boolean saveLoginLog(@Validated @RequestBody LoginLogDTO loginLogDTO) {
        return loginLogService.save(loginLogDTO);
    }


    /**
     * 登录日志修改
     *
     * @param loginLogDTO: 登录日志修改DTO
     * @return boolean
     */
    @ApiOperation(value = "登录日志修改", httpMethod = "POST", response = Boolean.class)
    @PostMapping("/update")
    public boolean updateLoginLog(@Validated @RequestBody LoginLogDTO loginLogDTO) {
        return loginLogService.updateById(loginLogDTO);
    }


    /**
     * 登录日志删除
     *
     * @param id id
     * @return Boolean
     */
    @ApiOperation(value = "登录日志删除", httpMethod = "DELETE", response = Boolean.class)
    @DeleteMapping("/delete")
    public Boolean deleteById(@RequestParam(value="id") Long id) {
        return loginLogService.deleteById(id);
    }

    /**
     * Excel导入
     * @param multipartFile: 文件
     * @return Integer
     */
    @ApiOperation(value = "Excel导入", httpMethod = "POST", response = Integer.class)
    @PostMapping("/import")
    public Integer importData(@RequestParam("file") MultipartFile multipartFile) {
        return loginLogService.importExcel(multipartFile);
    }

    /**
     * Excel导出
     * @param loginLogDTO 登录日志导出DTO
     */
    @ApiOperation(value = "Excel导出", httpMethod = "POST", response = Integer.class)
    @RequestMapping(value = "/export", method = RequestMethod.POST, produces = "application/octet-stream")
    public void exportData(@RequestBody LoginLogDTO loginLogDTO, HttpServletResponse response) {
        loginLogService.exportData(loginLogDTO,response);
    }

}
