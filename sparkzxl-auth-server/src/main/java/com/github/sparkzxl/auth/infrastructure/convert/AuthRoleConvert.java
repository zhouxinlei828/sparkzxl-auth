package com.github.sparkzxl.auth.infrastructure.convert;

import com.github.sparkzxl.auth.domain.model.aggregates.RoleBasicInfo;
import com.github.sparkzxl.auth.domain.model.aggregates.RoleResource;
import com.github.sparkzxl.auth.domain.model.vo.RoleResourceVO;
import com.github.sparkzxl.auth.infrastructure.entity.AuthRole;
import com.github.sparkzxl.auth.interfaces.dto.role.RoleSaveDTO;
import com.github.sparkzxl.auth.interfaces.dto.role.RoleUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * description: AuthRole对象Convert
 *
 * @author charles.zhou
 * @date 2020-06-05 21:28:06
 */
@Mapper
public interface AuthRoleConvert {

    AuthRoleConvert INSTANCE = Mappers.getMapper(AuthRoleConvert.class);

    /**
     * AuthRoleSaveDTO转化为AuthRole
     *
     * @param authRoleSaveDTO 角色保存对象
     * @return AuthRole
     */
    AuthRole convertAuthRoleDO(RoleSaveDTO authRoleSaveDTO);

    /**
     * authRoleUpdateDTO转化为AuthRole
     *
     * @param authRoleUpdateDTO 角色更新对象
     * @return AuthRole
     */
    AuthRole convertAuthRoleDO(RoleUpdateDTO authRoleUpdateDTO);

    /**
     * 角色资源领域对象转换显示层对象
     * @param roleResource 角色资源领域对象
     * @return RoleResourceVO
     */
    RoleResourceVO convertRoleResourceVO(RoleResource roleResource);

    List<RoleBasicInfo> convertRoleBasicInfo(List<AuthRole> roleList);
}
