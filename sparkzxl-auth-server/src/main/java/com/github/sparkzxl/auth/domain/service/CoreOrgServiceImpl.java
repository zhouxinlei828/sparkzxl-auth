package com.github.sparkzxl.auth.domain.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.sparkzxl.auth.application.service.ICoreOrgService;
import com.github.sparkzxl.auth.application.service.IUserService;
import com.github.sparkzxl.auth.domain.repository.ICoreOrgRepository;
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
    private ICoreOrgRepository coreOrgRepository;

    @Override
    public List<CoreOrg> getCoreOrgTree(String name, Boolean status) {
        List<CoreOrg> coreOrgList = coreOrgRepository.getCoreOrgList(name,status);
        return TreeUtil.buildTree(coreOrgList);
    }

    @Override
    public CoreOrg getCoreOrgByName(String name) {
        LambdaQueryWrapper<CoreOrg> orgQueryWrapper = new LambdaQueryWrapper<>();
        orgQueryWrapper.eq(TreeEntity::getLabel, name);
        orgQueryWrapper.eq(CoreOrg::getStatus, true).last("limit 1");
        return getOne(orgQueryWrapper);
    }

    @Override
    public boolean saveCoreOrg(OrgSaveDTO orgSaveDTO) {
        CoreOrg coreOrg = CoreOrgConvert.INSTANCE.convertCoreOrg(orgSaveDTO);
        return coreOrgRepository.saveCoreOrg(coreOrg);
    }

    @Override
    public boolean updateCoreOrg(OrgUpdateDTO orgUpdateDTO) {
        CoreOrg coreOrg = CoreOrgConvert.INSTANCE.convertCoreOrg(orgUpdateDTO);
        return coreOrgRepository.updateCoreOrg(coreOrg);
    }

    @Override
    public boolean deleteBatchCoreOrg(List<Long> ids) {
        coreOrgRepository.deleteBatchCoreOrg(ids);
        authUserService.deleteOrgIds(ids);
        return true;
    }

    @Override
    protected String getRegion() {
        return CacheConstant.ORG;
    }
}
