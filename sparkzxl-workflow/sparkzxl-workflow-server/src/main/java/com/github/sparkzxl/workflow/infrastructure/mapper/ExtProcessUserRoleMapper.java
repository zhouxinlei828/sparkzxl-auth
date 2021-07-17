package com.github.sparkzxl.workflow.infrastructure.mapper;

import com.github.sparkzxl.database.base.mapper.SuperMapper;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessUserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * description: 流程用户角色关系Mapper 接口
 *
 * @author charles.zhou
 * @date 2021-01-08 16:52:07
 */
@Repository
public interface ExtProcessUserRoleMapper extends SuperMapper<ExtProcessUserRole> {

    /**
     * 根据角色id列表查询用户id列表
     *
     * @param roleIds 角色id
     * @return List<String>
     */
    List<String> findUserIdListByRoleIds(@Param("roleIds") List<String> roleIds);
}
