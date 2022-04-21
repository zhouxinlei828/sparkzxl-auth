package ${package.Controller};

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
import ${customFileConfig.voConfig.packageName}.${entity}VO;
import ${customFileConfig.saveDtoFileConfig.packageName}.${entity}SaveDTO;
import ${customFileConfig.updateDtoFileConfig.packageName}.${entity}UpdateDTO;
import ${customFileConfig.dtoConfig.packageName}.${entity}DTO;

<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>
import ${customFileConfig.insideServiceConfig.packageName}.I${entity}Service;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Slf4j
@Response
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
@Api(tags = {"${table.comment!}管理"})
@RequiredArgsConstructor
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>

    private final I${entity}Service ${entity?uncap_first}Service;

    /**
     * ${table.comment!}分页查询
     *
     * @param current: 当前页
     * @param size: 分页显示数量
     * @param ${entity?uncap_first}DTO: ${table.comment!}DTO分页查询对象
     * @return Page<${entity}>
     */
    @ApiOperation(value = "${table.comment!}分页查询", httpMethod = "POST", response = Page.class)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "current", value = "当前页", dataType = "int", example = "1"),
        @ApiImplicitParam(name = "size", value = "分页显示数量", dataType = "int", example = "10"),
    })
    @PostMapping("/page")
    public Page<${entity}VO> ${entity?uncap_first}Page(@RequestParam(value="current") Integer current,@RequestParam(value="size") Integer size,
                                                    @RequestBody ${entity}DTO ${entity?uncap_first}DTO) {
        return ${entity?uncap_first}Service.page(new Page<>(current, size), ${entity?uncap_first}DTO);
    }


    /**
     * ${table.comment!}列表查询
     *
     * @param ${entity?uncap_first}DTO: ${table.comment!}DTO列表查询对象
     * @return List<${entity}VO>
     */
    @ApiOperation(value = "${table.comment!}列表查询", httpMethod = "POST", response = ${entity}VO.class)
    @PostMapping("/list")
    public List<${entity}VO> ${entity?uncap_first}List(@RequestBody ${entity}DTO ${entity?uncap_first}DTO) {
        return ${entity?uncap_first}Service.list(${entity?uncap_first}DTO);
    }

    /**
     * ${table.comment!}详情查询
     *
     * @param id id
     * @return ${entity}VO
     */
    @ApiOperation(value = "${table.comment!}详情查询", httpMethod = "GET", response = ${entity}VO.class)
    @GetMapping("/getById")
    public ${entity}VO get${entity}ById(@RequestParam(value="id") Long id) {
        return ${entity?uncap_first}Service.getById(id);
    }

    /**
     * ${table.comment!}新增
     *
     * @param ${entity?uncap_first}SaveDTO: ${table.comment!}新增DTO
     * @return boolean
     */
    @ApiOperation(value = "${table.comment!}新增", httpMethod = "POST", response = Boolean.class)
    @PostMapping("/save")
    public boolean save${entity}(@Validated @RequestBody ${entity}SaveDTO ${entity?uncap_first}SaveDTO) {
        return ${entity?uncap_first}Service.save(${entity?uncap_first}SaveDTO);
    }


    /**
     * ${table.comment!}修改
     *
     * @param ${entity?uncap_first}UpdateDTO: ${table.comment!}修改DTO
     * @return boolean
     */
    @ApiOperation(value = "${table.comment!}修改", httpMethod = "POST", response = boolean.class)
    @PostMapping("/update")
    public boolean update${entity}(@Validated @RequestBody ${entity}UpdateDTO ${entity?uncap_first}UpdateDTO) {
        return ${entity?uncap_first}Service.updateById(${entity?uncap_first}UpdateDTO);
    }


    /**
     * ${table.comment!}删除
     *
     * @param id id
     * @return Boolean
     */
    @ApiOperation(value = "${table.comment!}删除", httpMethod = "DELETE", response = boolean.class)
    @DeleteMapping("/delete")
    public boolean deleteById(@RequestParam(value="id") Long id) {
        return ${entity?uncap_first}Service.deleteById(id);
    }

    /**
     * Excel导入
     * @param multipartFile: 文件
     * @return Integer
     */
    @ApiOperation(value = "Excel导入", httpMethod = "POST", response = Integer.class)
    @PostMapping("/import")
    public Integer importData(@RequestParam("file") MultipartFile multipartFile) {
        return ${entity?uncap_first}Service.importExcel(multipartFile);
    }

    /**
     * Excel导出
     * @param ${entity?uncap_first}DTO ${table.comment!}导出DTO
     */
    @ApiOperation(value = "Excel导出", httpMethod = "POST", response = Integer.class)
    @RequestMapping(value = "/export", method = RequestMethod.POST, produces = "application/octet-stream")
    public void exportData(@RequestBody ${entity}DTO ${entity?uncap_first}DTO, HttpServletResponse response) {
        ${entity?uncap_first}Service.exportData(${entity?uncap_first}DTO,response);
    }

}
</#if>
