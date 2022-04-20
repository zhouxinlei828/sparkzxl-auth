package com.github.sparkzxl.system.admin.application.service;

import com.github.sparkzxl.system.admin.infrastructure.entity.Organization;
import com.github.sparkzxl.system.admin.api.model.vo.OrganizationVO;
import com.github.sparkzxl.system.admin.api.model.dto.OrganizationDTO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 组织 服务类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
public interface IOrganizationService {


    /**
    * 组织分页条件查询
    * @param page 分页入参
    * @param organizationDTO: 组织DTO分页查询对象
    * @return Page<OrganizationVO>
    */
    Page<OrganizationVO> page(Page<Organization> page, OrganizationDTO organizationDTO);


    /**
     * 组织集合条件查询
     * @param organizationDTO: 组织DTO查询对象
     * @return List<OrganizationVO>
     */
    List<OrganizationVO> list(OrganizationDTO organizationDTO);


    /**
     * 根据id查询组织
     * @param id id
     * @return OrganizationVO
     */
    OrganizationVO getById(Long id);

    /**
     * 新增组织
     * @param organizationDTO: 组织新增DTO
     * @return boolean
     */
     boolean save(OrganizationDTO organizationDTO);


    /**
     * 修改组织
     * @param organizationDTO 组织修改DTO
     * @return boolean
     */
     boolean updateById(OrganizationDTO organizationDTO);


    /**
     * 根据id删除组织
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
      * @param organizationDTO 组织导出DTO
      * @param response http response
      */
     void exportData(OrganizationDTO organizationDTO, HttpServletResponse response);
}
