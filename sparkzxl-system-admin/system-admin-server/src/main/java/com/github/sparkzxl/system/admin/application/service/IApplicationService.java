package com.github.sparkzxl.system.admin.application.service;

import com.github.sparkzxl.system.admin.infrastructure.entity.Application;
import com.github.sparkzxl.system.admin.api.model.vo.ApplicationVO;
import com.github.sparkzxl.system.admin.api.model.dto.ApplicationDTO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 应用 服务类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
public interface IApplicationService {


    /**
    * 应用分页条件查询
    * @param page 分页入参
    * @param applicationDTO: 应用DTO分页查询对象
    * @return Page<ApplicationVO>
    */
    Page<ApplicationVO> page(Page<Application> page, ApplicationDTO applicationDTO);


    /**
     * 应用集合条件查询
     * @param applicationDTO: 应用DTO查询对象
     * @return List<ApplicationVO>
     */
    List<ApplicationVO> list(ApplicationDTO applicationDTO);


    /**
     * 根据id查询应用
     * @param id id
     * @return ApplicationVO
     */
    ApplicationVO getById(Long id);

    /**
     * 新增应用
     * @param applicationDTO: 应用新增DTO
     * @return boolean
     */
     boolean save(ApplicationDTO applicationDTO);


    /**
     * 修改应用
     * @param applicationDTO 应用修改DTO
     * @return boolean
     */
     boolean updateById(ApplicationDTO applicationDTO);


    /**
     * 根据id删除应用
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
      * @param applicationDTO 应用导出DTO
      * @param response http response
      */
     void exportData(ApplicationDTO applicationDTO, HttpServletResponse response);
}
