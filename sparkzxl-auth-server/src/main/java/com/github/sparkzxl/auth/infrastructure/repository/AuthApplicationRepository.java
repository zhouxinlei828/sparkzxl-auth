package com.github.sparkzxl.auth.infrastructure.repository;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.sparkzxl.auth.domain.repository.IAuthApplicationRepository;
import com.github.sparkzxl.auth.domain.repository.IDictionaryItemRepository;
import com.github.sparkzxl.auth.domain.repository.IOauthClientDetailsRepository;
import com.github.sparkzxl.auth.infrastructure.entity.AuthApplication;
import com.github.sparkzxl.auth.infrastructure.entity.CommonDictionaryItem;
import com.github.sparkzxl.auth.infrastructure.entity.OauthClientDetails;
import com.github.sparkzxl.auth.infrastructure.mapper.AuthApplicationMapper;
import com.github.sparkzxl.database.utils.PageInfoUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * description: 应用 仓储实现类
 *
 * @author charles.zhou
 * @date 2021-03-06 19:23:56
 */
@Repository
public class AuthApplicationRepository implements IAuthApplicationRepository {

    private final String SERVER_TYPE = "SERVER";
    private AuthApplicationMapper authApplicationMapper;
    private IOauthClientDetailsRepository oauthClientDetailsRepository;
    private IDictionaryItemRepository dictionaryItemRepository;

    @Autowired
    public void setAuthApplicationMapper(AuthApplicationMapper authApplicationMapper) {
        this.authApplicationMapper = authApplicationMapper;
    }

    @Autowired
    public void setOauthClientDetailsRepository(IOauthClientDetailsRepository oauthClientDetailsRepository) {
        this.oauthClientDetailsRepository = oauthClientDetailsRepository;
    }

    @Autowired
    public void setDictionaryItemRepository(IDictionaryItemRepository dictionaryItemRepository) {
        this.dictionaryItemRepository = dictionaryItemRepository;
    }

    @Override
    public boolean saveAuthApplication(AuthApplication application) {
        if (application.getAppType().equals(SERVER_TYPE)) {
            OauthClientDetails oauthClientDetails = application.getOauthClientDetail();
            application.setOriginalClientSecret(oauthClientDetails.getClientSecret());
            application.setClientId(oauthClientDetails.getClientId());
            oauthClientDetailsRepository.saveOauthClientDetails(oauthClientDetails);
        }
        return authApplicationMapper.insert(application) == 1;
    }

    @Override
    public PageInfo<AuthApplication> listPage(int pageNum, int pageSize, String clientId, String appName) {
        PageHelper.startPage(pageNum, pageSize);
        List<AuthApplication> authApplications = authApplicationMapper.listPage(clientId, appName);
        PageInfo<AuthApplication> authApplicationPageInfo = PageInfoUtils.pageInfo(authApplications);
        List<AuthApplication> applicationList = authApplicationPageInfo.getList();
        if (CollectionUtils.isNotEmpty(applicationList)) {
            List<String> clientIds = applicationList.stream().map(AuthApplication::getClientId).filter(ObjectUtils::isNotEmpty).collect(Collectors.toList());
            Set<String> appTypeCodes = applicationList.stream().map(AuthApplication::getAppType).filter(ObjectUtils::isNotEmpty).collect(Collectors.toSet());
            Map<String, CommonDictionaryItem> dictionaryItemMap = dictionaryItemRepository.findDictionaryItemList("APPLICATION_TYPE",
                    appTypeCodes);
            List<OauthClientDetails> oauthClientDetails = oauthClientDetailsRepository.findListByIdList(clientIds);
            Map<String, OauthClientDetails> oauthClientDetailsMap = oauthClientDetails.stream().collect(Collectors.toMap(OauthClientDetails::getClientId, key -> key));
            applicationList.forEach(application -> {
                if (StringUtils.isNotEmpty(application.getClientId())) {
                    application.setOauthClientDetail(oauthClientDetailsMap.get(application.getClientId()));
                }
                CommonDictionaryItem commonDictionaryItem = dictionaryItemMap.get(application.getAppType());
                if (ObjectUtils.isNotEmpty(commonDictionaryItem)) {
                    application.setAppTypeName(commonDictionaryItem.getName());
                }
            });
            authApplicationPageInfo.setList(applicationList);
        }
        return authApplicationPageInfo;
    }

    @Override
    public boolean deleteAuthApplication(List<Long> ids) {
        List<AuthApplication> authApplications = authApplicationMapper.selectBatchIds(ids);
        List<String> clientIds = authApplications.stream().map(AuthApplication::getClientId).collect(Collectors.toList());
        oauthClientDetailsRepository.deleteClient(clientIds);
        return authApplicationMapper.deleteBatchIds(ids) > 0;
    }

    @Override
    public boolean updateAuthApplication(AuthApplication application) {
        if (application.getAppType().equals(SERVER_TYPE)) {
            OauthClientDetails oauthClientDetails = application.getOauthClientDetail();
            application.setOriginalClientSecret(oauthClientDetails.getClientSecret());
            application.setClientId(oauthClientDetails.getClientId());
            oauthClientDetailsRepository.updateOauthClientDetails(oauthClientDetails);
        }
        authApplicationMapper.updateById(application);
        return true;
    }

    @Override
    public List<AuthApplication> applicationList() {
        return authApplicationMapper.applicationList();
    }
}
