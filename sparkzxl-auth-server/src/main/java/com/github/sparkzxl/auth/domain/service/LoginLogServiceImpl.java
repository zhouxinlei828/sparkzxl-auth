package com.github.sparkzxl.auth.domain.service;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageInfo;
import com.github.sparkzxl.auth.application.service.ILoginLogService;
import com.github.sparkzxl.auth.domain.model.aggregates.LoginStatus;
import com.github.sparkzxl.auth.domain.repository.IAuthUserRepository;
import com.github.sparkzxl.auth.domain.repository.ILoginLogRepository;
import com.github.sparkzxl.auth.infrastructure.constant.CacheConstant;
import com.github.sparkzxl.auth.infrastructure.entity.AuthUser;
import com.github.sparkzxl.auth.infrastructure.entity.LoginLog;
import com.github.sparkzxl.auth.infrastructure.entity.LoginLogCount;
import com.github.sparkzxl.auth.infrastructure.mapper.LoginLogMapper;
import com.github.sparkzxl.auth.interfaces.dto.log.LoginLogQueryDTO;
import com.github.sparkzxl.core.entity.AuthUserInfo;
import com.github.sparkzxl.core.entity.UserAgentEntity;
import com.github.sparkzxl.core.utils.BuildKeyUtils;
import com.github.sparkzxl.database.base.service.impl.SuperCacheServiceImpl;
import com.github.sparkzxl.database.dto.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * description：系统日志 服务实现类
 *
 * @author charles.zhou
 * @date 2020/6/17 0017
 */
@Service
public class LoginLogServiceImpl extends SuperCacheServiceImpl<LoginLogMapper, LoginLog> implements ILoginLogService {

    @Autowired
    private IAuthUserRepository authUserRepository;

    @Autowired
    private ILoginLogRepository loginLogRepository;

    @Override
    public void save(LoginStatus<Long> loginStatus) {
        AuthUser authUser;
        if (loginStatus.getId() != null) {
            authUser = authUserRepository.selectById(loginStatus.getId());
        } else {
            authUser = authUserRepository.selectByAccount(loginStatus.getAccount());
        }
        UserAgentEntity userAgentEntity = loginStatus.getUserAgentEntity();
        System.out.println(userAgentEntity);
        LoginLog loginLog = LoginLog.builder()
                .requestIp(userAgentEntity.getRequestIp())
                .userId(loginStatus.getId())
                .userName(loginStatus.getName())
                .account(loginStatus.getAccount())
                .description(loginStatus.getDescription())
                .loginDate(LocalDateTime.now())
                .ua(userAgentEntity.getUa())
                .browser(userAgentEntity.getBrowser())
                .browserVersion(userAgentEntity.getBrowserVersion())
                .operatingSystem(userAgentEntity.getOperatingSystem())
                .location(userAgentEntity.getLocation())
                .build();
        if (authUser != null) {
            loginLog.setAccount(authUser.getAccount()).setUserId(authUser.getId()).setUserName(authUser.getName())
                    .setCreateUser(authUser.getId());
            loginLog.setRealmCode(authUser.getRealmCode());
        }
        loginLogRepository.saveLoginLog(loginLog);
        LocalDate now = LocalDate.now();
        LocalDate tenDays = now.plusDays(-9);
        cacheTemplate.remove(CacheConstant.LOGIN_LOG_TOTAL);
        cacheTemplate.remove(BuildKeyUtils.generateKey(CacheConstant.LOGIN_LOG_TODAY, now));
        cacheTemplate.remove(BuildKeyUtils.generateKey(CacheConstant.LOGIN_LOG_TODAY_IP, now));
        cacheTemplate.remove(BuildKeyUtils.generateKey(CacheConstant.LOGIN_LOG_BROWSER));
        cacheTemplate.remove(BuildKeyUtils.generateKey(CacheConstant.LOGIN_LOG_SYSTEM));
        if (authUser != null) {
            cacheTemplate.remove(BuildKeyUtils.generateKey(CacheConstant.LOGIN_LOG_TEN_DAY, tenDays, loginStatus.getAccount()));
        }
    }

    @Override
    public Long findTotalVisitCount() {
        return cacheTemplate.get(CacheConstant.LOGIN_LOG_TOTAL);
    }

    @Override
    public Long findTodayVisitCount() {
        LocalDate now = LocalDate.now();
        return cacheTemplate.get(BuildKeyUtils.generateKey(CacheConstant.LOGIN_LOG_TODAY, now));
    }

    @Override
    public Long findTodayIp() {
        LocalDate now = LocalDate.now();
        return cacheTemplate.get(BuildKeyUtils.generateKey(CacheConstant.LOGIN_LOG_TODAY_IP, now));
    }

    @Override
    public List<LoginLogCount> findLastTenDaysVisitCount(String account) {
        LocalDate tenDays = LocalDate.now().plusDays(-9);
        return cacheTemplate.get(BuildKeyUtils.generateKey(CacheConstant.LOGIN_LOG_TEN_DAY, tenDays, account),
                (key) -> loginLogRepository.findLastTenDaysVisitCount(tenDays, account));
    }

    @Override
    public List<LoginLogCount> findByBrowser() {
        return cacheTemplate.get(BuildKeyUtils.generateKey(CacheConstant.LOGIN_LOG_BROWSER),
                (key) -> loginLogRepository.findByBrowser());
    }

    @Override
    public List<LoginLogCount> findByOperatingSystem() {
        return cacheTemplate.get(BuildKeyUtils.generateKey(CacheConstant.LOGIN_LOG_SYSTEM),
                (key) -> loginLogRepository.findByOperatingSystem());
    }

    @Override
    public boolean clearLog(LocalDateTime clearBeforeTime, Integer clearBeforeNum) {
        return loginLogRepository.clearLog(clearBeforeTime, clearBeforeNum);
    }

    @Override
    public PageInfo<LoginLog> getLoginLogPage(AuthUserInfo<Long> authUserInfo, PageParams<LoginLogQueryDTO> pageParams) {
        Map<String, Object> extraInfo = authUserInfo.getExtraInfo();
        boolean realmStatus = (boolean) extraInfo.get("realmStatus");
        return loginLogRepository.getLoginLogPage(pageParams.getPageNum(), pageParams.getPageSize(),
                realmStatus, authUserInfo.getId(), pageParams.getModel().getAccount(), pageParams.getModel().getStartTime(),
                pageParams.getModel().getEndTime());
    }

    @Override
    public boolean deleteLoginLog(List<Long> ids) {
        return loginLogRepository.deleteLoginLog(ids);
    }

    @Override
    protected String getRegion() {
        return "login_log";
    }
}
