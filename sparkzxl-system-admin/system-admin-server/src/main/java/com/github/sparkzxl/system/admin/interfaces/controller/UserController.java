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
import com.github.sparkzxl.system.admin.api.model.vo.UserVO;
import com.github.sparkzxl.system.admin.api.model.dto.UserDTO;

import com.github.sparkzxl.system.admin.application.service.IUserService;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 用户信息 前端控制器
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Slf4j
@Response
@RestController
@RequestMapping("/user")
@Api(tags = {"用户信息管理"})
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    /**
     * 用户信息分页查询
     *
     * @param current: 当前页
     * @param size: 分页显示数量
     * @param userDTO: 用户信息DTO分页查询对象
     * @return Page<User>
     */
    @ApiOperation(value = "用户信息分页查询", httpMethod = "POST", response = Page.class)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "current", value = "当前页", dataType = "int", example = "1"),
        @ApiImplicitParam(name = "size", value = "分页显示数量", dataType = "int", example = "10"),
    })
    @PostMapping("/page")
    public Page<UserVO> userPage(@RequestParam(value="current") Integer current,@RequestParam(value="size") Integer size,
                                                    @RequestBody UserDTO userDTO) {
        return userService.page(new Page<>(current, size), userDTO);
    }


    /**
     * 用户信息列表查询
     *
     * @param userDTO: 用户信息DTO列表查询对象
     * @return List<UserVO>
     */
    @ApiOperation(value = "用户信息列表查询", httpMethod = "POST", response = UserVO.class)
    @PostMapping("/list")
    public List<UserVO> userList(@RequestBody UserDTO userDTO) {
        return userService.list(userDTO);
    }

    /**
     * 用户信息详情查询
     *
     * @param id id
     * @return UserVO
     */
    @ApiOperation(value = "用户信息详情查询", httpMethod = "GET", response = UserVO.class)
    @GetMapping("/getById")
    public UserVO getUserById(@RequestParam(value="id") Long id) {
        return userService.getById(id);
    }

    /**
     * 用户信息新增
     *
     * @param userDTO: 用户信息新增DTO
     * @return boolean
     */
    @ApiOperation(value = "用户信息新增", httpMethod = "POST", response = Boolean.class)
    @PostMapping("/save")
    public boolean saveUser(@Validated @RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }


    /**
     * 用户信息修改
     *
     * @param userDTO: 用户信息修改DTO
     * @return boolean
     */
    @ApiOperation(value = "用户信息修改", httpMethod = "POST", response = Boolean.class)
    @PostMapping("/update")
    public boolean updateUser(@Validated @RequestBody UserDTO userDTO) {
        return userService.updateById(userDTO);
    }


    /**
     * 用户信息删除
     *
     * @param id id
     * @return Boolean
     */
    @ApiOperation(value = "用户信息删除", httpMethod = "DELETE", response = Boolean.class)
    @DeleteMapping("/delete")
    public Boolean deleteById(@RequestParam(value="id") Long id) {
        return userService.deleteById(id);
    }

    /**
     * Excel导入
     * @param multipartFile: 文件
     * @return Integer
     */
    @ApiOperation(value = "Excel导入", httpMethod = "POST", response = Integer.class)
    @PostMapping("/import")
    public Integer importData(@RequestParam("file") MultipartFile multipartFile) {
        return userService.importExcel(multipartFile);
    }

    /**
     * Excel导出
     * @param userDTO 用户信息导出DTO
     */
    @ApiOperation(value = "Excel导出", httpMethod = "POST", response = Integer.class)
    @RequestMapping(value = "/export", method = RequestMethod.POST, produces = "application/octet-stream")
    public void exportData(@RequestBody UserDTO userDTO, HttpServletResponse response) {
        userService.exportData(userDTO,response);
    }

}
