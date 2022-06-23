package com.github.sparkzxl.workflow.infrastructure.repository;

import com.github.sparkzxl.workflow.domain.repository.IExtProcessUserRepository;
import com.github.sparkzxl.workflow.dto.WorkflowUserInfo;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessUser;
import com.github.sparkzxl.workflow.infrastructure.mapper.ExtProcessUserMapper;
import com.github.sparkzxl.workflow.infrastructure.mapper.ExtProcessUserRoleMapper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * description:
 *
 * @author zhouxinlei
 * @since 2021-07-17 19:17
 */
@Repository
@RequiredArgsConstructor
public class ExtProcessUserRepository implements IExtProcessUserRepository {

    private final ExtProcessUserRoleMapper processUserRoleMapper;
    private final ExtProcessUserMapper processUserMapper;

    @Override
    public List<String> findUserIdListByRoleIds(List<String> roleIds) {
        return processUserRoleMapper.findUserIdListByRoleIds(roleIds);
    }

    @Override
    public ExtProcessUser findUserById(String userId) {
        return processUserMapper.selectById(userId);
    }

    @Override
    public Map<String, String> findUserByIds(List<String> userIds) {
        if (CollectionUtils.isEmpty(userIds)) {
            return Maps.newHashMap();
        }
        List<ExtProcessUser> processUserList = processUserMapper.selectBatchIds(userIds);
        return processUserList.stream().collect(Collectors.toMap((x) -> String.valueOf(x.getId()),
                ExtProcessUser::getName));
    }

    @Override
    public List<WorkflowUserInfo> findUserByRoleIds(List<String> roleIds) {
        if (CollectionUtils.isEmpty(roleIds)) {
            return Lists.newArrayList();
        }
        return processUserMapper.findUserByRoleIds(roleIds);
    }
}
