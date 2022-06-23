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
import com.github.sparkzxl.system.admin.api.model.vo.DictionaryVO;
import com.github.sparkzxl.system.admin.api.model.dto.DictionaryDTO;

import com.github.sparkzxl.system.admin.application.service.IDictionaryService;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 字典类型 前端控制器
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Slf4j
@Response
@RestController
@RequestMapping("/dictionary")
@Api(tags = {"字典类型管理"})
@RequiredArgsConstructor
public class DictionaryController {

    private final IDictionaryService dictionaryService;

    /**
     * 字典类型分页查询
     *
     * @param current: 当前页
     * @param size: 分页显示数量
     * @param dictionaryDTO: 字典类型DTO分页查询对象
     * @return Page<Dictionary>
     */
    @ApiOperation(value = "字典类型分页查询", httpMethod = "POST", response = Page.class)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "current", value = "当前页", dataType = "int", example = "1"),
        @ApiImplicitParam(name = "size", value = "分页显示数量", dataType = "int", example = "10"),
    })
    @PostMapping("/page")
    public Page<DictionaryVO> dictionaryPage(@RequestParam(value="current") Integer current,@RequestParam(value="size") Integer size,
                                                    @RequestBody DictionaryDTO dictionaryDTO) {
        return dictionaryService.page(new Page<>(current, size), dictionaryDTO);
    }


    /**
     * 字典类型列表查询
     *
     * @param dictionaryDTO: 字典类型DTO列表查询对象
     * @return List<DictionaryVO>
     */
    @ApiOperation(value = "字典类型列表查询", httpMethod = "POST", response = DictionaryVO.class)
    @PostMapping("/list")
    public List<DictionaryVO> dictionaryList(@RequestBody DictionaryDTO dictionaryDTO) {
        return dictionaryService.list(dictionaryDTO);
    }

    /**
     * 字典类型详情查询
     *
     * @param id id
     * @return DictionaryVO
     */
    @ApiOperation(value = "字典类型详情查询", httpMethod = "GET", response = DictionaryVO.class)
    @GetMapping("/getById")
    public DictionaryVO getDictionaryById(@RequestParam(value="id") Long id) {
        return dictionaryService.getById(id);
    }

    /**
     * 字典类型新增
     *
     * @param dictionaryDTO: 字典类型新增DTO
     * @return boolean
     */
    @ApiOperation(value = "字典类型新增", httpMethod = "POST", response = Boolean.class)
    @PostMapping("/save")
    public boolean saveDictionary(@Validated @RequestBody DictionaryDTO dictionaryDTO) {
        return dictionaryService.save(dictionaryDTO);
    }


    /**
     * 字典类型修改
     *
     * @param dictionaryDTO: 字典类型修改DTO
     * @return boolean
     */
    @ApiOperation(value = "字典类型修改", httpMethod = "POST", response = Boolean.class)
    @PostMapping("/update")
    public boolean updateDictionary(@Validated @RequestBody DictionaryDTO dictionaryDTO) {
        return dictionaryService.updateById(dictionaryDTO);
    }


    /**
     * 字典类型删除
     *
     * @param id id
     * @return Boolean
     */
    @ApiOperation(value = "字典类型删除", httpMethod = "DELETE", response = Boolean.class)
    @DeleteMapping("/delete")
    public Boolean deleteById(@RequestParam(value="id") Long id) {
        return dictionaryService.deleteById(id);
    }

    /**
     * Excel导入
     * @param multipartFile: 文件
     * @return Integer
     */
    @ApiOperation(value = "Excel导入", httpMethod = "POST", response = Integer.class)
    @PostMapping("/import")
    public Integer importData(@RequestParam("file") MultipartFile multipartFile) {
        return dictionaryService.importExcel(multipartFile);
    }

    /**
     * Excel导出
     * @param dictionaryDTO 字典类型导出DTO
     */
    @ApiOperation(value = "Excel导出", httpMethod = "POST", response = Integer.class)
    @RequestMapping(value = "/export", method = RequestMethod.POST, produces = "application/octet-stream")
    public void exportData(@RequestBody DictionaryDTO dictionaryDTO, HttpServletResponse response) {
        dictionaryService.exportData(dictionaryDTO,response);
    }

}
