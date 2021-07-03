package com.github.sparkzxl.auth.infrastructure.mapper;

import com.github.sparkzxl.auth.infrastructure.entity.OauthClientDetails;
import com.github.sparkzxl.database.base.mapper.SuperMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * description: 应用客户端 Mapper 接口
 *
 * @author charles.zhou
 * @date   2021-02-02 11:34:50
 */
@Repository
public interface OauthClientDetailsMapper extends SuperMapper<OauthClientDetails> {

}
