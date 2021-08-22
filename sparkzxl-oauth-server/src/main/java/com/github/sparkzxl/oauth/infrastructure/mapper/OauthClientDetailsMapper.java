package com.github.sparkzxl.oauth.infrastructure.mapper;

import com.github.sparkzxl.database.base.mapper.SuperMapper;
import com.github.sparkzxl.oauth.infrastructure.entity.OauthClientDetails;
import org.springframework.stereotype.Repository;

/**
 * description: 应用客户端 Mapper 接口
 *
 * @author charles.zhou
 * @date 2021-02-02 11:34:50
 */
@Repository
public interface OauthClientDetailsMapper extends SuperMapper<OauthClientDetails> {

}
