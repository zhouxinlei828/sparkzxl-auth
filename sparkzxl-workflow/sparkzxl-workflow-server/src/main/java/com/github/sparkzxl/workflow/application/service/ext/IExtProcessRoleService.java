package com.github.sparkzxl.workflow.application.service.ext;

import com.github.sparkzxl.database.base.service.SuperCacheService;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessRole;
import com.github.sparkzxl.workflow.interfaces.dto.role.ProcessUserRoleSaveDTO;

/**
 * description: 流程角色 服务类
 *
 * @author charles.zhou
 * @date 2021-01-08 17:05:32
 */
public interface IExtProcessRoleService extends SuperCacheService<ExtProcessRole> {

    /**
     * 保存流程角色用户列表
     *
     * @param processUserRole 流程角色用户保存DTO
     * @return boolean
     */
    boolean saveRoleUser(ProcessUserRoleSaveDTO processUserRole);
}
