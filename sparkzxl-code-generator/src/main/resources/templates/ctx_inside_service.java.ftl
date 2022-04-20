package ${package.Service};

import ${package.Entity}.${entity};
import ${customFileConfig.voConfig.packageName}.${entity}VO;
import ${customFileConfig.dtoConfig.packageName}.${entity}DTO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.serviceName}
<#else>
public interface I${entity}Service {


    /**
    * ${table.comment!}分页条件查询
    * @param page 分页入参
    * @param ${entity?uncap_first}DTO: ${table.comment!}DTO分页查询对象
    * @return Page<${entity}VO>
    */
    Page<${entity}VO> page(Page<${entity}> page, ${entity}DTO ${entity?uncap_first}DTO);


    /**
     * ${table.comment!}集合条件查询
     * @param ${entity?uncap_first}DTO: ${table.comment!}DTO查询对象
     * @return List<${entity}VO>
     */
    List<${entity}VO> list(${entity}DTO ${entity?uncap_first}DTO);


    /**
     * 根据id查询${table.comment!}
     * @param id id
     * @return ${entity}VO
     */
    ${entity}VO getById(Long id);

    /**
     * 新增${table.comment!}
     * @param ${entity?uncap_first}DTO: ${table.comment!}新增DTO
     * @return boolean
     */
     boolean save(${entity}DTO ${entity?uncap_first}DTO);


    /**
     * 修改${table.comment!}
     * @param ${entity?uncap_first}DTO ${table.comment!}修改DTO
     * @return boolean
     */
     boolean updateById(${entity}DTO ${entity?uncap_first}DTO);


    /**
     * 根据id删除${table.comment!}
     * @param id id
     * @return boolean
     */
     boolean deleteById(Long id);


    /**
     * Excel导入
     * @param multipartFile 文件
     * @return Integer
     */
     Integer importExcel(MultipartFile multipartFile);


     /**
      * Excel导出
      * @param ${entity?uncap_first}DTO ${table.comment!}导出DTO
      * @param response http response
      */
     void exportData(${entity}DTO ${entity?uncap_first}DTO, HttpServletResponse response);
}
</#if>
