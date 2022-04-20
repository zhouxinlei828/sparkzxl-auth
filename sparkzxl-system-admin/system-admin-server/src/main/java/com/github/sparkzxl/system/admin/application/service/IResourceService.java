package com.github.sparkzxl.system.admin.application.service;

import com.github.sparkzxl.system.admin.infrastructure.entity.Resource;
import com.github.sparkzxl.system.admin.api.model.vo.ResourceVO;
import com.github.sparkzxl.system.admin.api.model.dto.ResourceDTO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 资源信息 服务类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
public interface IResourceService {


    /**
    * 资源信息分页条件查询
    * @param page 分页入参
    * @param resourceDTO: 资源信息DTO分页查询对象
    * @return Page<ResourceVO>
    */
    Page<ResourceVO> page(Page<Resource> page, ResourceDTO resourceDTO);


    /**
     * 资源信息集合条件查询
     * @param resourceDTO: 资源信息DTO查询对象
     * @return List<ResourceVO>
     */
    List<ResourceVO> list(ResourceDTO resourceDTO);


    /**
     * 根据id查询资源信息
     * @param id id
     * @return ResourceVO
     */
    ResourceVO getById(Long id);

    /**
     * 新增资源信息
     * @param resourceDTO: 资源信息新增DTO
     * @return boolean
     */
     boolean save(ResourceDTO resourceDTO);


    /**
     * 修改资源信息
     * @param resourceDTO 资源信息修改DTO
     * @return boolean
     */
     boolean updateById(ResourceDTO resourceDTO);


    /**
     * 根据id删除资源信息
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
      * @param resourceDTO 资源信息导出DTO
      * @param response http response
      */
     void exportData(ResourceDTO resourceDTO, HttpServletResponse response);
}
