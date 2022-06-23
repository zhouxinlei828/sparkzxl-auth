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
import com.github.sparkzxl.system.admin.api.model.vo.MenuVO;
import com.github.sparkzxl.system.admin.api.model.dto.MenuDTO;

import com.github.sparkzxl.system.admin.application.service.IMenuService;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 菜单 前端控制器
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Slf4j
@Response
@RestController
@RequestMapping("/menu")
@Api(tags = {"菜单管理"})
@RequiredArgsConstructor
public class MenuController {

    private final IMenuService menuService;

    /**
     * 菜单分页查询
     *
     * @param current: 当前页
     * @param size: 分页显示数量
     * @param menuDTO: 菜单DTO分页查询对象
     * @return Page<Menu>
     */
    @ApiOperation(value = "菜单分页查询", httpMethod = "POST", response = Page.class)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "current", value = "当前页", dataType = "int", example = "1"),
        @ApiImplicitParam(name = "size", value = "分页显示数量", dataType = "int", example = "10"),
    })
    @PostMapping("/page")
    public Page<MenuVO> menuPage(@RequestParam(value="current") Integer current,@RequestParam(value="size") Integer size,
                                                    @RequestBody MenuDTO menuDTO) {
        return menuService.page(new Page<>(current, size), menuDTO);
    }


    /**
     * 菜单列表查询
     *
     * @param menuDTO: 菜单DTO列表查询对象
     * @return List<MenuVO>
     */
    @ApiOperation(value = "菜单列表查询", httpMethod = "POST", response = MenuVO.class)
    @PostMapping("/list")
    public List<MenuVO> menuList(@RequestBody MenuDTO menuDTO) {
        return menuService.list(menuDTO);
    }

    /**
     * 菜单详情查询
     *
     * @param id id
     * @return MenuVO
     */
    @ApiOperation(value = "菜单详情查询", httpMethod = "GET", response = MenuVO.class)
    @GetMapping("/getById")
    public MenuVO getMenuById(@RequestParam(value="id") Long id) {
        return menuService.getById(id);
    }

    /**
     * 菜单新增
     *
     * @param menuDTO: 菜单新增DTO
     * @return boolean
     */
    @ApiOperation(value = "菜单新增", httpMethod = "POST", response = Boolean.class)
    @PostMapping("/save")
    public boolean saveMenu(@Validated @RequestBody MenuDTO menuDTO) {
        return menuService.save(menuDTO);
    }


    /**
     * 菜单修改
     *
     * @param menuDTO: 菜单修改DTO
     * @return boolean
     */
    @ApiOperation(value = "菜单修改", httpMethod = "POST", response = Boolean.class)
    @PostMapping("/update")
    public boolean updateMenu(@Validated @RequestBody MenuDTO menuDTO) {
        return menuService.updateById(menuDTO);
    }


    /**
     * 菜单删除
     *
     * @param id id
     * @return Boolean
     */
    @ApiOperation(value = "菜单删除", httpMethod = "DELETE", response = Boolean.class)
    @DeleteMapping("/delete")
    public Boolean deleteById(@RequestParam(value="id") Long id) {
        return menuService.deleteById(id);
    }

    /**
     * Excel导入
     * @param multipartFile: 文件
     * @return Integer
     */
    @ApiOperation(value = "Excel导入", httpMethod = "POST", response = Integer.class)
    @PostMapping("/import")
    public Integer importData(@RequestParam("file") MultipartFile multipartFile) {
        return menuService.importExcel(multipartFile);
    }

    /**
     * Excel导出
     * @param menuDTO 菜单导出DTO
     */
    @ApiOperation(value = "Excel导出", httpMethod = "POST", response = Integer.class)
    @RequestMapping(value = "/export", method = RequestMethod.POST, produces = "application/octet-stream")
    public void exportData(@RequestBody MenuDTO menuDTO, HttpServletResponse response) {
        menuService.exportData(menuDTO,response);
    }

}
