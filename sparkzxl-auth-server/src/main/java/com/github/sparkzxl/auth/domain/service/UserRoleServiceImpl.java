package com.github.sparkzxl.auth.domain.service;

import com.github.sparkzxl.auth.application.service.IUserRoleService;
import com.github.sparkzxl.auth.domain.model.aggregates.RoleResource;
import com.github.sparkzxl.auth.domain.model.vo.RoleResourceVO;
import com.github.sparkzxl.auth.domain.repository.IRoleAuthorityRepository;
import com.github.sparkzxl.auth.domain.repository.IUserRoleRepository;
import com.github.sparkzxl.auth.infrastructure.convert.AuthRoleConvert;
import com.github.sparkzxl.auth.infrastructure.entity.AuthUser;
import com.github.sparkzxl.auth.infrastructure.entity.UserRole;
import com.github.sparkzxl.auth.infrastructure.mapper.UserRoleMapper;
import com.github.sparkzxl.auth.interfaces.dto.role.RoleUserDTO;
import com.github.sparkzxl.auth.interfaces.dto.role.RoleUserDeleteDTO;
import com.github.sparkzxl.auth.interfaces.dto.role.RoleUserSaveDTO;
import com.github.sparkzxl.database.base.service.impl.SuperServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * description: 账号角色绑定 服务实现类
 *
 * @author charles.zhou
 * @date 2020-07-19 21:01:40
 */
@Service
public class UserRoleServiceImpl extends SuperServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

    @Autowired
    private IUserRoleRepository userRoleRepository;
    @Autowired
    private IRoleAuthorityRepository roleAuthorityRepository;

    @Override
    public boolean saveAuthRoleUser(RoleUserSaveDTO roleUserSaveDTO) {
        return userRoleRepository.saveAuthRoleUser(roleUserSaveDTO.getRoleId(), roleUserSaveDTO.getUserIds());
    }

    @Override
    public boolean deleteAuthRoleUser(RoleUserDeleteDTO roleUserDeleteDTO) {
        return userRoleRepository.deleteAuthRoleUser(roleUserDeleteDTO.getId(), roleUserDeleteDTO.getUserIds());
    }

    @Override
    public RoleUserDTO getRoleUserList(Long roleId) {
        RoleUserDTO roleUserDTO = new RoleUserDTO();
        roleUserDTO.setId(roleId);
        List<AuthUser> authUsers = userRoleRepository.getRoleUserList(roleId);
        Optional.ofNullable(authUsers).ifPresent(x -> roleUserDTO.setAuthUsers(authUsers));
        return roleUserDTO;
    }

    @Override
    public RoleResourceVO getRoleResource(Long roleId) {
        RoleResource roleResource = roleAuthorityRepository.getRoleResource(roleId);
        return AuthRoleConvert.INSTANCE.convertRoleResourceVO(roleResource);
    }
}
