package com.github.sparkzxl.auth.infrastructure.repository;


import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.sparkzxl.auth.domain.repository.ICoreOrgRepository;
import com.github.sparkzxl.auth.infrastructure.entity.CoreOrg;
import com.github.sparkzxl.auth.infrastructure.mapper.CoreOrgMapper;
import com.github.sparkzxl.core.utils.MapHelper;
import com.github.sparkzxl.database.entity.TreeEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * description: 组织 仓储层实现类
 *
 * @author charles.zhou
 * @date 2020-06-07 13:32:24
 */
@AllArgsConstructor
@Repository
public class CoreOrgRepository implements ICoreOrgRepository {

    private final CoreOrgMapper coreOrgMapper;
    private final IdSegmentRepository segmentRepository;

    @Override
    public Map<Serializable, Object> findOrgByIds(Set<Serializable> ids) {
        List<CoreOrg> orgList = getOrgs(ids);
        return MapHelper.uniqueIndex(orgList, CoreOrg::getId, (org) -> org);
    }

    private List<CoreOrg> getOrgs(Set<Serializable> ids) {
        if (ids.isEmpty()) {
            return Collections.emptyList();
        }
        List<Long> idList = ids.stream().mapToLong(Convert::toLong).boxed().collect(Collectors.toList());
        List<CoreOrg> list;
        int size = 1000;
        if (idList.size() <= size) {
            list = idList.stream().map(this.coreOrgMapper::selectById).filter(Objects::nonNull).collect(Collectors.toList());
        } else {
            list = this.coreOrgMapper.selectList(new QueryWrapper<CoreOrg>().lambda().in(CoreOrg::getId, idList).eq(CoreOrg::getStatus, true));
        }
        return list;
    }

    @Override
    public boolean saveCoreOrg(CoreOrg coreOrg) {
        long id = segmentRepository.getIdSegment("core_org").longValue();
        coreOrg.setId(id);
        return coreOrgMapper.insert(coreOrg) == 1;
    }

    @Override
    public boolean updateCoreOrg(CoreOrg coreOrg) {
        return coreOrgMapper.updateById(coreOrg) == 1;
    }

    @Override
    public boolean deleteBatchCoreOrg(List<Long> ids) {
        coreOrgMapper.deleteBatchIds(ids);
        return true;
    }

    @Override
    public List<CoreOrg> getCoreOrgList(String name, Boolean status) {
        LambdaQueryWrapper<CoreOrg> orgQueryWrapper = new LambdaQueryWrapper<>();
        Optional.ofNullable(name).ifPresent(value -> orgQueryWrapper.likeRight(TreeEntity::getLabel, value));
        Optional.ofNullable(status).ifPresent(value -> orgQueryWrapper.eq(CoreOrg::getStatus, value));
        return coreOrgMapper.selectList(orgQueryWrapper);
    }
}
