package com.github.sparkzxl.auth.infrastructure.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.sparkzxl.auth.domain.repository.ILoginLogRepository;
import com.github.sparkzxl.auth.domain.repository.IRealmPoolRepository;
import com.github.sparkzxl.auth.infrastructure.entity.LoginLog;
import com.github.sparkzxl.auth.infrastructure.entity.LoginLogCount;
import com.github.sparkzxl.auth.infrastructure.entity.RealmPool;
import com.github.sparkzxl.auth.infrastructure.mapper.LoginLogMapper;
import com.github.sparkzxl.core.context.BaseContextHolder;
import com.github.sparkzxl.core.utils.DateUtils;
import com.github.sparkzxl.database.utils.PageInfoUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * description：登录日志 仓储实现类
 *
 * @author charles.zhou
 * @date 2020/6/17 0017
 */
@Repository
public class LoginLogRepository implements ILoginLogRepository {

    private LoginLogMapper loginLogMapper;
    private IRealmPoolRepository realmPoolRepository;


    @Autowired
    public void setLoginLogMapper(LoginLogMapper loginLogMapper) {
        this.loginLogMapper = loginLogMapper;
    }

    @Autowired
    public void setRealmPoolRepository(IRealmPoolRepository realmPoolRepository) {
        this.realmPoolRepository = realmPoolRepository;
    }

    @Override
    public void saveLoginLog(LoginLog loginLog) {
        loginLogMapper.insert(loginLog);
    }

    @Override
    public List<LoginLogCount> findLastTenDaysVisitCount(LocalDate tenDays, String account) {
        return loginLogMapper.findLastTenDaysVisitCount(tenDays, account);
    }

    @Override
    public List<LoginLogCount> findByBrowser() {
        return loginLogMapper.findByBrowser();
    }

    @Override
    public List<LoginLogCount> findByOperatingSystem() {
        return loginLogMapper.findByOperatingSystem();
    }

    @Override
    public boolean clearLog(LocalDateTime clearBeforeTime, Integer clearBeforeNum) {
        return loginLogMapper.clearLog(clearBeforeTime, clearBeforeNum);
    }

    @Override
    public PageInfo<LoginLog> getLoginLogPage(int pageNum, int pageSize, boolean realmStatus, Long realmUserId, String account, Date startTime, Date endTime) {
        LambdaQueryWrapper<LoginLog> loginLogLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotEmpty(account)) {
            loginLogLambdaQueryWrapper.likeRight(LoginLog::getAccount, account);
        }
        if (ObjectUtils.isNotEmpty(startTime) && ObjectUtils.isNotEmpty(endTime)) {
            loginLogLambdaQueryWrapper.ge(LoginLog::getLoginDate, DateUtils.beginOfDay(startTime));
            loginLogLambdaQueryWrapper.le(LoginLog::getLoginDate, DateUtils.endOfDay(startTime));
        } else if (ObjectUtils.isNotEmpty(startTime) && ObjectUtils.isEmpty(endTime)) {
            loginLogLambdaQueryWrapper.ge(LoginLog::getLoginDate, DateUtils.beginOfDay(startTime));
            loginLogLambdaQueryWrapper.le(LoginLog::getLoginDate, DateUtils.endOfDay(new Date()));
        } else if (ObjectUtils.isEmpty(startTime) && ObjectUtils.isNotEmpty(endTime)) {
            loginLogLambdaQueryWrapper.le(LoginLog::getLoginDate, DateUtils.endOfDay(endTime));
        }
        if (realmStatus) {
            List<RealmPool> realmPoolList = realmPoolRepository.getRealmPoolList(realmUserId);
            List<String> realmCodeList = realmPoolList.stream().map(RealmPool::getCode).collect(Collectors.toList());
            loginLogLambdaQueryWrapper.in(LoginLog::getRealmCode, realmCodeList)
                    .or().eq(LoginLog::getUserId, realmUserId);
        } else {
            String realmCode = BaseContextHolder.getRealm();
            loginLogLambdaQueryWrapper.in(LoginLog::getRealmCode, realmCode);
        }
        loginLogLambdaQueryWrapper.orderByDesc(LoginLog::getLoginDate);
        PageHelper.startPage(pageNum, pageSize);
        List<LoginLog> loginLogs = loginLogMapper.selectList(loginLogLambdaQueryWrapper);
        return PageInfoUtils.pageInfo(loginLogs);
    }

    @Override
    public boolean deleteLoginLog(List<Long> ids) {
        if (CollectionUtils.isNotEmpty(ids)) {
            loginLogMapper.deleteBatchIds(ids);
        }
        return true;
    }
}
