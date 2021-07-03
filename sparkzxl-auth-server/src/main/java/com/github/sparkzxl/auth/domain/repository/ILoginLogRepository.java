package com.github.sparkzxl.auth.domain.repository;

import com.github.pagehelper.PageInfo;
import com.github.sparkzxl.auth.infrastructure.entity.LoginLog;
import com.github.sparkzxl.auth.infrastructure.entity.LoginLogCount;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * description：登录日志 仓储类
 *
 * @author charles.zhou
 * @date 2020/6/17 0017
 */
public interface ILoginLogRepository {

    /**
     * 保存登录日志
     *
     * @param loginLog 日志
     */
    void saveLoginLog(LoginLog loginLog);

    /**
     * 获取系统近十天来的访问记录
     *
     * @param tenDays 10天前
     * @param account 用户账号
     * @return List<LoginLogCount>
     */
    List<LoginLogCount> findLastTenDaysVisitCount(LocalDate tenDays, String account);

    /**
     * 按浏览器来统计数量
     *
     * @return List<LoginLogCount>
     */
    List<LoginLogCount> findByBrowser();

    /**
     * 按操作系统内统计数量
     *
     * @return List<LoginLogCount>
     */
    List<LoginLogCount> findByOperatingSystem();

    /**
     * 清理日志
     *
     * @param clearBeforeTime 时间
     * @param clearBeforeNum  天数
     * @return boolean
     */
    boolean clearLog(LocalDateTime clearBeforeTime, Integer clearBeforeNum);

    /**
     * 分页查询登录日志列表
     *
     * @param pageNum     当前页
     * @param pageSize    分页大小
     * @param userId 领域管理员账号
     * @param account     账户
     * @param startTime   开始时间
     * @param endTime     结束时间
     * @return PageInfo<LoginLog>
     */
    PageInfo<LoginLog> getLoginLogPage(int pageNum, int pageSize, Long userId, String account, Date startTime,
                                       Date endTime);

    /**
     * 删除登录日志
     *
     * @param ids 主键ids
     * @return boolean
     */
    boolean deleteLoginLog(List<Long> ids);
}
