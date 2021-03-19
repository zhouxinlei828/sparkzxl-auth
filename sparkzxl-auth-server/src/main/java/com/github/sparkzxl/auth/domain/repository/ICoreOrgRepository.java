package com.github.sparkzxl.auth.domain.repository;



import java.io.Serializable;
import java.util.Map;
import java.util.Set;

/**
 * description: 组织 仓储类
 *
 * @author charles.zhou
 * @date 2020-06-07 13:32:24
 */
public interface ICoreOrgRepository {


    /**
     * 根据 id 查询组织，并转换成Map结构
     *
     * @param ids
     * @return
     */
    Map<Serializable, Object> findOrgByIds(Set<Serializable> ids);
}
