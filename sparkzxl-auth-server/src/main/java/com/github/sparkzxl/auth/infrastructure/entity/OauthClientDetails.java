package com.github.sparkzxl.auth.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.sparkzxl.core.jackson.JsonUtil;
import com.github.sparkzxl.core.utils.ListUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * description: 应用客户端管理
 *
 * @author charles.zhou
 * @date   2021-02-02 11:34:07
 */
@EqualsAndHashCode(callSuper = false)
@TableName("oauth_client_details")
@ApiModel(value = "OauthClientDetails对象", description = "应用客户端管理")
public class OauthClientDetails implements Serializable, ClientDetails {

    private static final long serialVersionUID = 8072874744587930460L;

    @ApiModelProperty("客户端id")
    @TableId(value = "client_id", type = IdType.INPUT)
    private String clientId;

    @ApiModelProperty("资源保护id列表")
    @TableField("resource_ids")
    private String resourceIds;

    @ApiModelProperty("客户端密钥")
    @TableField("client_secret")
    private String clientSecret;

    @ApiModelProperty("授权范围")
    @TableField("scope")
    private String scope;

    @ApiModelProperty("授权认证类型")
    @TableField("authorized_grant_types")
    private String authorizedGrantTypes;

    @ApiModelProperty("授权回调地址")
    @TableField("web_server_redirect_uri")
    private String webServerRedirectUri;

    @ApiModelProperty("权限列表")
    @TableField("authorities")
    private String authorities;

    @ApiModelProperty("token有效期")
    @TableField("access_token_validity")
    private Integer accessTokenValidity;

    @ApiModelProperty("刷新token有效期")
    @TableField("refresh_token_validity")
    private Integer refreshTokenValidity;

    @ApiModelProperty("自定义信息")
    @TableField("additional_information")
    private String additionalInformation;

    @ApiModelProperty("自动授权")
    @TableField("autoapprove")
    private String autoApprove;

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
        this.authorizedGrantTypes = authorizedGrantTypes;
    }

    public void setWebServerRedirectUri(String webServerRedirectUri) {
        this.webServerRedirectUri = webServerRedirectUri;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public void setAccessTokenValidity(Integer accessTokenValidity) {
        this.accessTokenValidity = accessTokenValidity;
    }

    public void setRefreshTokenValidity(Integer refreshTokenValidity) {
        this.refreshTokenValidity = refreshTokenValidity;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public void setAutoApprove(String autoApprove) {
        this.autoApprove = autoApprove;
    }

    @Override
    public boolean isSecretRequired() {
        return false;
    }

    @Override
    public boolean isScoped() {
        return false;
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return Sets.newHashSet(ListUtils.stringToList(webServerRedirectUri));
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return accessTokenValidity;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return refreshTokenValidity;
    }

    @Override
    public boolean isAutoApprove(String s) {
        return Boolean.parseBoolean(autoApprove);
    }

    @Override
    public String getClientId() {
        return clientId;
    }

    @Override
    public Set<String> getResourceIds() {
        return Sets.newHashSet(ListUtils.stringToList(resourceIds));
    }

    @Override
    public String getClientSecret() {
        return clientSecret;
    }

    @Override
    public Set<String> getScope() {
        return Sets.newHashSet(ListUtils.stringToList(scope));
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return Sets.newHashSet(ListUtils.stringToList(authorizedGrantTypes));
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorityList = Lists.newArrayList();
        List<String> authorityList = ListUtils.stringToList(authorities);
        if (CollectionUtils.isNotEmpty(authorityList)) {
            authorityList.forEach(x -> grantedAuthorityList.add(new SimpleGrantedAuthority(x)));
        }
        return grantedAuthorityList;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        Map<String, Object> map = Maps.newHashMap();
        if (StringUtils.isNotEmpty(additionalInformation)) {
            map = JsonUtil.toMap(additionalInformation);
        }
        return map;
    }

    public String getWebServerRedirectUri() {
        return webServerRedirectUri;
    }

    public Integer getAccessTokenValidity() {
        return accessTokenValidity;
    }

    public Integer getRefreshTokenValidity() {
        return refreshTokenValidity;
    }

    public String getAutoApprove() {
        return autoApprove;
    }
}
