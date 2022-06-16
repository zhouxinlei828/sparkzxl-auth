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
import com.github.sparkzxl.system.admin.api.model.vo.OrganizationVO;
import com.github.sparkzxl.system.admin.api.model.dto.OrganizationDTO;

import com.github.sparkzxl.system.admin.application.service.IOrganizationService;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 组织 前端控制器
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Slf4j
@Response
@RestController
@RequestMapping("/organization")
@Api(tags = {"组织管理"})
@RequiredArgsConstructor
public class OrganizationController {

    private final IOrganizationService organizationService;

    /**
     * 组织分页查询
     *
     * @param current: 当前页
     * @param size: 分页显示数量
     * @param organizationDTO: 组织DTO分页查询对象
     * @return Page<Organization>
     */
    @ApiOperation(value = "组织分页查询", httpMethod = "POST", response = Page.class)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "current", value = "当前页", dataType = "int", example = "1"),
        @ApiImplicitParam(name = "size", value = "分页显示数量", dataType = "int", example = "10"),
    })
    @PostMapping("/page")
    public Page<OrganizationVO> organizationPage(@RequestParam(value="current") Integer current,@RequestParam(value="size") Integer size,
                                                    @RequestBody OrganizationDTO organizationDTO) {
        return organizationService.page(new Page<>(current, size), organizationDTO);
    }


    /**
     * 组织列表查询
     *
     * @param organizationDTO: 组织DTO列表查询对象
     * @return List<OrganizationVO>
     */
    @ApiOperation(value = "组织列表查询", httpMethod = "POST", response = OrganizationVO.class)
    @PostMapping("/list")
    public List<OrganizationVO> organizationList(@RequestBody OrganizationDTO organizationDTO) {
        return organizationService.list(organizationDTO);
    }

    /**
     * 组织详情查询
     *
     * @param id id
     * @return OrganizationVO
     */
    @ApiOperation(value = "组织详情查询", httpMethod = "GET", response = OrganizationVO.class)
    @GetMapping("/getById")
    public OrganizationVO getOrganizationById(@RequestParam(value="id") Long id) {
        return organizationService.getById(id);
    }

    /**
     * 组织新增
     *
     * @param organizationDTO: 组织新增DTO
     * @return boolean
     */
    @ApiOperation(value = "组织新增", httpMethod = "POST", response = Boolean.class)
    @PostMapping("/save")
    public boolean saveOrganization(@Validated @RequestBody OrganizationDTO organizationDTO) {
        return organizationService.save(organizationDTO);
    }


    /**
     * 组织修改
     *
     * @param organizationDTO: 组织修改DTO
     * @return boolean
     */
    @ApiOperation(value = "组织修改", httpMethod = "POST", response = Boolean.class)
    @PostMapping("/update")
    public boolean updateOrganization(@Validated @RequestBody OrganizationDTO organizationDTO) {
        return organizationService.updateById(organizationDTO);
    }


    /**
     * 组织删除
     *
     * @param id id
     * @return Boolean
     */
    @ApiOperation(value = "组织删除", httpMethod = "DELETE", response = Boolean.class)
    @DeleteMapping("/delete")
    public Boolean deleteById(@RequestParam(value="id") Long id) {
        return organizationService.deleteById(id);
    }

    /**
     * Excel导入
     * @param multipartFile: 文件
     * @return Integer
     */
    @ApiOperation(value = "Excel导入", httpMethod = "POST", response = Integer.class)
    @PostMapping("/import")
    public Integer importData(@RequestParam("file") MultipartFile multipartFile) {
        return organizationService.importExcel(multipartFile);
    }

    /**
     * Excel导出
     * @param organizationDTO 组织导出DTO
     */
    @ApiOperation(value = "Excel导出", httpMethod = "POST", response = Integer.class)
    @RequestMapping(value = "/export", method = RequestMethod.POST, produces = "application/octet-stream")
    public void exportData(@RequestBody OrganizationDTO organizationDTO, HttpServletResponse response) {
        organizationService.exportData(organizationDTO,response);
    }

}
