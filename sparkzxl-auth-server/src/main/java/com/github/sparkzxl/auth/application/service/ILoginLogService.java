package com.github.sparkzxl.auth.application.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.sparkzxl.auth.api.dto.UserDetail;
import com.github.sparkzxl.auth.domain.model.aggregates.LoginStatus;
import com.github.sparkzxl.auth.infrastructure.entity.LoginLog;
import com.github.sparkzxl.auth.infrastructure.entity.LoginLogCount;
import com.github.sparkzxl.auth.domain.model.dto.log.LoginLogQueryDTO;
import com.github.sparkzxl.database.base.service.SuperService;
import com.github.sparkzxl.dto.PageParams;
import com.github.sparkzxl.entity.core.AuthUserInfo;

import java.time.LocalDateTime;
import java.util.List;

/**
 * description：系统日志 服务类
 *
 * @author charles.zhou
 * @since 2020-06-17 11:33:15
 */
public interface ILoginLogService extends SuperService<LoginLog> {

    /**
     * 记录登录日志
     *
     * @param loginStatus 登录态
     */
    void save(LoginStatus<Long> loginStatus);

    /**
     * 获取系统总访问次数
     *
     * @return Long
     */
    Long findTotalVisitCount();

    /**
     * 获取系统今日访问次数
     *
     * @return Long
     */
    Long findTodayVisitCount();

    /**
     * 获取系统今日访问 IP数
     *
     * @return Long
     */
    Long findTodayIp();


    /**
     * 获取系统近十天来的访问记录
     *
     * @param account 账号
     * @return List<LoginLogCount>
     */
    List<LoginLogCount> findLastTenDaysVisitCount(String account);

    /**
     * 按浏览器来统计数量
     *
     * @return List<LoginLogCount>
     */
    List<LoginLogCount> findByBrowser();

    /**
     * 按造作系统内统计数量
     *
     * @return List<LoginLogCount>
     */
    List<LoginLogCount> findByOperatingSystem();

    /**
     * 清理日志
     *
     * @param clearBeforeTime 多久之前的
     * @param clearBeforeNum  多少条
     * @return boolean
     */
    boolean clearLog(LocalDateTime clearBeforeTime, Integer clearBeforeNum);

    /**
     * 获取登录日志分页
     *
     * @param authUserInfo 全局用户信息
     * @param pageParams   分页查询参数
     * @return Page<LoginLog>
     */
    Page<LoginLog> getLoginLogPage(AuthUserInfo<UserDetail> authUserInfo, PageParams<LoginLogQueryDTO> pageParams);

    /**
     * 删除登录日志
     *
     * @param ids 主键ids
     * @return boolean
     */
    boolean deleteLoginLog(List<Long> ids);
}
