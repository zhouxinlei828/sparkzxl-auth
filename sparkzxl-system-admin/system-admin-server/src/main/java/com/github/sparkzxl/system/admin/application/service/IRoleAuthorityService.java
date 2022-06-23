package com.github.sparkzxl.system.admin.application.service;

import com.github.sparkzxl.system.admin.infrastructure.entity.RoleAuthority;
import com.github.sparkzxl.system.admin.api.model.vo.RoleAuthorityVO;
import com.github.sparkzxl.system.admin.api.model.dto.RoleAuthorityDTO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 角色的资源 服务类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
public interface IRoleAuthorityService {


    /**
    * 角色的资源分页条件查询
    * @param page 分页入参
    * @param roleAuthorityDTO: 角色的资源DTO分页查询对象
    * @return Page<RoleAuthorityVO>
    */
    Page<RoleAuthorityVO> page(Page<RoleAuthority> page, RoleAuthorityDTO roleAuthorityDTO);


    /**
     * 角色的资源集合条件查询
     * @param roleAuthorityDTO: 角色的资源DTO查询对象
     * @return List<RoleAuthorityVO>
     */
    List<RoleAuthorityVO> list(RoleAuthorityDTO roleAuthorityDTO);


    /**
     * 根据id查询角色的资源
     * @param id id
     * @return RoleAuthorityVO
     */
    RoleAuthorityVO getById(Long id);

    /**
     * 新增角色的资源
     * @param roleAuthorityDTO: 角色的资源新增DTO
     * @return boolean
     */
     boolean save(RoleAuthorityDTO roleAuthorityDTO);


    /**
     * 修改角色的资源
     * @param roleAuthorityDTO 角色的资源修改DTO
     * @return boolean
     */
     boolean updateById(RoleAuthorityDTO roleAuthorityDTO);


    /**
     * 根据id删除角色的资源
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
      * @param roleAuthorityDTO 角色的资源导出DTO
      * @param response http response
      */
     void exportData(RoleAuthorityDTO roleAuthorityDTO, HttpServletResponse response);
}
