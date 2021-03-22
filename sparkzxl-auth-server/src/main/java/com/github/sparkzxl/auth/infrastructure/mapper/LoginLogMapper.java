package com.github.sparkzxl.auth.infrastructure.mapper;

import com.github.sparkzxl.auth.infrastructure.entity.LoginLog;
import com.github.sparkzxl.auth.infrastructure.entity.LoginLogCount;
import com.github.sparkzxl.database.base.mapper.SuperMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * description：系统日志
 *
 * @author charles.zhou
 * @date 2020-06-17 11:56:18
 */
@Repository
public interface LoginLogMapper extends SuperMapper<LoginLog> {
    /**
     * 获取系统总访问次数
     *
     * @return Long
     */
    @Select("select count(1) from auth_login_log")
    Long findTotalVisitCount();

    /**
     * 获取系统今日访问次数
     *
     * @param today 今天
     * @return Long
     */
    @Select("select count(1) from auth_login_log where login_date = #{today}")
    Long findTodayVisitCount(@Param("today") LocalDate today);

    /**
     * 获取系统今日访问 IP数
     *
     * @param today 今天
     * @return Long
     */
    @Select("select count(distinct(request_ip)) from auth_login_log where login_date = #{today}")
    Long findTodayIp(@Param("today") LocalDate today);

    /**
     * 获取系统近十天来的访问记录
     *
     * @param tenDays 10天前
     * @param account 用户账号
     * @return 系统近十天来的访问记录
     */
    @Select("<script> "
            + " select login_date , count(1) `count` from\n"
            + "        ( select id, login_date from auth_login_log where login_date >= #{tenDays}\n"
            + "        <if test=\"account != null and account != ''\">\n"
            + "            and account = #{account}\n"
            + "        </if>\n"
            + "        ) as l group by login_date"
            + "</script>")
    List<LoginLogCount> findLastTenDaysVisitCount(@Param("tenDays") LocalDate tenDays, @Param("account") String account);

    /**
     * 按浏览器来统计数量
     *
     * @return
     */
    @Select("select browser, count(id) `count` from auth_login_log group by browser")
    List<LoginLogCount> findByBrowser();

    /**
     * 按操作系统内统计数量
     *
     * @return List<LoginLogCount>
     */
    @Select("select operating_system,count(id) `count` from auth_login_log group by operating_system")
    List<LoginLogCount> findByOperatingSystem();

    /**
     * 清理日志
     *
     * @param clearBeforeTime 多久之前的
     * @param clearBeforeNum  多少条
     * @return boolean
     */
    @Delete("<script> "
            + "delete from auth_login_log"
            + "<trim prefix=\"WHERE\" prefixOverrides=\"AND | OR\">\n"
            + "            <if test=\"clearBeforeTime != null\">\n"
            + "                AND create_time <![CDATA[ <= ]]> #{clearBeforeTime}\n"
            + "            </if>\n"
            + "            <if test=\"clearBeforeNum  != null\">\n"
            + "                AND id NOT in(\n"
            + "                SELECT id FROM(\n"
            + "                SELECT id FROM auth_login_log AS t\n"
            + "                ORDER BY t.create_time desc LIMIT 0, #{clearBeforeNum}\n"
            + "                ) t1\n"
            + "                )\n"
            + "            </if>\n"
            + "        </trim>"
            + "</script>"
    )
    boolean clearLog(@Param("clearBeforeTime") LocalDateTime clearBeforeTime, @Param("clearBeforeNum") Integer clearBeforeNum);
}
