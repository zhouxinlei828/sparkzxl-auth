package com.github.sparkzxl.auth.domain.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.sparkzxl.auth.application.service.IUserService;
import com.github.sparkzxl.auth.application.service.ICoreOrgService;
import com.github.sparkzxl.auth.domain.repository.IIdSegmentRepository;
import com.github.sparkzxl.auth.infrastructure.constant.CacheConstant;
import com.github.sparkzxl.auth.infrastructure.convert.CoreOrgConvert;
import com.github.sparkzxl.auth.infrastructure.entity.CoreOrg;
import com.github.sparkzxl.auth.infrastructure.mapper.CoreOrgMapper;
import com.github.sparkzxl.auth.interfaces.dto.org.OrgSaveDTO;
import com.github.sparkzxl.auth.interfaces.dto.org.OrgUpdateDTO;
import com.github.sparkzxl.database.base.service.impl.SuperCacheServiceImpl;
import com.github.sparkzxl.database.entity.TreeEntity;
import com.github.sparkzxl.database.utils.TreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * description: 组织 服务实现类
 *
 * @author charles.zhou
 * @date 2020-06-07 13:37:19
 */
@Service
public class CoreOrgServiceImpl extends SuperCacheServiceImpl<CoreOrgMapper, CoreOrg> implements ICoreOrgService {

    @Autowired
    private IUserService authUserService;

    @Autowired
    private IIdSegmentRepository segmentRepository;

    @Override
    public List<CoreOrg> getCoreOrgTree(String name, Boolean status) {
        LambdaQueryWrapper<CoreOrg> orgQueryWrapper = new LambdaQueryWrapper<>();
        Optional.ofNullable(name).ifPresent(value -> orgQueryWrapper.likeRight(TreeEntity::getLabel, value));
        Optional.ofNullable(status).ifPresent(value -> orgQueryWrapper.eq(CoreOrg::getStatus, value));
        List<CoreOrg> coreOrgList = list(orgQueryWrapper);
        return TreeUtil.buildTree(coreOrgList);
    }

    @Override
    public CoreOrg getCoreOrgByName(String name) {
        LambdaQueryWrapper<CoreOrg> orgQueryWrapper = new LambdaQueryWrapper<>();
        orgQueryWrapper.eq(TreeEntity::getLabel, name);
        orgQueryWrapper.eq(CoreOrg::getStatus, true).last("limit 1");;
        return getOne(orgQueryWrapper);
    }

    @Override
    public boolean saveCoreOrg(OrgSaveDTO orgSaveDTO) {
        CoreOrg coreOrg = CoreOrgConvert.INSTANCE.convertCoreOrg(orgSaveDTO);
        long id = segmentRepository.getIdSegment("core_org").longValue();
        coreOrg.setId(id);
        return save(coreOrg);
    }

    @Override
    public boolean updateCoreOrg(OrgUpdateDTO orgUpdateDTO) {
        CoreOrg coreOrg = CoreOrgConvert.INSTANCE.convertCoreOrg(orgUpdateDTO);
        return updateById(coreOrg);
    }

    @Override
    public boolean deleteBatchCoreOrg(List<Long> ids) {
        authUserService.deleteOrgIds(ids);
        return removeByIds(ids);
    }

    @Override
    protected String getRegion() {
        return CacheConstant.ORG;
    }
}
