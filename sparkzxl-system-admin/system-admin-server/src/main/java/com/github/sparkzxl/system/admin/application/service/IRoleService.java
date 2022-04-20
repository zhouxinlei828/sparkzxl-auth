package com.github.sparkzxl.system.admin.application.service;

import com.github.sparkzxl.system.admin.infrastructure.entity.Role;
import com.github.sparkzxl.system.admin.api.model.vo.RoleVO;
import com.github.sparkzxl.system.admin.api.model.dto.RoleDTO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 角色信息 服务类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
public interface IRoleService {


    /**
    * 角色信息分页条件查询
    * @param page 分页入参
    * @param roleDTO: 角色信息DTO分页查询对象
    * @return Page<RoleVO>
    */
    Page<RoleVO> page(Page<Role> page, RoleDTO roleDTO);


    /**
     * 角色信息集合条件查询
     * @param roleDTO: 角色信息DTO查询对象
     * @return List<RoleVO>
     */
    List<RoleVO> list(RoleDTO roleDTO);


    /**
     * 根据id查询角色信息
     * @param id id
     * @return RoleVO
     */
    RoleVO getById(Long id);

    /**
     * 新增角色信息
     * @param roleDTO: 角色信息新增DTO
     * @return boolean
     */
     boolean save(RoleDTO roleDTO);


    /**
     * 修改角色信息
     * @param roleDTO 角色信息修改DTO
     * @return boolean
     */
     boolean updateById(RoleDTO roleDTO);


    /**
     * 根据id删除角色信息
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
      * @param roleDTO 角色信息导出DTO
      * @param response http response
      */
     void exportData(RoleDTO roleDTO, HttpServletResponse response);
}
