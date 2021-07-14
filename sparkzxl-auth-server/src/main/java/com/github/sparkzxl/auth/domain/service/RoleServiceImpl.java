package com.github.sparkzxl.auth.domain.service;

import com.github.pagehelper.PageInfo;
import com.github.sparkzxl.auth.application.service.IRoleService;
import com.github.sparkzxl.auth.application.service.es.IEsRoleAttributeService;
import com.github.sparkzxl.auth.domain.repository.IAuthRoleRepository;
import com.github.sparkzxl.auth.infrastructure.constant.BizConstant;
import com.github.sparkzxl.auth.infrastructure.convert.AuthRoleConvert;
import com.github.sparkzxl.auth.infrastructure.entity.AuthRole;
import com.github.sparkzxl.auth.infrastructure.mapper.AuthRoleMapper;
import com.github.sparkzxl.auth.interfaces.dto.role.RoleQueryDTO;
import com.github.sparkzxl.auth.interfaces.dto.role.RoleSaveDTO;
import com.github.sparkzxl.auth.interfaces.dto.role.RoleUpdateDTO;
import com.github.sparkzxl.constant.EntityConstant;
import com.github.sparkzxl.database.base.service.impl.SuperCacheServiceImpl;
import com.github.sparkzxl.database.dto.PageParams;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * description: 角色 服务实现类
 *
 * @author charles.zhou
 * @date 2020-06-07 13:37:09
 */
@Service
public class RoleServiceImpl extends SuperCacheServiceImpl<AuthRoleMapper, AuthRole> implements IRoleService {

    private final IAuthRoleRepository authRoleRepository;
    private final IEsRoleAttributeService esRoleAttributeService;

    public RoleServiceImpl(IAuthRoleRepository authRoleRepository, IEsRoleAttributeService esRoleAttributeService) {
        this.authRoleRepository = authRoleRepository;
        this.esRoleAttributeService = esRoleAttributeService;
    }

    @Override
    public PageInfo<AuthRole> getPageList(PageParams<RoleQueryDTO> params) {
        PageInfo<AuthRole> rolePage = authRoleRepository.getPageList(params.getPageNum(), params.getPageSize(), params.getModel().getCode(), params.getModel().getName());
        List<AuthRole> roleList = rolePage.getList();
        if (CollectionUtils.isNotEmpty(roleList)) {
            List<String> roleIdStrList = roleList.stream().map(x -> String.valueOf(x.getId())).collect(Collectors.toList());
            Map<String, Map> searchRoleAttribute = esRoleAttributeService.searchDocsMapByIdList(BizConstant.INDEX_ROLE_ATTRIBUTE, roleIdStrList, Map.class);
            roleList.forEach(role -> {
                Map map = searchRoleAttribute.get(String.valueOf(role.getId()));
                if (MapUtils.isNotEmpty(map)) {
                    map.remove(EntityConstant.COLUMN_ID);
                    role.setAttribute(map);
                }
            });
            rolePage.setList(roleList);
        }
        return rolePage;
    }

    @Override
    public void deleteAuthRoleRelation(List<Long> ids) {
        authRoleRepository.deleteAuthRoleRelation(ids);
        if (CollectionUtils.isNotEmpty(ids)) {
            esRoleAttributeService.deleteDocByIds(BizConstant.INDEX_ROLE_ATTRIBUTE, ids.stream().map(String::valueOf).collect(Collectors.toList()));
        }
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
        boolean result = authRoleRepository.saveRole(authRole);
        Long roleId = authRole.getId();
        Map<String, Object> roleAttributeMap = authRole.getAttribute();
        if (MapUtils.isNotEmpty(roleAttributeMap)){
            roleAttributeMap.put(EntityConstant.COLUMN_ID, String.valueOf(roleId));
            esRoleAttributeService.saveDoc(BizConstant.INDEX_ROLE_ATTRIBUTE, String.valueOf(roleId), roleAttributeMap);
        }
        return result;
    }

    @Override
    public boolean updateRole(RoleUpdateDTO roleUpdateDTO) {
        AuthRole authRole = AuthRoleConvert.INSTANCE.convertAuthRole(roleUpdateDTO);
        boolean result = authRoleRepository.updateRole(authRole);
        Long roleId = authRole.getId();
        Map<String, Object> roleAttributeMap = authRole.getAttribute();
        esRoleAttributeService.deleteDocById(BizConstant.INDEX_ROLE_ATTRIBUTE, String.valueOf(roleId));
        if (MapUtils.isNotEmpty(roleAttributeMap)) {
            roleAttributeMap.put(EntityConstant.COLUMN_ID, String.valueOf(roleId));
            esRoleAttributeService.saveDoc(BizConstant.INDEX_ROLE_ATTRIBUTE, String.valueOf(roleId), roleAttributeMap);
        }
        return result;
    }

    @Override
    protected String getRegion() {
        return BizConstant.ROLE;
    }
}
