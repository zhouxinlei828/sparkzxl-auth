package com.github.sparkzxl.auth.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.sparkzxl.auth.infrastructure.entity.AuthUserAttribute;
import org.springframework.stereotype.Repository;

/**
 * description: 用户属性 Mapper 接口
 *
 * @author charles.zhou
 * @date 2021-03-24 15:51:14
 */
@Repository
public interface AuthUserAttributeMapper extends BaseMapper<AuthUserAttribute> {

}
