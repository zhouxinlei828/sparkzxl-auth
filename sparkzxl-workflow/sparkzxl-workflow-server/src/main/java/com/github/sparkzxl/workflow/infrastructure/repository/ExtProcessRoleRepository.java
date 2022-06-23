package com.github.sparkzxl.workflow.infrastructure.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.sparkzxl.workflow.domain.repository.IExtProcessRoleRepository;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessUserRole;
import com.github.sparkzxl.workflow.infrastructure.mapper.ExtProcessUserRoleMapper;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * description: 流程角色 仓储层实现类
 *
 * @author charles.zhou
 * @since 2021-05-17 10:55:21
 */
@Repository
public class ExtProcessRoleRepository implements IExtProcessRoleRepository {

    private ExtProcessUserRoleMapper processUserRoleMapper;

    @Autowired
    public void setProcessUserRoleMapper(ExtProcessUserRoleMapper processUserRoleMapper) {
        this.processUserRoleMapper = processUserRoleMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveRoleUser(Long roleId, List<Long> userIdList) {
        processUserRoleMapper.delete(new LambdaQueryWrapper<ExtProcessUserRole>().eq(ExtProcessUserRole::getRoleId, roleId));
        if (CollectionUtils.isNotEmpty(userIdList)) {
            List<ExtProcessUserRole> extProcessUserRoleList = Lists.newArrayList();
            userIdList.forEach(userId -> {
                ExtProcessUserRole extProcessUserRole = new ExtProcessUserRole();
                extProcessUserRole.setRoleId(roleId);
                extProcessUserRole.setUserId(userId);
                extProcessUserRoleList.add(extProcessUserRole);
            });
            processUserRoleMapper.insertBatchSomeColumn(extProcessUserRoleList);
        }
        return true;
    }
}
