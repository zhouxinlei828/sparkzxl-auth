package com.github.sparkzxl.oauth.infrastructure.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.sparkzxl.auth.api.dto.DictionaryItemDTO;
import com.github.sparkzxl.entity.data.SuperEntity;
import com.github.sparkzxl.oauth.domain.repository.IAuthApplicationRepository;
import com.github.sparkzxl.oauth.domain.repository.IOauthClientDetailsRepository;
import com.github.sparkzxl.oauth.interfaces.client.DictionaryProvider;
import com.github.sparkzxl.oauth.infrastructure.entity.AuthApplication;
import com.github.sparkzxl.oauth.infrastructure.entity.OauthClientDetails;
import com.github.sparkzxl.oauth.infrastructure.mapper.AuthApplicationMapper;
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
 * @since 2021-03-06 19:23:56
 */
@Repository
public class AuthApplicationRepository implements IAuthApplicationRepository {

    private final String SERVER_TYPE = "SERVER";
    private AuthApplicationMapper authApplicationMapper;
    private IOauthClientDetailsRepository oauthClientDetailsRepository;
    private DictionaryProvider dictionaryProvider;

    @Autowired
    public void setAuthApplicationMapper(AuthApplicationMapper authApplicationMapper) {
        this.authApplicationMapper = authApplicationMapper;
    }

    @Autowired
    public void setOauthClientDetailsRepository(IOauthClientDetailsRepository oauthClientDetailsRepository) {
        this.oauthClientDetailsRepository = oauthClientDetailsRepository;
    }

    @Autowired
    public void setDictionaryClient(DictionaryProvider dictionaryProvider) {
        this.dictionaryProvider = dictionaryProvider;
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
    public Page<AuthApplication> listPage(int pageNum, int pageSize, String clientId, String appName) {
        LambdaQueryWrapper<AuthApplication> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(StringUtils.isNotEmpty(clientId), AuthApplication::getClientId, clientId)
                .likeRight(StringUtils.isNotEmpty(appName), AuthApplication::getAppTypeName, appName).orderByDesc(AuthApplication::getCreateTime);
        Page<AuthApplication> authApplicationPage = authApplicationMapper.selectPage(new Page<>(pageNum, pageSize), lambdaQueryWrapper);
        List<AuthApplication> applicationList = authApplicationPage.getRecords();
        if (CollectionUtils.isNotEmpty(applicationList)) {
            List<String> clientIds = applicationList.stream().map(AuthApplication::getClientId).filter(ObjectUtils::isNotEmpty).collect(Collectors.toList());
            Set<String> appTypeCodes = applicationList.stream().map(AuthApplication::getAppType).filter(ObjectUtils::isNotEmpty).collect(Collectors.toSet());
            Map<String, DictionaryItemDTO> dictionaryItemMap = dictionaryProvider.findDictionaryItemMap("APPLICATION_TYPE",
                    appTypeCodes);
            List<OauthClientDetails> oauthClientDetails = oauthClientDetailsRepository.findListByIdList(clientIds);
            Map<String, OauthClientDetails> oauthClientDetailsMap =
                    oauthClientDetails.stream().collect(Collectors.toMap(OauthClientDetails::getClientId, key -> key));
            applicationList.forEach(application -> {
                if (StringUtils.isNotEmpty(application.getClientId())) {
                    application.setOauthClientDetail(oauthClientDetailsMap.get(application.getClientId()));
                }
                DictionaryItemDTO dictionaryItem = dictionaryItemMap.get(application.getAppType());
                if (ObjectUtils.isNotEmpty(dictionaryItem)) {
                    application.setAppTypeName(dictionaryItem.getName());
                }
            });
            authApplicationPage.setRecords(applicationList);
        }
        return authApplicationPage;
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
