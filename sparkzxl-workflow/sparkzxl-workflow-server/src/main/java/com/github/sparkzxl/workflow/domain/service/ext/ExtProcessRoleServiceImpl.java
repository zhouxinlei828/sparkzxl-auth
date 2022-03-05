package com.github.sparkzxl.workflow.domain.service.ext;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.sparkzxl.database.base.service.impl.SuperCacheServiceImpl;
import com.github.sparkzxl.workflow.application.service.ext.IExtProcessRoleService;
import com.github.sparkzxl.workflow.domain.model.dto.role.ProcessUserRoleSaveDTO;
import com.github.sparkzxl.workflow.domain.repository.IExtProcessRoleRepository;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessRole;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessUserRole;
import com.github.sparkzxl.workflow.infrastructure.mapper.ExtProcessRoleMapper;
import com.github.sparkzxl.workflow.infrastructure.mapper.ExtProcessUserRoleMapper;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * description: 流程角色 服务实现类
 *
 * @author charles.zhou
 * @date 2021-01-08 17:08:44
 */
@Service
public class ExtProcessRoleServiceImpl extends SuperCacheServiceImpl<ExtProcessRoleMapper, ExtProcessRole> implements IExtProcessRoleService {

    private IExtProcessRoleRepository processRoleRepository;

    private ExtProcessUserRoleMapper processUserRoleMapper;

    @Autowired
    public void setProcessRoleRepository(IExtProcessRoleRepository processRoleRepository) {
        this.processRoleRepository = processRoleRepository;
    }

    @Autowired
    public void setProcessUserRoleMapper(ExtProcessUserRoleMapper processUserRoleMapper) {
        this.processUserRoleMapper = processUserRoleMapper;
    }

    @Override
    public boolean saveRoleUser(ProcessUserRoleSaveDTO processUserRole) {
        return processRoleRepository.saveRoleUser(processUserRole.getRoleId(), processUserRole.getUserIds());
    }

    @Override
    public List<Long> getRoleUserList(Long roleId) {
        List<ExtProcessUserRole> extProcessUserRoles = processUserRoleMapper.selectList(new LambdaQueryWrapper<ExtProcessUserRole>()
                .eq(ExtProcessUserRole::getRoleId, roleId));
        if (CollectionUtils.isNotEmpty(extProcessUserRoles)) {
            return extProcessUserRoles.stream().map(ExtProcessUserRole::getUserId).collect(Collectors.toList());
        }
        return Lists.newArrayList();
    }

    @Override
    protected String getRegion() {
        return "process_role";
    }
}
