package com.github.sparkzxl.auth.domain.repository;


import com.github.sparkzxl.auth.infrastructure.entity.AuthUserAttribute;

import java.util.List;
import java.util.Map;

/**
 * description: 用户属性 仓储类
 *
 * @author charles.zhou
 * @date 2020-06-07 13:32:24
 */
public interface IUserAttributeRepository {


    /**
     * 根据 id 查询组织，并转换成Map结构
     *
     * @param userIdList 用户id列表
     * @return Map<Long, List<AuthUserAttribute>>
     */
    Map<Long, List<AuthUserAttribute>> findUserAttributeMapList(List<Long> userIdList);
}
