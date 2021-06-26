package com.github.sparkzxl.auth.domain.repository;


import com.github.sparkzxl.auth.infrastructure.entity.CoreOrg;
import com.github.sparkzxl.auth.infrastructure.entity.CoreStation;
import com.github.sparkzxl.entity.data.RemoteData;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * description: 岗位 仓储类
 *
 * @author charles.zhou
 * @date 2020-06-07 13:32:55
 */
public interface ICoreStationRepository {

    /**
     * 根据id 查询 岗位名称
     *
     * @param ids
     * @return
     */
    Map<Serializable, Object> findStationByIds(Set<Serializable> ids);

    /**
     * 注入分页查询岗位列表
     *
     * @param pageNum  当前页
     * @param pageSize 分页大小
     * @param name     岗位名称
     * @param org      组织id
     * @return List<CoreStation>
     */
    List<CoreStation> getStationPageList(int pageNum, int pageSize, String name, RemoteData<Long, CoreOrg> org);

    /**
     * 删除岗位
     * @param ids 岗位ids
     * @return boolean
     */
    boolean deleteCoreStation(List<Long> ids);
}
