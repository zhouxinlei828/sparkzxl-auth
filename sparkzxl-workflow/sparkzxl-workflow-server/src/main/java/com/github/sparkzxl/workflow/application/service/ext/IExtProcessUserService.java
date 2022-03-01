package com.github.sparkzxl.workflow.application.service.ext;

import com.github.sparkzxl.database.base.service.SuperCacheService;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessUser;
import com.github.sparkzxl.workflow.domain.model.dto.user.ProcessUserQueryDTO;

import java.util.List;

/**
 * description: 流程用户信息 服务类
 *
 * @author charles.zhou
 * @date 2021-01-08 16:53:50
 */
public interface IExtProcessUserService extends SuperCacheService<ExtProcessUser> {

    /**
     * 流程用户列表查询
     *
     * @param userQueryDTO 流程用户查询DTO
     * @return List<ExtProcessUser>
     */
    List<ExtProcessUser> userList(ProcessUserQueryDTO userQueryDTO);
}
