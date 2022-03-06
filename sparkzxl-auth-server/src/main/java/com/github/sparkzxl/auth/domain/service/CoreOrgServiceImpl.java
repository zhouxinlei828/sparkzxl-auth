package com.github.sparkzxl.auth.domain.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.sparkzxl.auth.application.service.ICoreOrgService;
import com.github.sparkzxl.auth.domain.repository.IAuthUserRepository;
import com.github.sparkzxl.auth.domain.repository.ICoreOrgRepository;
import com.github.sparkzxl.auth.infrastructure.convert.CoreOrgConvert;
import com.github.sparkzxl.auth.infrastructure.entity.CoreOrg;
import com.github.sparkzxl.auth.infrastructure.mapper.CoreOrgMapper;
import com.github.sparkzxl.auth.interfaces.dto.org.OrgSaveDTO;
import com.github.sparkzxl.auth.interfaces.dto.org.OrgUpdateDTO;
import com.github.sparkzxl.auth.interfaces.dto.org.OrgUserSaveDTO;
import com.github.sparkzxl.database.base.service.impl.SuperServiceImpl;
import com.github.sparkzxl.database.util.TreeUtil;
import com.github.sparkzxl.entity.data.TreeEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * description: 组织 服务实现类
 *
 * @author charles.zhou
 * @date 2020-06-07 13:37:19
 */
@Service
public class CoreOrgServiceImpl extends SuperServiceImpl<CoreOrgMapper, CoreOrg> implements ICoreOrgService {

    @Resource
    private IAuthUserRepository userRepository;
    @Resource
    private ICoreOrgRepository coreOrgRepository;


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

}
