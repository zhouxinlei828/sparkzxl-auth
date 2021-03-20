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


    /**
     * 获取客户端分页信息
     *
     * @param realmCode 领域池code
     * @param clientId   客户端id
     * @return List<OauthClientDetails>
     */
    @Select("<script> " +
            "SELECT ocd.*," +
            "tc.id, " +
            "tc.realm_code realmCode, " +
            "tc.original_client_secret originalClientSecret," +
            "ti.name tenantName " +
            "FROM oauth_client_details ocd " +
            "INNER JOIN tenant_client tc ON ocd.client_id = tc.client_id " +
            "INNER JOIN realm_pool ti ON ti.code = tc.realm_code " +
            "<where>" +
            " <if test=\"realmCode != null and realmCode != ''\">" +
            "    and tc.realm_code = #{realmCode}" +
            " </if>" +
            " <if test=\"clientId != null and clientId != ''\">" +
            "    and ocd.client_id = #{clientId}" +
            " </if>" +
            "</where>" +
            "</script>")
    List<OauthClientDetails> listPage(@Param("realmCode") String realmCode, @Param("clientId") String clientId);

}
