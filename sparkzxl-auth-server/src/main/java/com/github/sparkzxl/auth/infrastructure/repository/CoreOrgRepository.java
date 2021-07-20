package com.github.sparkzxl.auth.infrastructure.repository;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.sparkzxl.auth.domain.repository.ICoreOrgRepository;
import com.github.sparkzxl.auth.infrastructure.entity.CoreOrg;
import com.github.sparkzxl.auth.infrastructure.mapper.CoreOrgMapper;
import com.github.sparkzxl.entity.data.TreeEntity;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    private final SegmentIdRepository segmentRepository;

    @Override
    public boolean saveCoreOrg(CoreOrg coreOrg) {
        long id = segmentRepository.getSegmentId("core_org").longValue();
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
        orgQueryWrapper.likeRight(StringUtils.isNotEmpty(name), TreeEntity::getLabel, name)
                .eq(ObjectUtils.isNotEmpty(status), CoreOrg::getStatus, status);
        return coreOrgMapper.selectList(orgQueryWrapper);
    }
}
