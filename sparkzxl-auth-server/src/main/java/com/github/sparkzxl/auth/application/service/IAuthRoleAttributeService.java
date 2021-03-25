package com.github.sparkzxl.auth.application.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.sparkzxl.auth.infrastructure.entity.AuthRoleAttribute;

import java.util.List;
import java.util.Map;

/**
 * description: 角色属性 服务类
 *
 * @author charles.zhou
 * @date 2021-03-24 15:51:59
 */
public interface IAuthRoleAttributeService extends IService<AuthRoleAttribute> {

    /**
     * 获取角色属性信息
     *
     * @param roleIdList 角色id列表
     * @return Map<Long, List<AuthRoleAttribute>>
     */
    Map<Long, List<AuthRoleAttribute>> getRoleAttributeList(List<Long> roleIdList);

}
