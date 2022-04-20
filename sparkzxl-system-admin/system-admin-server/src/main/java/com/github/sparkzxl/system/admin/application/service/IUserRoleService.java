package com.github.sparkzxl.system.admin.application.service;

import com.github.sparkzxl.system.admin.infrastructure.entity.UserRole;
import com.github.sparkzxl.system.admin.api.model.vo.UserRoleVO;
import com.github.sparkzxl.system.admin.api.model.dto.UserRoleDTO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 角色分配	账号角色绑定 服务类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
public interface IUserRoleService {


    /**
    * 角色分配	账号角色绑定分页条件查询
    * @param page 分页入参
    * @param userRoleDTO: 角色分配	账号角色绑定DTO分页查询对象
    * @return Page<UserRoleVO>
    */
    Page<UserRoleVO> page(Page<UserRole> page, UserRoleDTO userRoleDTO);


    /**
     * 角色分配	账号角色绑定集合条件查询
     * @param userRoleDTO: 角色分配	账号角色绑定DTO查询对象
     * @return List<UserRoleVO>
     */
    List<UserRoleVO> list(UserRoleDTO userRoleDTO);


    /**
     * 根据id查询角色分配	账号角色绑定
     * @param id id
     * @return UserRoleVO
     */
    UserRoleVO getById(Long id);

    /**
     * 新增角色分配	账号角色绑定
     * @param userRoleDTO: 角色分配	账号角色绑定新增DTO
     * @return boolean
     */
     boolean save(UserRoleDTO userRoleDTO);


    /**
     * 修改角色分配	账号角色绑定
     * @param userRoleDTO 角色分配	账号角色绑定修改DTO
     * @return boolean
     */
     boolean updateById(UserRoleDTO userRoleDTO);


    /**
     * 根据id删除角色分配	账号角色绑定
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
      * @param userRoleDTO 角色分配	账号角色绑定导出DTO
      * @param response http response
      */
     void exportData(UserRoleDTO userRoleDTO, HttpServletResponse response);
}
