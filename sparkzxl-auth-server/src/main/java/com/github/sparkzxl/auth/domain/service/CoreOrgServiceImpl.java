package com.github.sparkzxl.auth.domain.service;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.sparkzxl.auth.application.service.ICoreOrgService;
import com.github.sparkzxl.auth.domain.repository.IAuthUserRepository;
import com.github.sparkzxl.auth.domain.repository.ICoreOrgRepository;
import com.github.sparkzxl.auth.infrastructure.constant.BizConstant;
import com.github.sparkzxl.auth.infrastructure.convert.CoreOrgConvert;
import com.github.sparkzxl.auth.infrastructure.entity.CoreOrg;
import com.github.sparkzxl.auth.infrastructure.mapper.CoreOrgMapper;
import com.github.sparkzxl.auth.interfaces.dto.org.OrgSaveDTO;
import com.github.sparkzxl.auth.interfaces.dto.org.OrgUpdateDTO;
import com.github.sparkzxl.auth.interfaces.dto.org.OrgUserSaveDTO;
import com.github.sparkzxl.core.util.MapHelper;
import com.github.sparkzxl.database.base.service.impl.SuperCacheServiceImpl;
import com.github.sparkzxl.database.util.TreeUtil;
import com.github.sparkzxl.entity.data.TreeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * description: 组织 服务实现类
 *
 * @author charles.zhou
 * @date 2020-06-07 13:37:19
 */
@Service
public class CoreOrgServiceImpl extends SuperCacheServiceImpl<CoreOrgMapper, CoreOrg> implements ICoreOrgService {

    @Autowired
    private IAuthUserRepository userRepository;
    @Autowired
    private ICoreOrgRepository coreOrgRepository;


    @Override
    public Map<Serializable, Object> findNameByIds(Set<Serializable> ids) {
        return null;
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
            list = idList.stream().map(super.baseMapper::selectById).filter(Objects::nonNull).collect(Collectors.toList());
        } else {
            list = super.baseMapper.selectList(new QueryWrapper<CoreOrg>().lambda().in(CoreOrg::getId, idList).eq(CoreOrg::getStatus, true));
        }
        return list;
    }


    @Override
    public List<CoreOrg> getCoreOrgTree(String name, Boolean status) {
        List<CoreOrg> coreOrgList = coreOrgRepository.getCoreOrgList(name, status);
        return TreeUtil.buildTree(coreOrgList);
    }

    @Override
    public CoreOrg getCoreOrgByName(String name) {
        return getOne(new LambdaQueryWrapper<CoreOrg>().eq(TreeEntity::getLabel, name)
                .eq(CoreOrg::getStatus, true)
                .last("limit 1"));
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
        userRepository.deleteOrgIds(ids);
        return true;
    }

    @Override
    public boolean updateOrgUser(OrgUserSaveDTO orgUserSaveDTO) {
        return userRepository.updateOrgUser(orgUserSaveDTO.getOrgId(), orgUserSaveDTO.getUserIds());
    }

    @Override
    protected String getRegion() {
        return BizConstant.ORG;
    }
}
