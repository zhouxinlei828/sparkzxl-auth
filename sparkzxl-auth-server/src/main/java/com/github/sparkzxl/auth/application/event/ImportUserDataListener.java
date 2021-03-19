package com.github.sparkzxl.auth.application.event;

import com.alibaba.excel.context.AnalysisContext;
import com.github.sparkzxl.auth.application.service.IUserService;
import com.github.sparkzxl.auth.application.service.IDictionaryItemService;
import com.github.sparkzxl.auth.application.service.ICoreOrgService;
import com.github.sparkzxl.auth.application.service.ICoreStationService;
import com.github.sparkzxl.auth.domain.model.aggregates.excel.UserExcel;
import com.github.sparkzxl.auth.infrastructure.entity.AuthUser;
import com.github.sparkzxl.auth.infrastructure.entity.CommonDictionaryItem;
import com.github.sparkzxl.auth.infrastructure.entity.CoreOrg;
import com.github.sparkzxl.auth.infrastructure.entity.CoreStation;
import com.github.sparkzxl.auth.infrastructure.enums.SexEnum;
import com.github.sparkzxl.database.base.listener.ImportDataListener;
import com.github.sparkzxl.database.entity.RemoteData;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * description: 用户Excel导入监听
 *
 * @author charles.zhou
 * @date   2021-01-04 15:34:07
 */
@Component
@Slf4j
public class ImportUserDataListener extends ImportDataListener<UserExcel> {

    private final List<UserExcel> list = Lists.newArrayList();
    private final AtomicInteger count = new AtomicInteger(0);

    private IUserService authUserService;
    private ICoreOrgService coreOrgService;
    private ICoreStationService coreStationService;
    private IDictionaryItemService dictionaryItemService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setAuthUserService(IUserService authUserService) {
        this.authUserService = authUserService;
    }

    @Autowired
    public void setCoreOrgService(ICoreOrgService coreOrgService) {
        this.coreOrgService = coreOrgService;
    }

    @Autowired
    public void setCoreStationService(ICoreStationService coreStationService) {
        this.coreStationService = coreStationService;
    }

    @Autowired
    public void setDictionaryItemService(IDictionaryItemService dictionaryItemService) {
        this.dictionaryItemService = dictionaryItemService;
    }

    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("所有数据解析完成！size：{}", list.size());
        List<AuthUser> authUserList = Lists.newArrayList();
        list.forEach(item -> {
            AuthUser authUser = new AuthUser();
            authUser.setAccount(item.getAccount());
            authUser.setName(item.getName());
            if (StringUtils.isNotEmpty(item.getOrgName())) {
                CoreOrg org = coreOrgService.getCoreOrgByName(item.getOrgName());
                if (ObjectUtils.isNotEmpty(org)) {
                    authUser.setOrg(new RemoteData<>(org.getId()));
                }
            }
            if (StringUtils.isNotEmpty(item.getStationName())) {
                CoreStation station = coreStationService.getCoreStationByName(item.getStationName());
                if (ObjectUtils.isNotEmpty(station)) {
                    authUser.setStation(new RemoteData<>(station.getId()));
                }
            }
            authUser.setEmail(item.getEmail());
            authUser.setMobile(item.getMobile());
            authUser.setSex(SexEnum.getEnum(item.getSex()));
            authUser.setPassword(passwordEncoder.encode("123456"));
            if (StringUtils.isNotEmpty(item.getNation())) {
                CommonDictionaryItem dictionaryItem = dictionaryItemService.getDictionaryItemByName(item.getNation());
                if (ObjectUtils.isNotEmpty(dictionaryItem)) {
                    authUser.setNation(new RemoteData<>(dictionaryItem.getCode()));
                }
            }
            if (StringUtils.isNotEmpty(item.getEducation())) {
                CommonDictionaryItem dictionaryItem = dictionaryItemService.getDictionaryItemByName(item.getEducation());
                if (ObjectUtils.isNotEmpty(dictionaryItem)) {
                    authUser.setEducation(new RemoteData<>(dictionaryItem.getCode()));
                }
            }
            if (StringUtils.isNotEmpty(item.getPositionStatus())) {
                CommonDictionaryItem dictionaryItem = dictionaryItemService.getDictionaryItemByName(item.getPositionStatus());
                if (ObjectUtils.isNotEmpty(dictionaryItem)) {
                    authUser.setPositionStatus(new RemoteData<>(dictionaryItem.getCode()));
                }
            }
            authUser.setStatus(true);
            authUser.setPasswordErrorNum(0);
            authUserList.add(authUser);
            count.getAndIncrement();
        });
        authUserService.saveBatch(authUserList);
    }
}
