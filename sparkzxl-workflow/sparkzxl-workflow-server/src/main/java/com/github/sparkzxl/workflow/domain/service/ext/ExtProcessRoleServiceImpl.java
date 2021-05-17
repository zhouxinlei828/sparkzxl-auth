package com.github.sparkzxl.workflow.domain.service.ext;

import com.github.sparkzxl.database.base.service.impl.SuperCacheServiceImpl;
import com.github.sparkzxl.workflow.application.service.ext.IExtProcessRoleService;
import com.github.sparkzxl.workflow.domain.repository.IExtProcessRoleRepository;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessRole;
import com.github.sparkzxl.workflow.infrastructure.mapper.ExtProcessRoleMapper;
import com.github.sparkzxl.workflow.interfaces.dto.role.ProcessUserRoleSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * description: 流程角色 服务实现类
 *
 * @author charles.zhou
 * @date 2021-01-08 17:08:44
 */
@Service
public class ExtProcessRoleServiceImpl extends SuperCacheServiceImpl<ExtProcessRoleMapper, ExtProcessRole> implements IExtProcessRoleService {

    private IExtProcessRoleRepository processRoleRepository;

    @Autowired
    public void setProcessRoleRepository(IExtProcessRoleRepository processRoleRepository) {
        this.processRoleRepository = processRoleRepository;
    }

    @Override
    public boolean saveRoleUser(ProcessUserRoleSaveDTO processUserRole) {
        return processRoleRepository.saveRoleUser(processUserRole.getRoleId(),processUserRole.getUserIdList());
    }

    @Override
    protected String getRegion() {
        return "process_role";
    }
}
