package com.github.sparkzxl.system.admin.domain.convert;

import com.github.sparkzxl.system.admin.infrastructure.entity.LoginLog;
import com.github.sparkzxl.system.admin.api.model.dto.LoginLogDTO;
import com.github.sparkzxl.system.admin.api.model.vo.LoginLogVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

/**
 * <p>
 * 登录日志 转换类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Mapper
public interface LoginLogConvert {

    LoginLogConvert INSTANCE = Mappers.getMapper(LoginLogConvert.class);

    /**
     * loginLogDTO转换为LoginLog
     *
     * @param loginLogDTO 登录日志DTO对象
     * @return LoginLog
     */
    LoginLog convertLoginLog(LoginLogDTO loginLogDTO);

    /**
     * LoginLog转换为LoginLogVO
     *
     * @param loginLog 登录日志DTO对象
     * @return LoginLogVO
     */
    LoginLogVO convertLoginLogVO(LoginLog loginLog);

    /**
     * loginLog列表转换为LoginLogVO列表
     *
     * @param loginLogList 登录日志列表
     * @return List<LoginLogVO>
     */
    List<LoginLogVO> convertLoginLogVOList(List<LoginLog> loginLogList);

    /**
     * 登录日志分页对象转换为LoginLogVO分页对象
     *
     * @param loginLogPage 登录日志分页对象
     * @return Page<LoginLogVO>
     */
    Page<LoginLogVO> convertLoginLogPageVO(Page<LoginLog> loginLogPage);
}
