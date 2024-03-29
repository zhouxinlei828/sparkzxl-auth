package com.github.sparkzxl.oauth.domain.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.sparkzxl.database.base.service.impl.SuperServiceImpl;
import com.github.sparkzxl.dto.PageParams;
import com.github.sparkzxl.oauth.application.service.IApplicationService;
import com.github.sparkzxl.oauth.domain.repository.IAuthApplicationRepository;
import com.github.sparkzxl.oauth.infrastructure.convert.AuthApplicationConvert;
import com.github.sparkzxl.oauth.infrastructure.entity.AuthApplication;
import com.github.sparkzxl.oauth.infrastructure.mapper.AuthApplicationMapper;
import com.github.sparkzxl.oauth.domain.model.dto.AuthApplicationQueryDTO;
import com.github.sparkzxl.oauth.domain.model.dto.AuthApplicationSaveDTO;
import com.github.sparkzxl.oauth.domain.model.dto.AuthApplicationUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description: 租户信息客户端服务实现类
 *
 * @author charles.zhou
 * @since 2021-02-20 09:44:43
 */
@Service
public class ApplicationServiceServiceImpl extends SuperServiceImpl<AuthApplicationMapper, AuthApplication> implements IApplicationService {


    @Autowired
    private IAuthApplicationRepository authApplicationRepository;

    @Override
    public boolean saveApplication(AuthApplicationSaveDTO authApplicationSaveDTO) {
        return authApplicationRepository.saveAuthApplication(AuthApplicationConvert.INSTANCE
                .convertAuthApplication(authApplicationSaveDTO));
    }

    @Override
    public Page<AuthApplication> listPage(PageParams<AuthApplicationQueryDTO> params) {
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
        return authApplicationRepository.updateAuthApplication(AuthApplicationConvert.INSTANCE
                .convertAuthApplication(authApplicationUpdateDTO));
    }
}
