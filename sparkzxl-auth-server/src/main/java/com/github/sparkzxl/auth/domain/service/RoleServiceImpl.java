package com.github.sparkzxl.auth.domain.service;

import com.github.pagehelper.PageInfo;
import com.github.sparkzxl.auth.application.service.IRoleService;
import com.github.sparkzxl.auth.domain.repository.IAuthRoleRepository;
import com.github.sparkzxl.auth.infrastructure.convert.AuthRoleConvert;
import com.github.sparkzxl.auth.infrastructure.entity.AuthRole;
import com.github.sparkzxl.auth.infrastructure.mapper.AuthRoleMapper;
import com.github.sparkzxl.auth.interfaces.dto.role.RoleQueryDTO;
import com.github.sparkzxl.auth.interfaces.dto.role.RoleSaveDTO;
import com.github.sparkzxl.auth.interfaces.dto.role.RoleUpdateDTO;
import com.github.sparkzxl.database.base.service.impl.SuperServiceImpl;
import com.github.sparkzxl.database.dto.PageParams;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description: 角色 服务实现类
 *
 * @author charles.zhou
 * @date 2020-06-07 13:37:09
 */
@Service
public class RoleServiceImpl extends SuperServiceImpl<AuthRoleMapper, AuthRole> implements IRoleService {

    private final IAuthRoleRepository authRoleRepository;

    public RoleServiceImpl(IAuthRoleRepository authRoleRepository) {
        this.authRoleRepository = authRoleRepository;
    }

    @Override
    public PageInfo<AuthRole> getPageList(PageParams<RoleQueryDTO> params) {
        return authRoleRepository.getPageList(params.getPageNum(), params.getPageSize(), params.getModel().getCode(), params.getModel().getName());
    }

    @Override
    public void deleteAuthRoleRelation(List<Long> ids) {
        authRoleRepository.deleteAuthRoleRelation(ids);
    }

    @Override
    public boolean updateAuthRoleStatus(Long roleId, Boolean status) {
        AuthRole authRole = new AuthRole();
        authRole.setId(roleId);
        authRole.setStatus(status);
        return updateById(authRole);
    }

    @Override
    public boolean saveRole(RoleSaveDTO roleSaveDTO) {
        AuthRole authRole = AuthRoleConvert.INSTANCE.convertAuthRole(roleSaveDTO);
        return authRoleRepository.saveRole(authRole);
    }

    @Override
    public boolean updateRole(RoleUpdateDTO roleUpdateDTO) {
        AuthRole authRole = AuthRoleConvert.INSTANCE.convertAuthRole(roleUpdateDTO);
        return authRoleRepository.updateRole(authRole);
    }

}
