package com.github.sparkzxl.auth.domain.service;

import com.github.pagehelper.PageInfo;
import com.github.sparkzxl.auth.application.service.IApplicationService;
import com.github.sparkzxl.auth.domain.repository.IAuthApplicationRepository;
import com.github.sparkzxl.auth.infrastructure.convert.AuthApplicationConvert;
import com.github.sparkzxl.auth.infrastructure.entity.AuthApplication;
import com.github.sparkzxl.auth.infrastructure.mapper.AuthApplicationMapper;
import com.github.sparkzxl.auth.interfaces.dto.application.AuthApplicationQueryDTO;
import com.github.sparkzxl.auth.interfaces.dto.application.AuthApplicationSaveDTO;
import com.github.sparkzxl.auth.interfaces.dto.application.AuthApplicationUpdateDTO;
import com.github.sparkzxl.database.base.service.impl.SuperCacheServiceImpl;
import com.github.sparkzxl.database.dto.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description: 租户池客户端服务实现类
 *
 * @author charles.zhou
 * @date   2021-02-20 09:44:43
 */
@Service
public class ApplicationServiceServiceImpl extends SuperCacheServiceImpl<AuthApplicationMapper, AuthApplication> implements IApplicationService {


    @Autowired
    private IAuthApplicationRepository authApplicationRepository;

    @Override
    public boolean saveApplication(AuthApplicationSaveDTO authApplicationSaveDTO) {
        AuthApplication authApplication = AuthApplicationConvert.INSTANCE.convertAuthApplication(authApplicationSaveDTO);
        return authApplicationRepository.saveAuthApplication(authApplication);
    }

    @Override
    public PageInfo<AuthApplication> listPage(PageParams<AuthApplicationQueryDTO> params) {
        return authApplicationRepository.listPage(params.getPageNum(), params.getPageSize(),
                params.getModel().getClientId(), params.getModel().getAppName());
    }

    @Override
    public List<AuthApplication> applicationList() {
        return authApplicationRepository.applicationList();
    }

    @Override
    public boolean deleteApplication(List<Long> ids) {
        return authApplicationRepository.deleteAuthApplication(ids);
    }

    @Override
    public boolean updateApplication(AuthApplicationUpdateDTO authApplicationUpdateDTO) {
        AuthApplication authApplication = AuthApplicationConvert.INSTANCE.convertAuthApplication(authApplicationUpdateDTO);
        return authApplicationRepository.updateAuthApplication(authApplication);
    }

    @Override
    protected String getRegion() {
        return "auth_application";
    }
}
