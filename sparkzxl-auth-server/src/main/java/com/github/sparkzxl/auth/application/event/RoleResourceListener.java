package com.github.sparkzxl.auth.application.event;

import cn.hutool.json.JSONUtil;
import com.github.sparkzxl.auth.domain.model.aggregates.ResourceSource;
import com.github.sparkzxl.auth.infrastructure.constant.CacheConstant;
import com.github.sparkzxl.auth.infrastructure.entity.RoleResource;
import com.github.sparkzxl.auth.infrastructure.mapper.AuthUserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * description: 权限资源变更事件监听，用于调整具体的业务
 *
 * @author charles.zhou
 * @date   2021-03-08 14:19:51
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class RoleResourceListener {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private AuthUserMapper authUserMapper;

    @Async
    @EventListener({RoleResourceEvent.class})
    public void operationRoleResourceList(RoleResourceEvent event) {
        ResourceSource source = (ResourceSource) event.getSource();
        log.info("权限资源变更事件监听源：{}", JSONUtil.toJsonPrettyStr(source));
        switch (source.getOperation()) {
            case SAVE:
                List<RoleResource> roleResources = authUserMapper.getRoleResourceList();
                Map<String, Object> roleResourceMap = roleResources.stream().collect(Collectors.toMap(RoleResource::getPath, RoleResource::getRoleCode));
                redisTemplate.opsForHash().putAll(CacheConstant.RESOURCE_ROLES_MAP, roleResourceMap);
                break;
            case DELETE:
                redisTemplate.opsForHash().delete(CacheConstant.RESOURCE_ROLES_MAP, source.getOldVal());
                break;
            case UPDATE:
                redisTemplate.opsForHash().delete(CacheConstant.RESOURCE_ROLES_MAP, source.getOldVal());
                RoleResource roleResource = authUserMapper.getRoleResource(source.getNewVal());
                redisTemplate.opsForHash().put(CacheConstant.RESOURCE_ROLES_MAP, roleResource.getPath(), roleResource.getRoleCode());
                break;
            default:
                break;
        }
    }

}
