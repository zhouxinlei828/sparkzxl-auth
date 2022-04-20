package ${customFileConfig.insideServiceImplConfig.packageName};

import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};
import ${customFileConfig.insideServiceConfig.packageName}.I${entity}Service;
import ${customFileConfig.convertConfig.packageName}.${entity}Convert;
import ${customFileConfig.voConfig.packageName}.${entity}VO;
import ${customFileConfig.dtoConfig.packageName}.${entity}DTO;
import org.apache.commons.lang3.ObjectUtils;
import com.github.sparkzxl.core.support.ExceptionAssert;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;

import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 * ${table.comment!} 服务实现类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Slf4j
@Service
<#if kotlin>
open class ${table.serviceImplName}ServiceImpl : I${entity}Service {

}
<#else>
@RequiredArgsConstructor
public class ${entity}ServiceImpl implements I${entity}Service {

    private final ${table.serviceName} ${table.serviceName?uncap_first};

    /**
    * 分页条件查询
    * @author ${author}
    * @since ${date}
    * @param ${entity?uncap_first}DTO: ${table.comment!}DTO对象
    * @param page: 分页入参
    * @return Page<${entity}VO>
    */
    @Override
    public Page<${entity}VO> page(Page<${entity}> page, ${entity}DTO ${entity?uncap_first}DTO) {
        queryPageCheck(${entity?uncap_first}DTO);
        ${entity} ${entity?uncap_first} = convertPageQuery${entity}(${entity?uncap_first}DTO);
        QueryWrapper<${entity}> queryWrapper = new QueryWrapper<>(${entity?uncap_first});
        buildPageQueryWrapper(${entity?uncap_first}, queryWrapper);
        Page<${entity}> ${entity?uncap_first}Page = ${table.serviceName?uncap_first}.page(page, queryWrapper);
        return assignment(convert${entity}PageVO(${entity?uncap_first}Page));
    }

    /**
     * 分页条件检查
     * @author ${author}
     * @since ${date}
     * @param ${entity?uncap_first}DTO: ${table.comment!}DTO对象
     */
    private void queryPageCheck(${entity}DTO ${entity?uncap_first}DTO) {

    }

    /**
     * 分页查询模型转换
     * @author ${author}
     * @since ${date}
     * @param ${entity?uncap_first}DTO: ${table.comment!}DTO对象
     * @return ${entity}
     */
     private ${entity} convertPageQuery${entity}(${entity}DTO ${entity?uncap_first}DTO){
        return ${entity}Convert.INSTANCE.convert${entity}(${entity?uncap_first}DTO);
    }

    /**
     * 构建分页查询条件
     *
     * @author ${author}
     * @since ${date}
     * @param ${entity?uncap_first}: ${table.comment!}
     * @param queryWrapper: 查询Wrapper
     */
    private void buildPageQueryWrapper(${entity} ${entity?uncap_first}, QueryWrapper<${entity}> queryWrapper) {

    }

    /**
     * 分页,增强返回参数追加
     *
     * @author ${author}
     * @since ${date}
     * @param ${entity?uncap_first}VOPage: 分页显示VO
     * @return Page<${entity}>
     */
    private Page<${entity}VO> assignment(Page<${entity}VO> ${entity?uncap_first}VOPage) {
        ${entity?uncap_first}VOPage.getRecords().forEach(${entity?uncap_first}VO -> {
        });
        return ${entity?uncap_first}VOPage;
    }

    /**
     * 分页显示模型转换
     *
     * @author ${author}
     * @since ${date}
     * @param page: 分页显示VO
     * @return Page<${entity}>
     */
     private Page<${entity}VO> convert${entity}PageVO(Page<${entity}> page){
        return ${entity}Convert.INSTANCE.convert${entity}PageVO(page);
    }

    /**
     * 集合条件查询
     * @author ${author}
     * @since ${date}
     * @param ${entity?uncap_first}DTO: ${table.comment!}DTO对象
     * @return List<${entity}VO>
     */
    @Override
    public List<${entity}VO> list(${entity}DTO ${entity?uncap_first}DTO) {
        queryListCheck(${entity?uncap_first}DTO);
        ${entity} ${entity?uncap_first} = convert${entity}ListQuery(${entity?uncap_first}DTO);
        QueryWrapper<${entity}> queryWrapper = new QueryWrapper<>(${entity?uncap_first});
        buildListQueryWrapper(${entity?uncap_first}, queryWrapper);
        List<${entity}> ${entity?uncap_first}List = ${table.serviceName?uncap_first}.list(queryWrapper);
        List<${entity}VO> ${entity?uncap_first}VOList = convert${entity}VOList(${entity?uncap_first}List);
        return assignment(${entity?uncap_first}VOList);
    }

    /**
     * 集合条件检查
     * @author ${author}
     * @since ${date}
     * @param ${entity?uncap_first}DTO: ${table.comment!}DTO对象
     */
     private void queryListCheck(${entity}DTO ${entity?uncap_first}DTO) {

    }

    /**
    * 列表查询模型转换
    *
    * @author ${author}
    * @since ${date}
    * @param ${entity?uncap_first}DTO: ${table.comment!}DTO对象
    * @return Page<${entity}>
    */
    private ${entity} convert${entity}ListQuery(${entity}DTO ${entity?uncap_first}DTO){
        return ${entity}Convert.INSTANCE.convert${entity}(${entity?uncap_first}DTO);
    }

    /**
    * 构建列表查询条件
    *
    * @author ${author}
    * @since ${date}
    * @param ${entity?uncap_first}: ${table.comment!}
    * @param queryWrapper: 查询Wrapper
    */
    private void buildListQueryWrapper(${entity} ${entity?uncap_first}, QueryWrapper<${entity}> queryWrapper) {

    }

    /**
     * 列表显示模型转换
     *
     * @author ${author}
     * @since ${date}
     * @param ${entity?uncap_first}List: ${table.comment!}列表
     * @return List<${entity}VO>
     */
     public List<${entity}VO> convert${entity}VOList(List<${entity}> ${entity?uncap_first}List){
         return ${entity}Convert.INSTANCE.convert${entity}VOList(${entity?uncap_first}List);
     }

     /**
      * 集合,增强返回参数追加
      *
      * @author ${author}
      * @since ${date}
      * @param ${entity?uncap_first}VOList: ${table.comment!}VO列表
      * @return List<${entity}>
      */
     private List<${entity}VO> assignment(List<${entity}VO> ${entity?uncap_first}VOList) {
        ${entity?uncap_first}VOList.forEach(${entity?uncap_first}VO -> {
        });
        return  ${entity?uncap_first}VOList;
     }

    /**
     * 单条条件查询
     * @author ${author}
     * @since ${date}
     * @param id: id
     * @return ${entity}VO
     */
    @Override
    public ${entity}VO getById(Long id) {
        ${entity} ${entity?uncap_first} = ${table.serviceName?uncap_first}.getById(id);
        ${entity}VO ${entity?uncap_first}VO = convert${entity}VO(${entity?uncap_first});
        return assignment(${entity?uncap_first}VO);
    }

    /**
     * 详情显示模型转换
     *
     * @author ${author}
     * @since ${date}
     * @param ${entity?uncap_first}: ${table.comment!}
     * @return ${entity}VO
     */
     private ${entity}VO convert${entity}VO(${entity} ${entity?uncap_first}){
        return ${entity}Convert.INSTANCE.convert${entity}VO(${entity?uncap_first});
    }

    /**
     * 单条，增强返回参数追加
     *
     * @author ${author}
     * @since ${date}
     * @param ${entity?uncap_first}VO: ${table.comment!}VO
     * @return ${entity}
     */
    private ${entity}VO assignment(${entity}VO ${entity?uncap_first}VO) {
        return ${entity?uncap_first}VO;
    }

    /**
     * 新增
     * @author ${author}
     * @since ${date}
     * @param ${entity?uncap_first}DTO: ${table.comment!}DTO对象
     * @return boolean
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public boolean save(${entity}DTO ${entity?uncap_first}DTO) {
        saveCheck(${entity?uncap_first}DTO);
        ${entity} ${entity?uncap_first} = convert${entity}SaveModel(${entity?uncap_first}DTO);
        return ${table.serviceName?uncap_first}.save(${entity?uncap_first});
    }

    /**
     * 保存检查
     * @author ${author}
     * @since ${date}
     * @param ${entity?uncap_first}DTO: ${table.comment!}DTO对象
     */
    private void saveCheck(${entity}DTO ${entity?uncap_first}DTO) {

    }

    /**
     * 新增模型转换
     *
     * @author ${author}
     * @since ${date}
     * @param ${entity?uncap_first}DTO: ${table.comment!}DTO对象
     * @return ${entity}
     */
     private ${entity} convert${entity}SaveModel(${entity}DTO ${entity?uncap_first}DTO){
        return ${entity}Convert.INSTANCE.convert${entity}(${entity?uncap_first}DTO);
    }

    /**
     * 修改
     * @author ${author}
     * @since ${date}
     * @param ${entity?uncap_first}DTO: ${table.comment!}修改DTO
     * @return boolean
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public boolean updateById(${entity}DTO ${entity?uncap_first}DTO) {
        updateCheck(${entity?uncap_first}DTO);
        ${entity} ${entity?uncap_first} = convertUpdate${entity}Model(${entity?uncap_first}DTO);
        LambdaUpdateWrapper<${entity}> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        buildUpdateWrapper(${entity?uncap_first},lambdaUpdateWrapper);
        return ${table.serviceName?uncap_first}.update(${entity?uncap_first},lambdaUpdateWrapper);
    }

    /**
     * 更新检查
     * @author ${author}
     * @since ${date}
     * @param ${entity?uncap_first}DTO: ${table.comment!}DTO对象
     */
     private void updateCheck(${entity}DTO ${entity?uncap_first}DTO) {

    }

    /**
     * 构建修改条件
     *
     * @author ${author}
     * @since ${date}
     * @param ${entity?uncap_first}: ${table.comment!}
     * @param updateWrapper: 更新Wrapper
     */
    private void buildUpdateWrapper(${entity} ${entity?uncap_first}, LambdaUpdateWrapper<${entity}> updateWrapper) {
        // 更新条件以及设值
        updateWrapper.eq(${entity}::getId,${entity?uncap_first}.getId());
    }

    /**
     * 修改模型转换
     *
     * @author ${author}
     * @since ${date}
     * @param ${entity?uncap_first}DTO: ${table.comment!}DTO对象
     * @return ${entity}
     */
    public ${entity} convertUpdate${entity}Model(${entity}DTO ${entity?uncap_first}DTO){
        if(ObjectUtils.isEmpty(${entity?uncap_first}DTO.getId())){
            ExceptionAssert.failure("id不能为空");
        }
        return ${entity}Convert.INSTANCE.convert${entity}(${entity?uncap_first}DTO);
    }

    /**
     * 删除
     * @author ${author}
     * @since ${date}
     * @param id: id
     * @return boolean
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public boolean deleteById(Long id) {
        return ${table.serviceName?uncap_first}.removeById(id);
    }

    /**
     * Excel导入
     * @author ${author}
     * @since ${date}
     * @param multipartFile: 文件
     * @return Integer
     */
    @Override
    public Integer importExcel(MultipartFile multipartFile){
        return 0;
    }

    /**
     * Excel导出
     * @author ${author}
     * @since ${date}
     * @param ${entity?uncap_first}DTO ${table.comment!}导出DTO
     * @param response http response
     */
     @Override
     public void exportData(${entity}DTO ${entity?uncap_first}DTO, HttpServletResponse response){

    }
}

</#if>
