package com.github.sparkzxl.workflow.infrastructure.mapper;

import com.github.sparkzxl.database.base.mapper.SuperMapper;
import com.github.sparkzxl.workflow.dto.WorkflowUserInfo;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * description: 流程用户 Mapper 接口
 *
 * @author charles.zhou
 * @since 2021-01-08 16:51:21
 */
@Mapper
public interface ExtProcessUserMapper extends SuperMapper<ExtProcessUser> {

    /**
     * 根据角色id列表查询用户信息
     *
     * @param roleIds 角色id列表
     * @return List<UserInfo>
     */
    List<WorkflowUserInfo> findUserByRoleIds(@Param("roleIds") List<String> roleIds);
}
