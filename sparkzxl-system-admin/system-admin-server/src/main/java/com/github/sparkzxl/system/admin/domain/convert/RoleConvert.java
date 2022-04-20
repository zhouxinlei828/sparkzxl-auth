package com.github.sparkzxl.system.admin.domain.convert;

import com.github.sparkzxl.system.admin.infrastructure.entity.Role;
import com.github.sparkzxl.system.admin.api.model.dto.RoleDTO;
import com.github.sparkzxl.system.admin.api.model.vo.RoleVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

/**
 * <p>
 * 角色信息 转换类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Mapper
public interface RoleConvert {

    RoleConvert INSTANCE = Mappers.getMapper(RoleConvert.class);

    /**
     * roleDTO转换为Role
     *
     * @param roleDTO 角色信息DTO对象
     * @return Role
     */
    Role convertRole(RoleDTO roleDTO);

    /**
     * Role转换为RoleVO
     *
     * @param role 角色信息DTO对象
     * @return RoleVO
     */
    RoleVO convertRoleVO(Role role);

    /**
     * role列表转换为RoleVO列表
     *
     * @param roleList 角色信息列表
     * @return List<RoleVO>
     */
    List<RoleVO> convertRoleVOList(List<Role> roleList);

    /**
     * 角色信息分页对象转换为RoleVO分页对象
     *
     * @param rolePage 角色信息分页对象
     * @return Page<RoleVO>
     */
    Page<RoleVO> convertRolePageVO(Page<Role> rolePage);
}
