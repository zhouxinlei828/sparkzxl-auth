package com.github.sparkzxl.auth.infrastructure.repository;


import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.github.sparkzxl.auth.domain.repository.ICoreOrgRepository;
import com.github.sparkzxl.auth.infrastructure.entity.CoreOrg;
import com.github.sparkzxl.auth.infrastructure.mapper.CoreOrgMapper;
import com.github.sparkzxl.core.util.MapHelper;
import com.github.sparkzxl.entity.data.SuperEntity;
import com.github.sparkzxl.entity.data.TreeEntity;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * description: 组织 仓储层实现类
 *
 * @author charles.zhou
 * @since 2020-06-07 13:32:24
 */
@Repository
public class CoreOrgRepository implements ICoreOrgRepository {

    @Resource
    private CoreOrgMapper coreOrgMapper;
    @Resource
    private SegmentIdRepository segmentRepository;

    @Override
    public boolean saveCoreOrg(CoreOrg coreOrg) {
        long id = segmentRepository.getSegmentId("core_org").longValue();
        coreOrg.setId(id);
        return coreOrgMapper.insert(coreOrg) == 1;
    }


    @Override
    public Map<Serializable, Object> findByIds(Set<Serializable> ids) {
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
            list = idList.stream().map(coreOrgMapper::selectById).filter(Objects::nonNull).collect(Collectors.toList());
        } else {
            list = coreOrgMapper.selectList(new QueryWrapper<CoreOrg>().lambda().in(CoreOrg::getId, idList).eq(CoreOrg::getStatus, true));
        }
        return list;
    }

    @Override
    public boolean updateCoreOrg(CoreOrg coreOrg) {
        LambdaUpdateWrapper<CoreOrg> updateWrapper = new LambdaUpdateWrapper<>();
        if (MapUtils.isEmpty(coreOrg.getExtendInfo())) {
            updateWrapper.set(CoreOrg::getExtendInfo, null);
        }
        updateWrapper.eq(CoreOrg::getId, coreOrg.getId());
        return coreOrgMapper.update(coreOrg, updateWrapper) == 1;
    }

    @Override
    public boolean deleteBatchCoreOrg(List<Long> ids) {
        coreOrgMapper.deleteBatchIds(ids);
        return true;
    }

    @Override
    public List<CoreOrg> getCoreOrgList(String name, Boolean status) {
        LambdaQueryWrapper<CoreOrg> orgQueryWrapper = new LambdaQueryWrapper<>();
        orgQueryWrapper.likeRight(StringUtils.isNotEmpty(name), TreeEntity::getLabel, name)
                .eq(ObjectUtils.isNotEmpty(status), CoreOrg::getStatus, status);
        return coreOrgMapper.selectList(orgQueryWrapper);
    }
}
