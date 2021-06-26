package com.github.sparkzxl.auth.domain.service;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.sparkzxl.auth.application.service.ICoreOrgService;
import com.github.sparkzxl.auth.application.service.IUserService;
import com.github.sparkzxl.auth.application.service.es.IEsOrgAttributeService;
import com.github.sparkzxl.auth.domain.repository.ICoreOrgRepository;
import com.github.sparkzxl.auth.infrastructure.constant.CacheConstant;
import com.github.sparkzxl.auth.infrastructure.constant.ElasticsearchConstant;
import com.github.sparkzxl.auth.infrastructure.convert.CoreOrgConvert;
import com.github.sparkzxl.auth.infrastructure.entity.CoreOrg;
import com.github.sparkzxl.auth.infrastructure.mapper.CoreOrgMapper;
import com.github.sparkzxl.auth.interfaces.dto.org.OrgSaveDTO;
import com.github.sparkzxl.auth.interfaces.dto.org.OrgUpdateDTO;
import com.github.sparkzxl.constant.EntityConstant;
import com.github.sparkzxl.core.utils.MapHelper;
import com.github.sparkzxl.database.base.service.impl.SuperCacheServiceImpl;
import com.github.sparkzxl.database.utils.TreeUtil;
import com.github.sparkzxl.entity.data.TreeEntity;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
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
    private IUserService authUserService;
    @Autowired
    private ICoreOrgRepository coreOrgRepository;
    @Autowired
    private IEsOrgAttributeService esOrgAttributeService;


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
        if (CollectionUtils.isNotEmpty(coreOrgList)) {
            List<String> orgIdStrList = coreOrgList.stream().map(x -> String.valueOf(x.getId())).collect(Collectors.toList());
            Map<String, Map> searchOrgAttribute = esOrgAttributeService.searchDocsMapByIdList(ElasticsearchConstant.INDEX_ORG_ATTRIBUTE, orgIdStrList, Map.class);
            coreOrgList.forEach(org -> {
                Map map = searchOrgAttribute.get(String.valueOf(org.getId()));
                if (MapUtils.isNotEmpty(map)) {
                    map.remove(EntityConstant.COLUMN_ID);
                    org.setAttribute(map);
                }
            });
        }
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
        boolean result = coreOrgRepository.saveCoreOrg(coreOrg);
        Long orgId = coreOrg.getId();
        Map<String, Object> orgAttributeMap = coreOrg.getAttribute();
        orgAttributeMap.put(EntityConstant.COLUMN_ID, String.valueOf(orgId));
        esOrgAttributeService.saveDoc(ElasticsearchConstant.INDEX_ORG_ATTRIBUTE, String.valueOf(orgId), orgAttributeMap);
        return result;
    }

    @Override
    public boolean updateCoreOrg(OrgUpdateDTO orgUpdateDTO) {
        CoreOrg coreOrg = CoreOrgConvert.INSTANCE.convertCoreOrg(orgUpdateDTO);
        boolean result = coreOrgRepository.updateCoreOrg(coreOrg);
        Map<String, Object> orgAttributeMap = coreOrg.getAttribute();
        Long orgId = coreOrg.getId();
        esOrgAttributeService.deleteDocById(ElasticsearchConstant.INDEX_ORG_ATTRIBUTE, String.valueOf(orgId));
        if (MapUtils.isNotEmpty(orgAttributeMap)) {
            orgAttributeMap.put(EntityConstant.COLUMN_ID, String.valueOf(orgId));
            esOrgAttributeService.saveDoc(ElasticsearchConstant.INDEX_ORG_ATTRIBUTE, String.valueOf(orgId), orgAttributeMap);
        }
        return result;
    }

    @Override
    public boolean deleteBatchCoreOrg(List<Long> ids) {
        coreOrgRepository.deleteBatchCoreOrg(ids);
        authUserService.deleteOrgIds(ids);
        if (CollectionUtils.isNotEmpty(ids)) {
            esOrgAttributeService.deleteDocByIds(ElasticsearchConstant.INDEX_ORG_ATTRIBUTE, ids.stream().map(String::valueOf).collect(Collectors.toList()));
        }
        return true;
    }

    @Override
    protected String getRegion() {
        return CacheConstant.ORG;
    }
}
