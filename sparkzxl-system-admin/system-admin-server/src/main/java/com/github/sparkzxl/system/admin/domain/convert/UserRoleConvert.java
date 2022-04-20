package com.github.sparkzxl.system.admin.domain.convert;

import com.github.sparkzxl.system.admin.infrastructure.entity.UserRole;
import com.github.sparkzxl.system.admin.api.model.dto.UserRoleDTO;
import com.github.sparkzxl.system.admin.api.model.vo.UserRoleVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

/**
 * <p>
 * 角色分配	账号角色绑定 转换类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Mapper
public interface UserRoleConvert {

    UserRoleConvert INSTANCE = Mappers.getMapper(UserRoleConvert.class);

    /**
     * userRoleDTO转换为UserRole
     *
     * @param userRoleDTO 角色分配	账号角色绑定DTO对象
     * @return UserRole
     */
    UserRole convertUserRole(UserRoleDTO userRoleDTO);

    /**
     * UserRole转换为UserRoleVO
     *
     * @param userRole 角色分配	账号角色绑定DTO对象
     * @return UserRoleVO
     */
    UserRoleVO convertUserRoleVO(UserRole userRole);

    /**
     * userRole列表转换为UserRoleVO列表
     *
     * @param userRoleList 角色分配	账号角色绑定列表
     * @return List<UserRoleVO>
     */
    List<UserRoleVO> convertUserRoleVOList(List<UserRole> userRoleList);

    /**
     * 角色分配	账号角色绑定分页对象转换为UserRoleVO分页对象
     *
     * @param userRolePage 角色分配	账号角色绑定分页对象
     * @return Page<UserRoleVO>
     */
    Page<UserRoleVO> convertUserRolePageVO(Page<UserRole> userRolePage);
}
