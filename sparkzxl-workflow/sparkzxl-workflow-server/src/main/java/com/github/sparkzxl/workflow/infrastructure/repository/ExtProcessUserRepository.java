package com.github.sparkzxl.workflow.infrastructure.repository;

import com.github.sparkzxl.workflow.domain.repository.IExtProcessUserRepository;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessUser;
import com.github.sparkzxl.workflow.infrastructure.mapper.ExtProcessUserMapper;
import com.github.sparkzxl.workflow.infrastructure.mapper.ExtProcessUserRoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * description:
 *
 * @author zhouxinlei
 * @date 2021-07-17 19:17
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
}
