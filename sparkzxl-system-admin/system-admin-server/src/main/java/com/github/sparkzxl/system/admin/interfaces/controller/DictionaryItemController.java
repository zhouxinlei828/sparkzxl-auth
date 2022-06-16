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
import com.github.sparkzxl.system.admin.api.model.vo.DictionaryItemVO;
import com.github.sparkzxl.system.admin.api.model.dto.DictionaryItemDTO;

import com.github.sparkzxl.system.admin.application.service.IDictionaryItemService;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 字典项 前端控制器
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Slf4j
@Response
@RestController
@RequestMapping("/dictionary-item")
@Api(tags = {"字典项管理"})
@RequiredArgsConstructor
public class DictionaryItemController {

    private final IDictionaryItemService dictionaryItemService;

    /**
     * 字典项分页查询
     *
     * @param current: 当前页
     * @param size: 分页显示数量
     * @param dictionaryItemDTO: 字典项DTO分页查询对象
     * @return Page<DictionaryItem>
     */
    @ApiOperation(value = "字典项分页查询", httpMethod = "POST", response = Page.class)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "current", value = "当前页", dataType = "int", example = "1"),
        @ApiImplicitParam(name = "size", value = "分页显示数量", dataType = "int", example = "10"),
    })
    @PostMapping("/page")
    public Page<DictionaryItemVO> dictionaryItemPage(@RequestParam(value="current") Integer current,@RequestParam(value="size") Integer size,
                                                    @RequestBody DictionaryItemDTO dictionaryItemDTO) {
        return dictionaryItemService.page(new Page<>(current, size), dictionaryItemDTO);
    }


    /**
     * 字典项列表查询
     *
     * @param dictionaryItemDTO: 字典项DTO列表查询对象
     * @return List<DictionaryItemVO>
     */
    @ApiOperation(value = "字典项列表查询", httpMethod = "POST", response = DictionaryItemVO.class)
    @PostMapping("/list")
    public List<DictionaryItemVO> dictionaryItemList(@RequestBody DictionaryItemDTO dictionaryItemDTO) {
        return dictionaryItemService.list(dictionaryItemDTO);
    }

    /**
     * 字典项详情查询
     *
     * @param id id
     * @return DictionaryItemVO
     */
    @ApiOperation(value = "字典项详情查询", httpMethod = "GET", response = DictionaryItemVO.class)
    @GetMapping("/getById")
    public DictionaryItemVO getDictionaryItemById(@RequestParam(value="id") Long id) {
        return dictionaryItemService.getById(id);
    }

    /**
     * 字典项新增
     *
     * @param dictionaryItemDTO: 字典项新增DTO
     * @return boolean
     */
    @ApiOperation(value = "字典项新增", httpMethod = "POST", response = Boolean.class)
    @PostMapping("/save")
    public boolean saveDictionaryItem(@Validated @RequestBody DictionaryItemDTO dictionaryItemDTO) {
        return dictionaryItemService.save(dictionaryItemDTO);
    }


    /**
     * 字典项修改
     *
     * @param dictionaryItemDTO: 字典项修改DTO
     * @return boolean
     */
    @ApiOperation(value = "字典项修改", httpMethod = "POST", response = Boolean.class)
    @PostMapping("/update")
    public boolean updateDictionaryItem(@Validated @RequestBody DictionaryItemDTO dictionaryItemDTO) {
        return dictionaryItemService.updateById(dictionaryItemDTO);
    }


    /**
     * 字典项删除
     *
     * @param id id
     * @return Boolean
     */
    @ApiOperation(value = "字典项删除", httpMethod = "DELETE", response = Boolean.class)
    @DeleteMapping("/delete")
    public Boolean deleteById(@RequestParam(value="id") Long id) {
        return dictionaryItemService.deleteById(id);
    }

    /**
     * Excel导入
     * @param multipartFile: 文件
     * @return Integer
     */
    @ApiOperation(value = "Excel导入", httpMethod = "POST", response = Integer.class)
    @PostMapping("/import")
    public Integer importData(@RequestParam("file") MultipartFile multipartFile) {
        return dictionaryItemService.importExcel(multipartFile);
    }

    /**
     * Excel导出
     * @param dictionaryItemDTO 字典项导出DTO
     */
    @ApiOperation(value = "Excel导出", httpMethod = "POST", response = Integer.class)
    @RequestMapping(value = "/export", method = RequestMethod.POST, produces = "application/octet-stream")
    public void exportData(@RequestBody DictionaryItemDTO dictionaryItemDTO, HttpServletResponse response) {
        dictionaryItemService.exportData(dictionaryItemDTO,response);
    }

}
