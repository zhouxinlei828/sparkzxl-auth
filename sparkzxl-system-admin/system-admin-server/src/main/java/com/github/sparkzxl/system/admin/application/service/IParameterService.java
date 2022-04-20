package com.github.sparkzxl.system.admin.application.service;

import com.github.sparkzxl.system.admin.infrastructure.entity.Parameter;
import com.github.sparkzxl.system.admin.api.model.vo.ParameterVO;
import com.github.sparkzxl.system.admin.api.model.dto.ParameterDTO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 系统参数 服务类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
public interface IParameterService {


    /**
    * 系统参数分页条件查询
    * @param page 分页入参
    * @param parameterDTO: 系统参数DTO分页查询对象
    * @return Page<ParameterVO>
    */
    Page<ParameterVO> page(Page<Parameter> page, ParameterDTO parameterDTO);


    /**
     * 系统参数集合条件查询
     * @param parameterDTO: 系统参数DTO查询对象
     * @return List<ParameterVO>
     */
    List<ParameterVO> list(ParameterDTO parameterDTO);


    /**
     * 根据id查询系统参数
     * @param id id
     * @return ParameterVO
     */
    ParameterVO getById(Long id);

    /**
     * 新增系统参数
     * @param parameterDTO: 系统参数新增DTO
     * @return boolean
     */
     boolean save(ParameterDTO parameterDTO);


    /**
     * 修改系统参数
     * @param parameterDTO 系统参数修改DTO
     * @return boolean
     */
     boolean updateById(ParameterDTO parameterDTO);


    /**
     * 根据id删除系统参数
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
      * @param parameterDTO 系统参数导出DTO
      * @param response http response
      */
     void exportData(ParameterDTO parameterDTO, HttpServletResponse response);
}
