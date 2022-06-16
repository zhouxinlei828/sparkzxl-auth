package com.github.sparkzxl.auth.infrastructure.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.sparkzxl.auth.domain.repository.ILoginLogRepository;
import com.github.sparkzxl.auth.infrastructure.entity.LoginLog;
import com.github.sparkzxl.auth.infrastructure.entity.LoginLogCount;
import com.github.sparkzxl.auth.infrastructure.mapper.LoginLogMapper;
import com.github.sparkzxl.core.util.DateUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * description：登录日志 仓储实现类
 *
 * @author charles.zhou
 * @since 2020/6/17 0017
 */
@Repository
public class LoginLogRepository implements ILoginLogRepository {

    private LoginLogMapper loginLogMapper;


    @Autowired
    public void setLoginLogMapper(LoginLogMapper loginLogMapper) {
        this.loginLogMapper = loginLogMapper;
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
    public Page<LoginLog> getLoginLogPage(int pageNum, int pageSize, Long userId, String account,
                                          Date startTime, Date endTime) {
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
        loginLogLambdaQueryWrapper.orderByDesc(LoginLog::getLoginDate);
        return loginLogMapper.selectPage(new Page<>(pageNum, pageSize), loginLogLambdaQueryWrapper);
    }

    @Override
    public boolean deleteLoginLog(List<Long> ids) {
        if (CollectionUtils.isNotEmpty(ids)) {
            loginLogMapper.deleteBatchIds(ids);
        }
        return true;
    }
}
